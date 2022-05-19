package com.vorozco.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.UnknownHostException;

@Path("/hello")
public class HelloController {

    @GET
    public String sayHello() throws UnknownHostException {

        //Get local IP
        String ip = java.net.InetAddress.getLocalHost().getHostAddress();

        return "Hola desde Payara en " + ip;
    }
}
