package com.felps.dsmovie.entities;

import java.io.Serializable;

import com.felps.dsmovie.entities.pk.ScorePk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ScorePk id = new ScorePk();
	
	private Double scorevalue;
	
	public Score() {
		
	}
	
	public Score(User user, Movie movie, Double value) {
		id.setUser(user);
		id.setMovie(movie);
		this.scorevalue = value;
	}
	
	public User getUser() {
		return id.getUser();
	}
	
	public void setUser(User user) {
		id.setUser(user);
	}
	
	public Movie getMovie() {
		return id.getMovie();
	}
	
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}

	public Double getValue() {
		return scorevalue;
	}

	public void setValue(Double value) {
		this.scorevalue = value;
	}
	
	
	
	

	
	

}
