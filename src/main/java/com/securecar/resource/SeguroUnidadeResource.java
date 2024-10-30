package com.securecar.resource;

import com.securecar.bo.SeguroUnidadeBO;
import com.securecar.to.SeguroUnidadeTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/seguro-unidade")
public class SeguroUnidadeResource {
    SeguroUnidadeBO seguroUnidadeBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("id_seguro") Long idSeguro) {
        seguroUnidadeBO = new SeguroUnidadeBO();
        ArrayList<SeguroUnidadeTO> resultado = null;
        Response.ResponseBuilder response = null;
        if (idSeguro != null && idSeguro > 0) {
            resultado = seguroUnidadeBO.findAllByIdSeguro(idSeguro);
            if (resultado != null) {
                response = Response.ok(resultado);
            } else {
                response = Response.status(404);
            }
        } else {
            resultado = seguroUnidadeBO.findAll();
            if (resultado != null) {
                response = Response.ok(resultado);
            } else {
                response = Response.status(404);
            }
        }
        return response.build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        seguroUnidadeBO = new SeguroUnidadeBO();
        SeguroUnidadeTO resultado = seguroUnidadeBO.findById(id);
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
    public Response save(SeguroUnidadeTO seguro){
        seguroUnidadeBO = new SeguroUnidadeBO();
        SeguroUnidadeTO resultado = seguroUnidadeBO.save(seguro);
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
        seguroUnidadeBO = new SeguroUnidadeBO();
        Response.ResponseBuilder response = null;
        if (seguroUnidadeBO.delete(id)){
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
    public Response edit(@PathParam("id") Long id , SeguroUnidadeTO seguro){
        seguroUnidadeBO = new SeguroUnidadeBO();
        seguro.setIdUnidade(id);
        SeguroUnidadeTO resultado = seguroUnidadeBO.update(seguro);
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
