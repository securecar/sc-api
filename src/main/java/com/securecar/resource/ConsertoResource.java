package com.securecar.resource;

import com.securecar.to.CarroTO;
import com.securecar.to.ConsertoTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class ConsertoResource {
    ConsertoBO consertoBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        consertoBO = new ConsertoBO();
        ArrayList<UsuarioTO> resultado = consertoBO.findAll();
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
        consertoBO = new ConsertoBO();
        UsuarioTO resultado = consertoBO.findById(id);
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
    public Response save(ConsertoTO conserto){
        consertoBO = new ConsertoBO();
        UsuarioTO resultado = consertoBO.save(conserto);
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
