package com.vorozco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() throws UnknownHostException {

        //Get local IP
        String ip = java.net.InetAddress.getLocalHost().getHostAddress();

        return "Hola desde Spring Boot en " + ip;
    }
}
