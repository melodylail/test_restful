package com.rest.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/query")
public class Query {
	@POST
    @Consumes(MediaType.APPLICATION_JSON)  
    @Produces(MediaType.APPLICATION_JSON)  
    //public Response query(Request req) {
        //sSystem.out.println(req.getQuery()); 
	public Response query(String req) {
        System.out.println(req);
          
        Response resp = new Response();  
        resp.setRespCode(0);  
    //    resp.setRespDesc(req.getQuery());  
		resp.setRespDesc(req);
        return resp;  
    }  
}
