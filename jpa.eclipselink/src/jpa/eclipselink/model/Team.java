package jpa.eclipselink.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id;    
	private String teamName;
	
    @OneToMany(mappedBy = "team")
    private List<Employee> employees= new ArrayList<Employee>();

    public Team() {}

    public Team(String teamName) {
    	this.teamName = teamName;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee employe) {
		this.employees.add(employe);
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
    
    
}
