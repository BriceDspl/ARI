package ari.project.ARI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ari.project.ARI.models.Novel;

public interface NovelRepository extends JpaRepository<Novel, Integer>{

	List<Novel> findByTitle(String title);
	Novel findById(int id);

}
