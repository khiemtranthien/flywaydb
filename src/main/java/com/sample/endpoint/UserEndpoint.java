package com.sample.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.bo.User;
import com.sample.service.UserService;

@Component
@Path ("/user")
public class UserEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserEndpoint.class);
	
	@Autowired
	private UserService userService;
	
	@GET
	@Path ("/getAllUser")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllUser() {
		List<User> users = new ArrayList<User>();
		try {
			LOGGER.info("Receive request for service /user/getAllUser");
			users = userService.getAllUser();
			
		} catch (Exception e) {
			LOGGER.error("Error when getting all users: ", e);
		}

		return Response.ok().entity(users).type(MediaType.APPLICATION_JSON).build();
	}
}
