package com.securecar.resource;

import com.securecar.bo.CarroBO;
import com.securecar.to.CarroTO;
import com.securecar.to.UsuarioTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class CarroResource {
    CarroBO carroBO;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        carroBO = new CarroBO();
        ArrayList<CarroTO> resultado = carroBO.findAll();
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
        carroBO = new CarroBO();
        CarroTO resultado = carroBO.findById(id);
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
    public Response save(CarroTO carro){
        carroBO = new CarroBO();
        CarroTO resultado = carroBO.save(carro);
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
