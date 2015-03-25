package fr.scherrda.jerseyboilerplate;

import java.util.List;

import com.google.common.collect.Lists;

import fr.scherrda.jerseyboilerplate.domain.MyEntity;
import fr.scherrda.jerseyboilerplate.domain.MyService;

public enum Server {
	INSTANCE;
	public final MyService myService;
	
	Server(){
		myService = new MyService() {
			
			@Override
			public List<MyEntity> get() {
				return Lists.newArrayList(new MyEntity("open", "titi"), new MyEntity("close", "toto"));
			}
		};
	}

}
