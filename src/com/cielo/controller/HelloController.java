package com.cielo.controller;

import com.cielo.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 63289 on 2017/2/22.
 */
@Controller
@RequestMapping("Hello")
public class HelloController {
    @Autowired
    public HelloService helloService;
    @RequestMapping("add")
    public String add(){
        helloService.addByName(new String("zhangsan"));
        return "success";
    }
}
