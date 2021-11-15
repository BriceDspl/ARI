package jpa.eclipselink.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String nonsenseField = "";
    
    private Address address;
    
    
    @ManyToOne
    private Enterprise enterprise;
    
    @ManyToOne
    private Team team;
    
    @ManyToMany
    private List<Project> projects = new ArrayList<Project>();

    public Employee() {}
    
	public Employee(String fn, String ln, String age, Address address , Enterprise en) {
    	this.age = age;
    	this.firstName = fn;
    	this.lastName = ln;
    	this.enterprise = en;
    	this.address = address;
    }
	
    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@ManyToMany
	public List<Project> getProjects() {
		return projects;
	}

	public void addProject(Project project) {
		this.projects.add(project);
	}
	
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Transient
    public String getNonsenseField() {
        return nonsenseField;
    }

    public void setNonsenseField(String nonsenseField) {
        this.nonsenseField = nonsenseField;
    }

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	public void setTeamEmployee(Team team) {
		this.team = team;
		team.addEmployee(this);
	}
	
	

}