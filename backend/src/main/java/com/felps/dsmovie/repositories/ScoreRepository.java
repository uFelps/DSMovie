package com.felps.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felps.dsmovie.entities.Score;
import com.felps.dsmovie.entities.pk.ScorePk;

public interface ScoreRepository extends JpaRepository<Score, ScorePk>{

}
