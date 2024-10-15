package com.securecar.resource;

import com.securecar.to.DadosTO;
import com.securecar.to.IncidenteTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class DadosResource {
    DadosBO dadosBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        dadosBO = new DadosBO();
        ArrayList<UsuarioTO> resultado = dadosBO.findAll();
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
        dadosBO = new DadosBO();
        UsuarioTO resultado = dadosBO.findById(id);
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
    public Response save(DadosTO dados){
        dadosBO = new DadosBO();
        UsuarioTO resultado = dadosBO.save(dados);
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
