package com.techm.ms.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.ms.model.User;
import com.techm.ms.model.representation.ResourceCollection;
import com.techm.ms.service.UserService;

import io.restassured.internal.http.Status;

@Controller
public class UserResourceImpl implements UserResource {
	
	public static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);
	private static final AtomicLong counter = new AtomicLong();

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	private static String baseUrl = "/myusers";

	/**
	 * GetUser
	 * find the user by userid and return appropite response.
	 */
//	@Override
//	public Response findUserbyID() {
//		User user = userService.findById(1);		
//		if (user == null) {
//			return Response.ok("User not found").build();
//		}
//		List<User> list = new ArrayList<>();
//		list.add(user);
//		Link link = Link.fromUri(baseUrl).rel("self").build();		
//		ResourceCollection<User> resource = new ResourceCollection<>(list);
//		return Response.ok(resource).links(link).build();
//	}	
	
	/**
	 * CreateUser
	 * check if user exists. if not, create a new user.
	 */
	@Override
	public Response createUser() {
		User user  = new User(counter.incrementAndGet(),"User40",1,1 );
		User new_user = userService.saveUser(user);		
		if (new_user == null) {
			return Response.ok("Account with name already exists").build();
		}
		List<User> list = new ArrayList<>();
		list.add(new_user);
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		ResourceCollection<User> resource = new ResourceCollection<>(list);
		return Response.ok(resource).links(link).build();
	}	

}
