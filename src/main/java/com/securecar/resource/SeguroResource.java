package com.securecar.resource;


import com.securecar.bo.SeguroBO;


import com.securecar.to.SeguroTO;

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
        ArrayList<SeguroTO> resultado = seguroBO.findAll();
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
        SeguroTO resultado = seguroBO.findById(id);
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
        SeguroTO resultado = seguroBO.save(seguro);
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
        seguroBO = new SeguroBO();
        Response.ResponseBuilder response = null;
        if (seguroBO.delete(id)){
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
    public Response edit(@PathParam("id") Long id , SeguroTO seguro){
        seguroBO = new SeguroBO();
        SeguroTO resultado = seguroBO.edit(id, seguro);
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
