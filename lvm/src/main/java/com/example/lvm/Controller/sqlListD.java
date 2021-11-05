package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lvm.dao.DataDao;
import com.example.lvm.dao.UserDao;
import com.example.lvm.po.Data;
import com.example.lvm.po.Purchase;
import com.example.lvm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

 
@Controller
public class sqlListD {
    @Autowired
    private DataDao datadao;


    @RequestMapping(value = "/addData", method = RequestMethod.POST)
    @ResponseBody
    public String putInStorage(@RequestBody Data data, HttpServletResponse response) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        dateStr = dateStr.replace("-", "");
        try {
            Data data1 = data;
            data1.setPurchasingTime(dateStr);
            data1.setReviewer("直接入库");

            response.getWriter().write("入库成功");
            int T = datadao.addData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping(value = "/outbound", method = RequestMethod.POST)
    @ResponseBody
    public String inventory(HttpServletResponse httpServletResponse) throws IOException {

        List<Data> dataList = datadao.selectdataAll();
        String json = "{\"code\":" + 0 + ",\"msg\": \"\"," + "\"count\": " + 1000 + ",\"data\":" + JSON.toJSONString(dataList) + "}";
        httpServletResponse.setContentType("application/json;charset=utf-8");

        httpServletResponse.getWriter().write(json);
        return null;
    }

    @RequestMapping(value = "/outbound", method = RequestMethod.GET)
    @ResponseBody
    public String inventoryGet(HttpServletResponse httpServletResponse) throws IOException {

        List<Data> dataList = datadao.selectdataAll();
        String json = "{\"name\":" + "\"outbound\"" + ",\"data\":" + JSON.toJSONString(dataList) + "}";
        httpServletResponse.setContentType("application/json;charset=utf-8");

        httpServletResponse.getWriter().write(json);
        return null;
    }

    @RequestMapping(value = "/selectdataidAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectdataidAll(HttpServletResponse response, @RequestParam("id") int id) {
        Data list = datadao.selectdataidAll(id);
        String json = "{\"name\":" + "\"Data\"" + ",\"data\":" + JSON.toJSONString(list) + "}";

        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/deleteData", method = RequestMethod.GET)
    @ResponseBody
    public String deleteData(HttpServletResponse response, @RequestParam("id") int id, @RequestParam("number") int number) throws IOException {
        try {
            System.out.println(number);
            Data data1 = datadao.selectdataidAll(id);
            if (data1.getNumber() - number >= 0) {
                //这个要出库做，
                datadao.upDataNumber(id, data1.getNumber() - number);
                Data data2 = datadao.selectdataidAll(id);

                if (data2.getNumber() == 0) {
                    datadao.deleteData(id);
                }


                response.getWriter().write("领用成功");
            }


        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("领用失败");
        }


        return null;
    }


}
