package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lvm.dao.AuditDao;
import com.example.lvm.dao.DataDao;
import com.example.lvm.dao.ReceiveDao;
import com.example.lvm.dao.UserDao;
import com.example.lvm.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

 
@Controller
public class sqlListReceive {
    @Autowired
    private ReceiveDao receivedao;
    @Autowired
    private DataDao datadao;

    @Autowired
    private AuditDao auditdao;

    @RequestMapping(value = "/selectreceiveAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(HttpServletResponse response) {
        List<Receive> list = receivedao.selectreceiveAll();
        String json = "{\"name\":" + "\"receive\"" + ",\"data\":" + JSON.toJSONString(list) + "}";
        System.out.println(json);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/selectreceivestateAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectreceiveidAll(HttpServletResponse response) {
        List<Receive> list = receivedao.selectreceivestateAll(2);
        String json = "{\"name\":" + "\"outreceive\"" + ",\"data\":" + JSON.toJSONString(list) + "}";
        System.out.println(json);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/addReceive", method = RequestMethod.POST)
    @ResponseBody
    public String addReceive(HttpServletResponse response, @RequestParam("data") String data) throws IOException {
        response.setContentType("application/json;charset=utf-8");

        JSONObject jsonObject = JSONObject.parseObject(data);
        String name = (String) jsonObject.getJSONObject("data").get("name");
        int dataId = (int) jsonObject.getJSONObject("data").get("id");
        String brand = (String) jsonObject.getJSONObject("data").get("brand");
        String specification = (String) jsonObject.getJSONObject("data").get("specification");
        int datareturn = jsonObject.getInteger("datareturn");
        String returndate = jsonObject.getString("returndate");
        int number = jsonObject.getInteger("number");
        String username = jsonObject.getString("username");

        date date = new date();
        Receive receive = new Receive();
        receive.setName(name);
        receive.setBrand(brand);
        receive.setDatareturn(datareturn);
        receive.setSpecification(specification);
        receive.setReturndate(returndate);
        receive.setUsername(username);
        receive.setRecipientsdate(date.date());
        receive.setNumber(number);
        receive.setDataId(dataId);

        try {
            Data data1 = datadao.selectdataidAll(dataId);
            if (data1.getNumber() - number >= 0) {
                receivedao.addReceive(receive);
                Receive receive1 = receivedao.selectreceiveidAll(receive.getId());
                Audit audit = new Audit();
                audit.setAuditname("tom");
                audit.setState(1);
                audit.setDataId(receive1.getId());
                audit.setName("领用申请");
                audit.setSubmitTime(date.date());
                auditdao.addAudit(audit);
                response.getWriter().write("领用成功");
            }


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("领用失败");
        }


        return null;
    }

    //              领用出库
    @RequestMapping(value = "/deleteReceive", method = RequestMethod.POST)
    @ResponseBody
    public String deleteReceive(HttpServletResponse response, @RequestParam("data") String data) {
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject = JSONObject.parseObject(data);
        int id = jsonObject.getJSONObject("Purchase").getInteger("id");
        int number = jsonObject.getJSONObject("Purchase").getInteger("number");
        int dataId = jsonObject.getJSONObject("Purchase").getInteger("dataId");

        try {
            Data data1 = datadao.selectdataidAll(dataId);

            if (data1.getNumber() - number >= 0) {
                datadao.upDataNumber(dataId, data1.getNumber() - number);
                Data data2 = datadao.selectdataidAll(dataId);


                if (data2.getNumber() == 0) {
                    datadao.deleteData(dataId);
                }
                receivedao.deleteReceive(id);
                response.getWriter().write("出库成功");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
