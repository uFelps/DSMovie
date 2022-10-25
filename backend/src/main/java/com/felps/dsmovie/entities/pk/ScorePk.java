package com.felps.dsmovie.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.felps.dsmovie.entities.Movie;
import com.felps.dsmovie.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ScorePk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	public ScorePk() {
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movie, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScorePk other = (ScorePk) obj;
		return Objects.equals(movie, other.movie) && Objects.equals(user, other.user);
	}
	
	

}
