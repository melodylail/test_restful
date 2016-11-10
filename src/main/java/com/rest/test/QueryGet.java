package com.rest.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/query-get")
public class QueryGet {
	@GET
    @Produces(MediaType.APPLICATION_JSON)  
    //public Response query(Request req) {
        //sSystem.out.println(req.getQuery()); 
	public Track queryJson() {
          
        Track track = new Track();
        
        track.setTitle("Fuck");
        track.setSinger("You");
        
        return track;
    }  
}
