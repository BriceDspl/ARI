package ari.project.ARI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.project.ARI.models.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Integer>{
	
	List<Reader> findByLastName(String lastName);
	Reader findById(int id);

}