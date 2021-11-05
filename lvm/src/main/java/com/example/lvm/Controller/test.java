package com.example.lvm.Controller;





import com.example.lvm.dao.UserDao;
import com.example.lvm.po.User;
import com.example.lvm.toolFunction.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class test {

    @Autowired
    private UserDao userdao;


    //登录
    @RequestMapping(value = "/loging", method = RequestMethod.GET)
    public String toLogin() throws Exception {

        return "/LVMlogin";
    }

    //    登录
    @RequestMapping(value = "/loging", method = RequestMethod.POST)
    public String Login(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession) throws Exception {
        System.out.println("启动");
        httpServletRequest.setCharacterEncoding("utf-8");
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        try {
            User user = userdao.selectUserNameUser(username);
            user.setAvatars("");
            if (user.getPassword().equals(password)) {
                httpSession.setAttribute("USER-SESSION", user);
                rewriteState rewriteState = new rewriteState();
                //检查用户是否登录
                Cookie[] listCookies = httpServletRequest.getCookies();
                for (Cookie cookie : listCookies) {
                    if (cookie.getName().equals(user.getUsername() + "Counter")) {
                        //用户已经登录
                        System.out.println("用户已经登录");
                        String code = rewriteState.rewriteState();
                        cookie.setValue(code);
                        System.err.println("用户已经登录" + code);
//
//                        数据库
                        User user2 = (User) httpSession.getAttribute("USER-SESSION");
                        Date date = new Date();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
                        userdao.upDataLoginTime(user2.getUsername(),format.format(date));
                        userdao.upDataIpaddress(user2.getUsername(),IpUtil.getIpAddr(httpServletRequest));
                        userdao.upDataState(user2.getUsername(), code);
                        return "redirect:/index.html";
                    }
                }


                String code = rewriteState.rewriteState();
                Cookie hit = new Cookie(user.getUsername() + "Counter", code);
                hit.setHttpOnly(true);//如果设置了"HttpOnly"属性，那么通过程序(JS脚本、Applet等)将无法访问该Cookie
                hit.setMaxAge(60 * 60);//设置生存期为1小时
                User user2 = (User) httpSession.getAttribute("USER-SESSION");
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
                System.out.println(user2.getUsername() +"   "+ format.format(date));
                userdao.upDataLoginTime(user2.getUsername(),format.format(date));
                userdao.upDataIpaddress(user2.getUsername(),IpUtil.getIpAddr(httpServletRequest));
                userdao.upDataState(user2.getUsername(), code);

                System.err.println("用户第一次登录" + code);
//		        hit.setDomain("www.zifansky.cn");//子域，在这个子域下才可以访问该Cookie
//		        hit.setPath("/hello");//在这个路径下面的页面才可以访问该Cookie
//		        hit.setSecure(true);//如果设置了Secure，则只有当使用https协议连接时cookie才可以被页面访问
//
                httpServletResponse.addCookie(hit);

                return "redirect:/index.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/loging";
        }
        return "redirect:/loging";


    }

    //    注册
    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public String registeredGet() {

        return "redirect:/form-1/index.html";
    }

    //    注册
    @RequestMapping(value = "/registered", method = RequestMethod.POST)
    public String registered(@RequestBody User user) {
        date date = new date();

        try {
            user.setUsername(date.date());
            System.err.println(user);
            int user1 = userdao.addUser(user);
            System.out.println(user1);
            return "";
        } catch (Exception e) {
            System.out.println("错误");
            e.printStackTrace();
            return "redirect:/registered";
        }
    }

    @RequestMapping(value = "/loutlogin", method = RequestMethod.POST)
    public String loutLogin(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        session.invalidate();

        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("hitCounter")) {
                    Cookie cookie = new Cookie("hitCounter", "");//这边得用"",不能用null
                    cookie.setPath("/");//设置成跟写入cookies一样的
                    // cookie.setDomain(".wangwz.com");//设置成跟写入cookies一样的
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        System.out.println("跳转");
        return "redirect:/loging";
    }


    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public User index(HttpSession httpSession, HttpServletRequest request) {

//        System.out.println("******************************");
//        if (request.getHeader("x-forwarded-for") == null) {
//            System.out.println(request.getRemoteAddr());
//        }else {
//            System.out.println(request.getHeader("x-forwarded-for"));
//        }


        User user2 = (User) httpSession.getAttribute("USER-SESSION");
        try {
            User user = userdao.selectUserNameUser(user2.getUsername());

            return user;
        } catch (Exception e) {

        }
        return null;


    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toindex() {
        return "/index";

    }


}
