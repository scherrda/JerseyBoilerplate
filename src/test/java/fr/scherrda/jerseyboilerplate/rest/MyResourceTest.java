package fr.scherrda.jerseyboilerplate.rest;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;
import org.junit.Before;
import fr.scherrda.jerseyboilerplate.domain.MyEntity;
import fr.scherrda.jerseyboilerplate.domain.MyService;

import com.google.common.collect.Lists;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

public class MyResourceTest {

	private MyResource resource;
	MyService mockService = mock(MyService.class);

	@Before
	public void init() {
		resource = new MyResource(mockService);
	}

	@Test
	public void should_call_myservice() {
		resource.getAll();
		verify(mockService, times(1)).get();
	}

	@Test
	public void should_return_a_list_of_myentity() {
		when(mockService.get()).thenReturn(
				Lists.newArrayList(new MyEntity("open", "tata"), new MyEntity(
						"closed", "tutu")));
		List<MyEntity> myentities = resource.getAll();
		assertThat(myentities)
		.hasSize(2)
		.extracting("state", "name")
				.containsOnly(tuple("open", "tata"), tuple("closed", "tutu"));

	}

}
