package com.cielo.controller;

import com.cielo.services.HelloService;
import com.cielo.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 63289 on 2017/4/30.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "api")
public class RestHelloController {
    private final HelloService helloService;
    private final TokenService tokenService;

    @Autowired
    public RestHelloController(HelloService helloService, TokenService tokenService) {
        this.helloService = helloService;
        this.tokenService = tokenService;
    }

    @RequestMapping("token/{name}")
    public String token(@PathVariable String name){
        return tokenService.generateToken(name);
    }
    @RequestMapping("name/{name}/{message}")
    public void add(@PathVariable String name,@PathVariable String message){
        helloService.add(name,message);
    }
    @RequestMapping("{token}")
    public String get(@PathVariable String token){
        return helloService.showMessage(tokenService.getName(token));
    }
}
