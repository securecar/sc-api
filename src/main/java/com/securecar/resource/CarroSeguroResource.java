package com.securecar.resource;

import com.securecar.bo.CarroSeguroBO;
import com.securecar.to.CarroSeguroTO;
import com.securecar.to.EmailTO;
import com.securecar.to.PecaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

public class CarroSeguroResource {
    CarroSeguroBO carroSeguroBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        carroSeguroBO = new CarroSeguroBO();
        ArrayList<PecaTO> resultado = carroSeguroBO.findAll();
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
        carroSeguroBO = new CarroSeguroBO();
        PecaTO resultado = carroSeguroBO.findById(id);
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


    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(CarroSeguroTO carroSeguro){
        carroSeguroBO = new CarroSeguroBO();
        PecaTO resultado = carroSeguroBO.save(carroSeguro);
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
