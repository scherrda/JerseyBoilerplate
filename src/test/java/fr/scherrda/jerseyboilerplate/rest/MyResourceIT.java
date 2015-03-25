package fr.scherrda.jerseyboilerplate.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.groups.Tuple.tuple;
import fr.scherrda.jerseyboilerplate.domain.MyEntity;

public class MyResourceIT {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private Client client;
	private WebTarget target;

	@Before
	public void initializeRestClient() throws Exception {
		client = ClientBuilder.newBuilder().register(JacksonFeature.class)
				.build();
		target = client.target("http://localhost:8080/rest/myresource");
	}

	@After
	public void tearDown() throws Exception {
		target = null;
		client.close();
	}
	
	@Test
	public void can_have_a_response_from_myresource_all() throws Exception {
		Response response = target.path("all").request().get();
		assertThat(response.getStatus()).isEqualTo(200);
		
		String body = response.readEntity(String.class);
		assertThat(body).isNotEmpty();
	}
	

	@Test
	public void can_retrieve_all_myresource() throws Exception {
		Response response = target.path("all").request().get();
		
		List<MyEntity> allData = response
				.readEntity(new GenericType<List<MyEntity>>() {
				});
		assertThat(allData).isNotNull();
		assertThat(allData).extracting("state", "name").isNotEmpty();
				//.containsOnly(tuple("open","toto"));
	}

}
