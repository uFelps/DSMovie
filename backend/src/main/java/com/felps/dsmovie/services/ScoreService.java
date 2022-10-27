package com.felps.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felps.dsmovie.dto.MovieDTO;
import com.felps.dsmovie.dto.ScoreDTO;
import com.felps.dsmovie.entities.Movie;
import com.felps.dsmovie.entities.Score;
import com.felps.dsmovie.entities.User;
import com.felps.dsmovie.repositories.MovieRepository;
import com.felps.dsmovie.repositories.ScoreRepository;
import com.felps.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			
			user = userRepository.saveAndFlush(user);
		}
		
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		
		Score score = new Score(user, movie, dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		
		double sum = 0.0;
		for(Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}

}
