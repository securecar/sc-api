package com.securecar.resource;

import com.securecar.bo.PecaBO;
import com.securecar.bo.PecaBO;
import com.securecar.bo.PecaBO;
import com.securecar.to.PecaTO;
import com.securecar.to.PecaTO;
import com.securecar.to.PecaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

@Path("/peca")
public class PecaResource {
    PecaBO pecaBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        pecaBO = new PecaBO();
        ArrayList<PecaTO> resultado = pecaBO.findAll();
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
        pecaBO = new PecaBO();
        PecaTO resultado = pecaBO.findById(id);
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
    public Response save(PecaTO peca){
        pecaBO = new PecaBO();
        PecaTO resultado = pecaBO.save(peca);
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

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Long id , PecaTO peca){
        pecaBO = new PecaBO();
        peca.setIdPeca(id);
        PecaTO resultado = pecaBO.update(peca);
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

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id){
        pecaBO = new PecaBO();
        Response.ResponseBuilder response = null;
        if (pecaBO.delete(id)){
            response = Response.status(204);
        }
        else{
            response = Response.status(404);
        }
        return response.build();
    }
}
