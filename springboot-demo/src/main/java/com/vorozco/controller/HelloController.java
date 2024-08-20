package com.vorozco.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String sayHello() throws UnknownHostException {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Get local IP
        String ip = java.net.InetAddress.getLocalHost().getHostAddress();

        return "JKube es genial " + ip;
    }
}
