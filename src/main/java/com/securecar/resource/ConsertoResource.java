package com.securecar.resource;

import com.securecar.bo.ConsertoBO;
import com.securecar.bo.ContatoBO;
import com.securecar.bo.PecaBO;
import com.securecar.to.*;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/conserto")
public class ConsertoResource {
    ConsertoBO consertoBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        consertoBO = new ConsertoBO();
        ArrayList<ConsertoTO> resultado = consertoBO.findAll();
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id){
        consertoBO = new ConsertoBO();
        ConsertoTO resultado = consertoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}/pecas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPecas(@PathParam("id") Long id){
        PecaBO pecaBO = new PecaBO();
        ArrayList<PecaTO> resultado = pecaBO.findAllByIdConserto(id);
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid ConsertoTO conserto){
        consertoBO = new ConsertoBO();
        ConsertoTO resultado = consertoBO.save(conserto);
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
    public Response delete (@PathParam("id") Long id){
        consertoBO = new ConsertoBO();
        Response.ResponseBuilder response = null;
        if (consertoBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id , @Valid ConsertoTO conserto){
        consertoBO = new ConsertoBO();
        conserto.setIdConserto(id);
        ConsertoTO resultado = consertoBO.update(conserto);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.created(null);
        }
        else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
