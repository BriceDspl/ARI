package ari.project.ARI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.project.ARI.models.Comic;

public interface ComicRepository extends JpaRepository<Comic, Integer>{

	List<Comic> findByTitle(String title);
	Comic findById(int id);

}
