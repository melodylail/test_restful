package com.rest.test;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;  
import com.sun.jersey.api.client.ClientResponse;  
import com.sun.jersey.api.client.WebResource;  
import com.sun.jersey.api.client.config.ClientConfig;  
import com.sun.jersey.api.client.config.DefaultClientConfig;  
import com.sun.jersey.api.json.JSONConfiguration;  

public class JerseyClient {
	public static void main(String[] args) {  
        ClientConfig cc = new DefaultClientConfig();  
        //使用Jersey对POJO的支持，必须设置为true  
        cc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);  
        Client client = Client.create(cc);  
          
        WebResource resource = client.resource("http://127.0.0.1:8080/query");  
          
        Request req = new Request();
        
        String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";
        
        JSONObject jo = new JSONObject();
        try {
			jo.put("firstName", "John");
			jo.put("lastName", "Doe");

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JSONArray ja = new JSONArray();
        ja.put(jo);

        JSONObject mainObj = new JSONObject();
        try {
			mainObj.put("employees", ja);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        req.setQuery(mainObj.toString());  
          
        ClientResponse response = resource  
                .accept(MediaType.APPLICATION_JSON)  
                .type(MediaType.APPLICATION_JSON)  
                .post(ClientResponse.class, req);  
          
        Response resp = response.getEntity(Response.class);  
        System.out.println(resp.getRespCode() + " " + resp.getRespDesc());  
    }  
}
