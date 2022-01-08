package ari.project.ARI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.project.ARI.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

	List<Author> findByLastName(String lastName);
	Author findById(int id);

}
