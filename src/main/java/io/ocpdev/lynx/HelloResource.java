package io.ocpdev.lynx;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.eclipse.microprofile.config.inject.*;

@Path("/hello")
public class HelloResource {
    @ConfigProperty(name = "environment", defaultValue="local")
    String environment;
    @ConfigProperty(name = "name", defaultValue="me")
    String name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello "+name+" in "+environment;
    }
}