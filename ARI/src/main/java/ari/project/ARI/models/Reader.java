package ari.project.ARI.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String firstName;
    @NonNull private String lastName;
    
    @ManyToOne
    private Library library;
    
    public Reader() {}

	public Reader(@NonNull String firstName, @NonNull String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Reader(@NonNull String firstName, @NonNull String lastName, Library library) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.library = library;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}
    
    
}
