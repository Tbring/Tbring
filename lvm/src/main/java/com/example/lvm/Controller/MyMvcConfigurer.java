
package com.example.lvm.Controller;

import org.springframework.web.servlet.config.annotation.*;

public class MyMvcConfigurer
    implements WebMvcConfigurer
{

    public MyMvcConfigurer()
    {
    }

    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
}
