package com.securecar.resource;

import com.securecar.bo.EnderecoBO;
import com.securecar.to.EnderecoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/endereco")
public class EnderecoResource {
    EnderecoBO enderecoBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        enderecoBO = new EnderecoBO();
        ArrayList<EnderecoTO> resultado = enderecoBO.findAll();
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
        enderecoBO = new EnderecoBO();
        EnderecoTO resultado = enderecoBO.findById(id);
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
    public Response save(@Valid EnderecoTO endereco){
        enderecoBO = new EnderecoBO();
        EnderecoTO resultado = enderecoBO.save(endereco);
        Response.ResponseBuilder response = null;
        if (resultado != null){
            response = Response.ok();
        }
        else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id){
        enderecoBO = new EnderecoBO();
        Response.ResponseBuilder response = null;
        if (enderecoBO.delete(id)){
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
    public Response update(@PathParam("id") Long id , EnderecoTO contato){
        enderecoBO = new EnderecoBO();
        contato.setIdEndereco(id);
        EnderecoTO resultado = enderecoBO.update(contato);
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
