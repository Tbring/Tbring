package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lvm.dao.RecipientstoReturnDao;
import com.example.lvm.dao.UserDao;
import com.example.lvm.po.Purchase;
import com.example.lvm.po.RecipientstoReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

 
@Controller
public class sqlListRecipientstoReturn {
    @Autowired
    private RecipientstoReturnDao recipientstoreturndao;

    @RequestMapping(value = "/selectrecipientstoreturnAll", method = RequestMethod.GET)
    @ResponseBody
    public String selectAll(HttpServletResponse response) {
        List<RecipientstoReturn> list = recipientstoreturndao.selectrecipientstoreturnAll();
        String json = "{\"name\":" + "\"recipientstoreturn\"" + ",\"data\":" + JSON.toJSONString(list) + "}";

        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
