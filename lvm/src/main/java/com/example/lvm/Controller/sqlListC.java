package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lvm.dao.*;
import com.example.lvm.po.Checkincoming;
import com.example.lvm.po.Data;
import com.example.lvm.po.Procurement;
import com.example.lvm.po.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
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
public class sqlListC {
    @Autowired
    private CheckincomingDao checkincomingdao;

    @Autowired
    private ProcurementDao procurementdao;

    @Autowired
    private PurchaseDao purchaseDao;

    @Autowired
    private DataDao dataDao;

    @RequestMapping(value = "/selectpurchaseDaoAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectpurchaseDaoAll(HttpServletResponse response, @RequestParam("id") int id) {
        Purchase list = purchaseDao.selectidAll(id);
        String json = "{\"name\":" + "\"purchase\"" + ",\"data\":" + JSON.toJSONString(list) + "}";

        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/selectcheckincomingAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(HttpServletResponse response) {
        List<Procurement> list = procurementdao.selectprocurementAll();
        String json = "{\"name\":" + "\"checkincoming\"" + ",\"data\":" + JSON.toJSONString(list) + "}";

        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/addCheckincomingData", method = RequestMethod.POST)
    @ResponseBody
    public String addCheckincomingData(HttpServletResponse response, @RequestParam("data") String data) throws IOException {

        try {
            JSONObject jsonObject = JSONObject.parseObject(data);
            int price = (int) jsonObject.getJSONObject("data").get("price");
            int procurementId = (int) jsonObject.getJSONObject("data").get("id");
            int purchaseId = (int) jsonObject.getJSONObject("data").get("purchaseId");
            String dateofproduction = (String) jsonObject.getJSONObject("checkincomingData").get("dateofproduction");
            int inventoryquantity = Integer.parseInt((String) jsonObject.getJSONObject("checkincomingData").get("inventoryquantity"));
            String expirationdate = (String) jsonObject.getJSONObject("checkincomingData").get("expirationdate");
            String designatedarea = (String) jsonObject.getJSONObject("checkincomingData").get("designatedarea");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = simpleDateFormat.format(date);
            dateStr = dateStr.replace("-", "");

            Data data1 = new Data();

            Purchase purchase = purchaseDao.selectidAll(purchaseId);
            data1.setName(purchase.getName());
            data1.setBrand(purchase.getBrand());
            data1.setDesignatedarea(expirationdate);
            data1.setNumber(inventoryquantity);
            data1.setOfproductiondate(dateofproduction);
            data1.setReviewer((String) jsonObject.getJSONObject("data").get("procurmentUser"));
            data1.setStorageTime(designatedarea);
            data1.setPrice(price);
            data1.setSpecification(purchase.getSpecification());
            data1.setPurchasingTime(dateStr);
            data1.setType(purchase.getType());
            System.out.println(data1.toString());
//            商品入库
            int d = dataDao.addData(data1);

//             采购表数据清理
            procurementdao.deleteProcurement(procurementId);
//             申购表数据清理
            purchaseDao.deletePurchase(purchaseId);

        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("入库失败");
            return null;
        }


        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("入库成功");
        return null;
    }
}
