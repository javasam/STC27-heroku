package org.example.app.service;

import org.example.app.bean.EnvironmentEjb;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/service")
@ApplicationPath("/app")
public class EnvironmentService extends Application {

    @EJB
    EnvironmentEjb environmentEjb;

    @GET
    @Path("/environment")
    @Produces({MediaType.APPLICATION_JSON})
    public Map<String, String> getVars() {
        return environmentEjb.getEnvironmentVars();
    }

    @GET
    @Path("/environment/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSpecificVar(@PathParam("name") String name) {
        return environmentEjb.getEnvironmentVars().get(name);
    }
}
