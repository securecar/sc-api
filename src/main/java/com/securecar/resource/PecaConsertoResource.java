package com.securecar.resource;

import com.securecar.to.DadosTO;
import com.securecar.to.PecaConsertoTO;
import com.securecar.to.UsuarioTO;
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
        ArrayList<UsuarioTO> resultado = pecaConsertoBO.findAll();
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
        UsuarioTO resultado = pecaConsertoBO.findById(id);
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
        UsuarioTO resultado = pecaConsertoBO.save(pecaConserto);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);
        } else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}