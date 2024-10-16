package com.securecar.resource;

import com.securecar.to.FeedbackTO;
import com.securecar.to.LogradouroTO;
import com.securecar.to.PecaTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import oracle.jdbc.proxy.annotation.Post;

import java.util.ArrayList;

public class FeedbackResource {
    FeedbackBO feedbackBO;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        feedbackBO = new FeedbackBO();
        ArrayList<PecaTO> resultado = feedbackBO.findAll();
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
        feedbackBO = new FeedbackBO();
        PecaTO resultado = feedbackBO.findById(id);
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
    public Response save(FeedbackTO feedback){
        feedbackBO = new FeedbackBO();
        PecaTO resultado = feedbackBO.save(feedback);
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
