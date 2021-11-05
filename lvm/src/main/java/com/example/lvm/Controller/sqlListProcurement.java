package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lvm.dao.ProcurementDao;
import com.example.lvm.dao.PurchaseDao;
import com.example.lvm.dao.UserDao;
import com.example.lvm.po.Procurement;
import com.example.lvm.po.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

 
@Controller
public class sqlListProcurement {
    @Autowired
    private ProcurementDao procurementdao;

    @Autowired
    private PurchaseDao purchaseDao;

    @RequestMapping(value = "/selectprocurementAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(HttpServletResponse response) {
        List<Procurement> list = procurementdao.selectprocurementAll();
        String json = "{\"name\":" + "\"procurement\"" + ",\"data\":" + JSON.toJSONString(list) + "}";
        System.out.println(json);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/addProcurement", method = RequestMethod.POST)
    @ResponseBody
    public String addProcurement(HttpServletResponse response, @RequestParam("procurmentUser") String procurmentUser, @RequestParam("supplier") String supplier, @RequestParam("Purchase") String purchase) {

        Purchase purchase1 = JSON.parseObject(purchase, Purchase.class);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = simpleDateFormat.format(date);
        dateStr = dateStr.replace("-", "");

        Procurement procurement = new Procurement();
        procurement.setProcurmentUser(procurmentUser);
        procurement.setSupplier(supplier);
        procurement.setPurchasedate(dateStr);

        procurement.setPrice(purchase1.getPrice());
        procurement.setPurchaseId(purchase1.getId());
        procurement.setShop(purchase1.getName());

        try {
            procurementdao.addProcurement(procurement);

            purchaseDao.upDataState(purchase1.getId(), 3);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write("下单成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
