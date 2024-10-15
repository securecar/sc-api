package com.securecar.resource;

import com.securecar.to.ConsertoTO;
import com.securecar.to.IncidenteTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class IncidenteResource {
    IncidenteBO incidenteBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        incidenteBO = new IncidenteBO();
        ArrayList<UsuarioTO> resultado = incidenteBO.findAll();
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
        incidenteBO = new IncidenteBO();
        UsuarioTO resultado = incidenteBO.findById(id);
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
    public Response save(IncidenteTO incidente){
        incidenteBO = new IncidenteBO();
        UsuarioTO resultado = incidenteBO.save(incidente);
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
