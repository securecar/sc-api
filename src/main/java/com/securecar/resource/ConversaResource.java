package com.securecar.resource;

import com.securecar.bo.ConversaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class ConversaResource {
    ConversaBO conversaBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        conversaBO = new ConversaBO();
        ArrayList<ConversaTO> resultado = conversaBO.findAll();
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
        conversaBO = new ConversaBO();
        ConversaTO resultado = conversaBO.findById(id);
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
    public Response save(ConversaTO conversa){
        conversaBO = new ConversaBO();
        ConversaTO resultado = conversaBO.save(conversa);
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
        conversaBO = new ConversaBO();
        Response.ResponseBuilder response = null;
        if (conversaBO.delete(id)){
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
    public Response edit(@PathParam("id") Long id , ConversaTO conversa){
        conversaBO = new ConversaBO();
        ConversaTO resultado = conversaBO.edit(id, conversa);
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
