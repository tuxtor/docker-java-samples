package com.vorozco.springboot_client_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trace-demo")
public class TraceDemoController {
    
    @GetMapping
    public String execDemo(){
        return "hola desde nuevo servicio";
    }
    
}