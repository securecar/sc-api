package com.securecar.resource;

import com.securecar.bo.EmailBO;
import com.securecar.bo.PecaBO;
import com.securecar.to.EmailTO;
import com.securecar.to.PecaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

public class EmailResource {
    EmailBO emailBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        emailBO = new EmailBO();
        ArrayList<EmailTO> resultado = emailBO.findAll();
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
        emailBO = new EmailBO();
        EmailTO resultado = emailBO.findById(id);
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
    public Response save(EmailTO email){
        emailBO = new EmailBO();
        EmailTO resultado = emailBO.save(email);
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(Long id , EmailTO email){
        emailBO = new EmailBO();
        EmailTO resultado = emailBO.edit(id, email);
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
