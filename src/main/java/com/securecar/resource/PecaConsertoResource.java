package com.securecar.resource;

import com.securecar.bo.PecaConsertoBO;

import com.securecar.to.PecaConsertoTO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class PecaConsertoResource {
    PecaConsertoBO pecaConsertoBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        pecaConsertoBO = new PecaConsertoBO();
        ArrayList<PecaConsertoTO> resultado = pecaConsertoBO.findAll();
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
        pecaConsertoBO = new PecaConsertoBO();
        PecaConsertoTO resultado = pecaConsertoBO.findById(id);
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
    public Response save(PecaConsertoTO pecaConserto){
        pecaConsertoBO = new PecaConsertoBO();
        PecaConsertoTO resultado = pecaConsertoBO.save(pecaConserto);
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
        pecaConsertoBO = new PecaConsertoBO();
        Response.ResponseBuilder response = null;
        if (pecaConsertoBO.delete(id)){
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
    public Response edit(@PathParam("id") Long id , PecaConsertoTO peca){
        pecaConsertoBO = new PecaConsertoBO();
        PecaConsertoTO resultado = pecaConsertoBO.edit(id, peca);
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
