package com.mycompany.testprojectmicroprofile.service;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/example")
public class ExampleService {
    @Inject JsonWebToken token;
    
    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello name("+token.getName()+") groups("+token.getGroups()+") issuer("+token.getIssuer()+") subject("+token.getSubject()+")";
    }
//    public String get(@HeaderParam("X-Application-Name") String appName) {
//        return "Hello, world! to "+appName;
//    }
}
