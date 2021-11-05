//package com.example.lvm.interceptor;
//
//
//import com.example.lvm.dao.UserDao;
//import com.example.lvm.po.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//public class loginInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private UserDao userdao;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String utl = request.getRequestURI();
//        System.out.println(utl);
//        String data = utl;
//        if (utl.equals("/LVM/")) {
//            response.sendRedirect("/LVM/index");
//            return false;
//        }
//        ;
//        if (data.contains("css") || data.contains("fonts")
//                || data.contains("img") || data.contains("images")
//                || data.contains("js") || data.contains("ico")) {
//            return true;
//        }
//
//        if (utl.equals("/LVM/LVMlogin.html")
//                || utl.equals("/LVM/form-1/index.html")
//                || utl.equals("/LVM/loging")
//                || utl.equals("/LVM/registered")
//                || utl.equals("/LVM/index")
//                || utl.equals("/LVM/index.html")
//                || utl.equals("/LVM/test/index.html")
//        ) {
//            return true;
//        }
//
//        HttpSession httpSession = request.getSession();
//        User user = (User) httpSession.getAttribute("USER-SESSION");
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null && user != null) {
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals(user.getUsername() + "Counter")) {
////                    String code= userdao.selectState(user.getUsername());
////                    if (cookie.getValue().equals(code)) {
//                    return true;
////                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
