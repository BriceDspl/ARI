package ari.project.ARI.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.ManyToMany;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String firstName;
    @NonNull private String lastName;
    
    @ManyToOne
    private Library library;
    
    @ManyToMany
    private List<Book> books = new ArrayList<Book>();
    
    public Author() {}

	public Author(@NonNull String firstName, @NonNull String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(@NonNull String firstName, @NonNull String lastName, Library library, List<Book> books) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.library = library;
		this.books = books;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
}
