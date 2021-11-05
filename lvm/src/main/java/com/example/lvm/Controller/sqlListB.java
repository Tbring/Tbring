package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.lvm.dao.BorrowDao;
import com.example.lvm.dao.DataDao;
import com.example.lvm.dao.UserDao;
import com.example.lvm.po.Borrow;
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
public class sqlListB {
    @Autowired
    private BorrowDao borrowdao;

    @Autowired
    private DataDao datadao;


    @RequestMapping(value = "/selectdataAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectdataAll(HttpServletResponse response) {
        List<Data> list = datadao.selectdataAll();
        String json = "{\"name\":" + "\"borrow\"" + ",\"data\":" + JSON.toJSONString(list) + "}";
        System.out.println(json);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/selectborrowAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(HttpServletResponse response) {
        List<Borrow> list = borrowdao.selectborrowAll();
        String json = "{\"name\":" + "\"borrow\"" + ",\"data\":" + JSON.toJSONString(list) + "}";
        System.out.println(json);
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping(value = "/addBorrow", method = RequestMethod.POST)
    @ResponseBody
    public String addBorrow(HttpSession session, @RequestParam("data") String data, HttpServletResponse response) {
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject = JSONObject.parseObject(data);
        String brand = jsonObject.getJSONObject("data").getString("brand");
        int dataNumber = jsonObject.getJSONObject("data").getInteger("number");
        int id = jsonObject.getJSONObject("data").getInteger("id");
        String name = jsonObject.getJSONObject("data").getString("name");
        int number = jsonObject.getInteger("number");
        String username = jsonObject.getString("username");
        String section = jsonObject.getString("section");
        String specification = jsonObject.getJSONObject("data").getString("specification");
        User user2 = (User) session.getAttribute("USER-SESSION");
        Borrow borrow = new Borrow();
        date date = new date();
        borrow.setName(name);
        borrow.setAgent(user2.getUsername());
        borrow.setBrand(brand);
        borrow.setNumber(number);
        borrow.setReturnNumber(0);
        borrow.setSpecifications(specification);
        borrow.setSection(section);
        borrow.setBorrowdate(date.date());
        borrow.setUsername(username);
        borrow.setName(name);
        borrow.setDataId(id);


        try {
            Data data1 = datadao.selectdataidAll(id);

            if (data1.getNumber() - number >= 0) {
                datadao.upDataNumber(id, data1.getNumber() - number);
                Data data2 = datadao.selectdataidAll(id);
                if (data2.getNumber() == 0) {
                    datadao.deleteData(id);
                }
            }
            borrowdao.addBorrow(borrow);
            response.getWriter().write("借用成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/deleteBorrow", method = RequestMethod.POST)
    @ResponseBody
    public String deleteBorrow(HttpServletResponse response, @RequestParam("data") String data) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject = JSONObject.parseObject(data);
        int number = jsonObject.getInteger("number");//
        int id = jsonObject.getJSONObject("data").getInteger("id");
        int dataId = jsonObject.getJSONObject("data").getInteger("dataId");
        int dataNumber = jsonObject.getJSONObject("data").getInteger("number");
        try {
            System.out.println(data);
            Data data1 = datadao.selectdataidAll(dataId);
            datadao.upDataNumber(dataId, data1.getNumber() + number);
            Data data2 = datadao.selectdataidAll(dataId);
            System.out.println(data2.toString());
            if (dataNumber - number == 0) {
                borrowdao.deleteBorrow(id);
            }
            borrowdao.upborrowNumber(id, dataNumber - number);
            response.getWriter().write("归还成功");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("领用失败");
        }
        return null;
    }
}
