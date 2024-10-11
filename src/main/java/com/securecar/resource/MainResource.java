package com.securecar.resource;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class MainResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWord(){
        return "Olá mundo!";
    }
}
