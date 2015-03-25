package fr.scherrda.jerseyboilerplate.rest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.Lists;

import fr.scherrda.jerseyboilerplate.Server;
import fr.scherrda.jerseyboilerplate.domain.MyEntity;
import fr.scherrda.jerseyboilerplate.domain.MyService;

@Path("/myresource")
public class MyResource {

	private MyService myService;

	public MyResource() {
		this.myService = Server.INSTANCE.myService;
	}

	public MyResource(MyService myService) {
		this.myService = myService;
	}

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello World";
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MyEntity> getAll() {
		return myService.get();
	}

}