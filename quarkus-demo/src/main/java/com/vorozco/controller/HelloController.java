package com.vorozco.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.UnknownHostException;

@Path("/hello")
@ApplicationScoped
public class HelloController {

    @GET
    public String sayHello() throws UnknownHostException {

        //Get local IP
        String ip = java.net.InetAddress.getLocalHost().getHostAddress();

        return "Hola desde Quarkus en " + ip;
    }
}
