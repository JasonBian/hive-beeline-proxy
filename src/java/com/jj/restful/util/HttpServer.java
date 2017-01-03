package com.jj.restful.util;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by weizh on 2016/8/9.
 */
public class HttpServer {

    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://0.0.0.0:8010/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     *
     * @return Grizzly HTTP server.
     */
    public static org.glassfish.grizzly.http.server.HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.example package
        //final ResourceConfig rc = new ResourceConfig().packages("com.jj.subject.restful.resource");
        /*String path = Class.class.getClass().getClassLoader().getResource(".").toString();
        System.out.println(path);*/
        final ResourceConfig rc = new ResourceConfig().packages("com.jj.restful.resource");

        // create and start a new instance of grizzly htt   p server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        final org.glassfish.grizzly.http.server.HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        //server.start();
    }
}
