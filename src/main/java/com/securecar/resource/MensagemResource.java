package com.securecar.resource;

import com.securecar.bo.MensagemBO;
import com.securecar.to.MensagemTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class MensagemResource {
    MensagemBO mensagemBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        mensagemBO = new MensagemBO();
        ArrayList<MensagemTO> resultado = mensagemBO.findAll();
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
    public Response findById(@PathParam("id") Long id){
        mensagemBO = new MensagemBO();
        MensagemTO resultado = mensagemBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(MensagemTO pecaConserto){
        mensagemBO = new MensagemBO();
        MensagemTO resultado = mensagemBO.save(pecaConserto);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);
        } else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id")Long id){
        mensagemBO = new MensagemBO();
        Response.ResponseBuilder response = null;
        if (mensagemBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response edit(@PathParam("id") Long id , MensagemTO peca){
        mensagemBO = new MensagemBO();
        MensagemTO resultado = mensagemBO.edit(id, peca);
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
