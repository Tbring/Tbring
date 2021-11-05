package com.example.lvm.Controller;

import com.alibaba.fastjson.JSON;
import com.example.lvm.dao.UserDao;
import com.example.lvm.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


 
@Controller
public class sqlListU {
    @Autowired
    private UserDao userdao;


    @RequestMapping(value = "/userselect", method = RequestMethod.POST)
    @ResponseBody
    public String selectPage(HttpServletResponse httpServletResponse, HttpSession httpSession) throws IOException {
        User user = (User) httpSession.getAttribute("USER-SESSION");
        List<User> users = userdao.selectUser(user.getPermissions());
        String json = "{\"code\":" + 0 + ",\"msg\": \"\"," + "\"count\": " + 1000 + ",\"data\":" + JSON.toJSONString(users) + "}";
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.getWriter().write(json);
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(HttpServletResponse response, @RequestParam Integer id) throws IOException {
        try {
            System.out.println(id);
            int d = userdao.deleteuser(id);


        } catch (Exception e) {
            response.getWriter().write("错误");
        }
        return null;
    }

    @RequestMapping(value = "/updata", method = RequestMethod.POST)
    @ResponseBody
    public String updataUser(HttpServletResponse response, @RequestBody User user) {
        response.setContentType("application/json;charset=utf-8");
        System.out.println(user.toString());
        try {

            userdao.upData(user);

            response.getWriter().write("成功");
        } catch (Exception e) {
            System.out.println("da3");
        }

        return null;
    }

    @RequestMapping(value = "/updataA", method = RequestMethod.POST)
    @ResponseBody
    public String updataUserA(HttpServletResponse response, @RequestBody User user) {
        response.setContentType("application/json;charset=utf-8");
        System.out.println(user.toString());
        try {
            User user1 = userdao.selectUserNameUser(user.getUsername());
            user.setAboutYourself(user1.getAboutYourself());
            user.setDescribeWork(user1.getDescribeWork());
            userdao.upData(user);
            userdao.upDataPermissions(user.getUsername(), user.getPermissions());
            userdao.upDataPassword(user.getUsername(), user.getPassword());
            response.getWriter().write("成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("da3");
        }

        return null;
    }
}
