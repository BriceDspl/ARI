package jpa.eclipselink.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String projectName;
    
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees = new ArrayList<Employee>();
    
    public Project() {}

    public Project(String projectName) {
    	this.projectName = projectName;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
    
    
}
