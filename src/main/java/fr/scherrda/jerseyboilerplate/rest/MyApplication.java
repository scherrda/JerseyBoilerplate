package fr.scherrda.jerseyboilerplate.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
	
	  public MyApplication() {
	        register(JacksonFeature.class);

	        packages("fr.scherrda.jerseyboilerplate.rest");
	    }
}
