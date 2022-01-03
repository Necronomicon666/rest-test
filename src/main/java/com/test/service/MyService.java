package com.test.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.annotation.security.RolesAllowed;

import org.keycloak.KeycloakPrincipal;

@Path("/")
public class MyService {
    @Context
    SecurityContext context;

	@GET
	@Path("hello")
	@RolesAllowed({"wildfly_role"})

	@Produces(MediaType.TEXT_PLAIN)
	public String hello(){
		KeycloakPrincipal principal = (KeycloakPrincipal) context.getUserPrincipal();
		String output = "Hello2 "+principal.getKeycloakSecurityContext().getToken().getPreferredUsername();
		return output;
	}

}
