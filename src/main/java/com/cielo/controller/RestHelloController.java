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

    @RequestMapping(value = "token",method = RequestMethod.POST)
    public String token(String name){
        return tokenService.generateToken(name);
    }
    @RequestMapping(value = "name",method = RequestMethod.POST)
    public void add(String name,String message){
        helloService.add(name,message);
    }
    @RequestMapping(value = "{token}",method = RequestMethod.GET)
    public String get(@PathVariable String token){
        return helloService.showMessage(tokenService.getName(token));
    }
}
