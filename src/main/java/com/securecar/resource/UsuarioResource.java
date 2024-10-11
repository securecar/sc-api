package com.securecar.resource;


import com.securecar.bo.UsuarioBO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/usuarios")
public class UsuarioResource {
    UsuarioBO usuarioBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        usuarioBO = new UsuarioBO();
        ArrayList<UsuarioTO> resultado = usuarioBO.findAll();
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
        usuarioBO = new UsuarioBO();
        UsuarioTO resultado = usuarioBO.findById(id);
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
    public Response save(UsuarioTO usuarioTO){
        usuarioBO = new UsuarioBO();
        UsuarioTO resultado = usuarioBO.save(usuarioTO);
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
