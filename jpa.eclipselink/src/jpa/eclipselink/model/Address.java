package jpa.eclipselink.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;    
	private String address;    

	@OneToOne(mappedBy = "address")
	private Employee employee;

	public Address() {}

	public Address(String address, Employee em) {
		this.address = address;
		this.employee = em;
	}

	public Address(String address) {
		this.address = address;
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}