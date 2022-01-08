package ari.project.ARI.models;

import javax.persistence.Entity;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
public class Comic extends Book{
	
	@NonNull private String serie;
	
	public Comic() {}

	public Comic(@NonNull String serie) {
		super();
		this.serie = serie;
	}


	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

}
