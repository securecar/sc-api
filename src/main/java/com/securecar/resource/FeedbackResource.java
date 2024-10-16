package com.securecar.resource;

import com.securecar.bo.FeedbackBO;
import com.securecar.to.EmailTO;
import com.securecar.to.FeedbackTO;
import com.securecar.to.LogradouroTO;
import com.securecar.to.FeedbackTO;
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
        ArrayList<FeedbackTO> resultado = feedbackBO.findAll();
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
        FeedbackTO resultado = feedbackBO.findById(id);
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
        FeedbackTO resultado = feedbackBO.save(feedback);
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
    public Response delete (Long id){
        feedbackBO = new FeedbackBO();
        Response.ResponseBuilder response = null;
        if (feedbackBO.delete(id)){
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
    public Response edit(@PathParam("id") Long id , FeedbackTO feedback){
        feedbackBO = new FeedbackBO();
        FeedbackTO resultado = feedbackBO.edit(id, feedback);
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
