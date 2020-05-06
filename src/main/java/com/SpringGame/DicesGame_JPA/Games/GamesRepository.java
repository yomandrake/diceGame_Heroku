package com.SpringGame.DicesGame_JPA.Games;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GamesRepository extends CrudRepository<Games, Integer>{
	public List<Games> findByPlayerPlayerId(int playerId);
}
