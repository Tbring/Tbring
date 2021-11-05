package com.example.lvm.Controller;


import com.alibaba.fastjson.JSON;
import com.example.lvm.dao.AuditDao;
import com.example.lvm.dao.PurchaseDao;
import com.example.lvm.po.Audit;
import com.example.lvm.po.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

 
@Controller
public class SqlListPurchase {
    @Autowired
    private PurchaseDao purchasedao;

    @Autowired
    private AuditDao auditdao;


    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(HttpServletResponse response) {
        List<Purchase> list = purchasedao.selectAll();
        String json = "{\"name\":" + "\"purchase\"" + ",\"data\":" + JSON.toJSONString(list) + "}";

        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/selectstateAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectstateAll(HttpServletResponse response) {
        List<Purchase> list = purchasedao.selectstateAll();
        String json = "{\"name\":" + "\"purchase\"" + ",\"data\":" + JSON.toJSONString(list) + "}";

        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/addPurchase", method = RequestMethod.POST)
    @ResponseBody
    public String addDataPurchase(HttpServletResponse response, @RequestBody Purchase purchase) {

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        dateStr = dateStr.replace("-", "");
        try {
            purchase.setPurchasedate(dateStr);
            Audit audit = new Audit();
            audit.setSubmitTime(dateStr);
            purchasedao.addPurchase(purchase);
            Purchase purchase1 = purchasedao.selectnameAll(purchase.getName());
            audit.setAuditname("tom");
            audit.setDataId(purchase1.getId());
            audit.setState(1);
            audit.setName("领用申请");

            auditdao.addAudit(audit);
            response.getWriter().write("成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
