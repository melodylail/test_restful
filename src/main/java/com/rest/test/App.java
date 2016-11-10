package com.rest.test;


import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.UriBuilder;

//import org.eclipse.jetty.server.Server;
//import org.eclipse.jetty.servlet.ServletContextHandler;
//import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.grizzly.http.server.HttpServer;

import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class App {
    public static void main(String[] args) throws Exception {
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
//
//        Server jettyServer = new Server(8080);
//        jettyServer.setHandler(context);
//
//        ServletHolder jerseyServlet = context.addServlet(
//             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
//        jerseyServlet.setInitOrder(0);
//
//        // Tells the Jersey Servlet which REST service/class to load.
//        jerseyServlet.setInitParameter(
//           "jersey.config.server.provider.classnames",
//           Query.class.getCanonicalName());
//
//        try {
//            jettyServer.start();
//            jettyServer.join();
//        } finally {
//            jettyServer.destroy();
//        }
    	URI uri = UriBuilder.fromUri("http://127.0.0.1").port(8080).build();  
        ResourceConfig rc = new PackagesResourceConfig("com.rest.test");  
        //使用Jersey对POJO的支持，必须设置为true  
         rc.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);  
        try {  
            HttpServer server = GrizzlyServerFactory.createHttpServer(uri, rc);  
            server.start();  
        } catch (IllegalArgumentException e) {  
            e.printStackTrace();  
        } catch (NullPointerException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            Thread.sleep(1000*1000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }
}
