package ari.project.ARI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.project.ARI.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByTitle(String title);
	Book findById(int id);

}
