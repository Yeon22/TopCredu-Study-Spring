package a.b.person;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String FirstName;
	private String LastName;
	private String street;
	private String city;
	private String state;
	private String country;
	
	public Person(String firstName, String lastName, String street, String city, String state, String country) {
		super();
		this.FirstName = firstName;
		this.LastName = lastName;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
