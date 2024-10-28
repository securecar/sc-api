package com.securecar.resource;

import com.securecar.bo.ContatoBO;
import com.securecar.to.ContatoTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

public class ContatoResource {
    ContatoBO contatoBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        contatoBO = new ContatoBO();
        ArrayList<ContatoTO> resultado = contatoBO.findAll();
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
        contatoBO = new ContatoBO();
        ContatoTO resultado = contatoBO.findById(id);
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
    public Response save(ContatoTO contato){
        contatoBO = new ContatoBO();
        ContatoTO resultado = contatoBO.save(contato);
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

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id){
        contatoBO = new ContatoBO();
        Response.ResponseBuilder response = null;
        if (contatoBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id , ContatoTO contato){
        contatoBO = new ContatoBO();
        contato.setIdContato(id);
        ContatoTO resultado = contatoBO.update(contato);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);
        }
        else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
