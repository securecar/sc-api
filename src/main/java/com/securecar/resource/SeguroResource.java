package com.securecar.resource;

import com.securecar.to.DadosTO;
import com.securecar.to.SeguroTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class SeguroResource {
    SeguroBO seguroBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        seguroBO = new SeguroBO();
        ArrayList<UsuarioTO> resultado = seguroBO.findAll();
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
        seguroBO = new SeguroBO();
        UsuarioTO resultado = seguroBO.findById(id);
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
    public Response save(SeguroTO seguro){
        seguroBO = new SeguroBO();
        UsuarioTO resultado = seguroBO.save(seguro);
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
