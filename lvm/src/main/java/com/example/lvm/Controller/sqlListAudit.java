package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lvm.dao.AuditDao;
import com.example.lvm.dao.PurchaseDao;
import com.example.lvm.dao.ReceiveDao;
import com.example.lvm.po.Audit;
import com.example.lvm.po.Purchase;
import com.example.lvm.po.Receive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


 
@Controller
public class sqlListAudit {
    @Autowired
    private ReceiveDao receivedao;

    @Autowired
    private PurchaseDao purchasedao;

    @Autowired
    private AuditDao auditdao;


    @RequestMapping(value = "/selectStateAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectStateAll(HttpServletResponse response) {
        List<Audit> list = auditdao.selectauditAll();

        String json = "{\"name\":" + "\"audit\"" + ",\"data\":" + JSON.toJSONString(list) + "}";
        System.out.println(json);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/upaudit", method = RequestMethod.POST)
    @ResponseBody
    public String upaudit(HttpServletResponse response, @RequestParam("data") String audit) {


        JSONObject jsonObject = JSONObject.parseObject(audit);
        int dataId = jsonObject.getInteger("dataId");
        String name = jsonObject.getString("name");
        int state = jsonObject.getInteger("state");
        String submitTime = jsonObject.getString("submitTime");
        Audit audit1 = new Audit();
        audit1.setSubmitTime(submitTime);
        audit1.setName(name);
        audit1.setDataId(dataId);
        audit1.setState(state);

        if (audit1.getName().equals("申购申请")) {
            purchasedao.upDataState(audit1.getDataId(), audit1.getState());
            auditdao.deleteAudit(audit1.getDataId());
        } else if (audit1.getName().equals("领用申请")) {
            receivedao.upReceiveState(audit1.getDataId(), audit1.getState());
            auditdao.deleteAudit(audit1.getDataId());
        }
        return null;
    }
}
