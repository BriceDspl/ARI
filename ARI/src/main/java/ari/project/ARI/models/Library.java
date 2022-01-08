package ari.project.ARI.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull private String name;

	@OneToMany()
	private final List<Author> authors = new ArrayList<Author>();

	@OneToMany()
	private final List<Reader> readers = new ArrayList<Reader>();

	@OneToMany()
	private final List<Book> books = new ArrayList<Book>();

	public Library() {	}
	
	public Library(@NonNull String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public List<Reader> getReaders() {
		return readers;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	
}
