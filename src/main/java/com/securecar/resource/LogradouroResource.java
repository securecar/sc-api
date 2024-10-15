package com.securecar.resource;

import com.securecar.to.EmailTO;
import com.securecar.to.LogradouroTO;
import com.securecar.to.PecaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

public class LogradouroResource {
    LogradouroBO logradouroBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        logradouroBO = new LogradouroBO();
        ArrayList<PecaTO> resultado = logradouroBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        logradouroBO = new LogradouroBO();
        PecaTO resultado = logradouroBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(LogradouroTO logradouro){
        logradouroBO = new LogradouroBO();
        PecaTO resultado = logradouroBO.save(logradouro);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }
}
