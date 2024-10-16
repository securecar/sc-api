package com.securecar.resource;

import com.securecar.to.DadosTO;
import com.securecar.to.TelefoneTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class TelefoneResource {
    TelefoneBO telefoneBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        telefoneBO = new TelefoneBO();
        ArrayList<UsuarioTO> resultado = telefoneBO.findAll();
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
        telefoneBO = new TelefoneBO();
        UsuarioTO resultado = telefoneBO.findById(id);
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
    public Response save(TelefoneTO telefone){
        telefoneBO = new TelefoneBO();
        UsuarioTO resultado = telefoneBO.save(telefone);
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
