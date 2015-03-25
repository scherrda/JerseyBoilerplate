package fr.scherrda.jerseyboilerplate.domain;

public class MyEntity {

	private String state;
	private String name;
	
	public MyEntity() {
		// TODO Auto-generated constructor stub
	}

	public MyEntity(String state, String name) {
		this.state =  state;
		this.name = name;
	}
	public String getState() {
		return state;
	}
	
	public String getName() {
		return name;
	}
	
}
