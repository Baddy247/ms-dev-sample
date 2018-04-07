package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.techm.ms.model.swagger.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is the Interface definition for User Resource
 * 
 */
@Api("user")
@Path("/myusers")
@Produces({MediaType.APPLICATION_JSON})
public interface UserResource {
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User",
			notes = "Returns users",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 204, message = "No Content")					
					})
	/**
	 * Get User
	 */
	//public Response findUserbyID();
	
	/**
	 * Create User
	 */
	
	public Response createUser();
}