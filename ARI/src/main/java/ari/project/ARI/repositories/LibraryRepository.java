package ari.project.ARI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.project.ARI.models.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

	List<Library> findByName(String name);
	Library findById(int id);

}
