package com.securecar.resource;

import com.securecar.bo.CarroBO;
import com.securecar.bo.CarroBO;
import com.securecar.to.CarroTO;
import com.securecar.to.CarroTO;
import com.securecar.to.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;


@Path("/carro")
public class CarroResource {
    CarroBO carroBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(@QueryParam("id_usuario") Long idUsuario) {
        carroBO = new CarroBO();
        ArrayList<CarroTO> resultado;
        Response.ResponseBuilder response;

        if (idUsuario != null && idUsuario > 0) {
            resultado = carroBO.findAllByIdUsuario(idUsuario);
        } else {
            resultado = carroBO.findAll();
        }

        if (resultado != null && !resultado.isEmpty()) {
            response = Response.ok(resultado);
        } else {
            response = Response.status(404);
        }

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
    public Response save(@Valid CarroTO carro){
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

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") Long id){
        carroBO = new CarroBO();
        Response.ResponseBuilder response = null;
        if (carroBO.delete(id)){
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
    public Response update(@PathParam("id") Long id , @Valid CarroTO carro){
        carroBO = new CarroBO();
        carro.setIdCarro(id);
        CarroTO resultado = carroBO.update(carro);
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
