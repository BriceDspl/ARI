package ari.project.ARI.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull private String title;

    @ManyToOne
    private Library library;

    @ManyToMany
    private List<Author> authors = new ArrayList<Author>();
    
    
	public Book() {}


	public Book( @NonNull String title, List<Author> authors) {
		super();
		this.title = title;
		this.authors = authors;
	}


	public Book(@NonNull String title, Library library, List<Author> authors) {
		super();
		this.title = title;
		this.library = library;
		this.authors = authors;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Library getLibrary() {
		return library;
	}


	public void setLibrary(Library library) {
		this.library = library;
	}


	public List<Author> getAuthors() {
		return authors;
	}


	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	
}
