package com.mdkGame.DiceApp.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mdkGame.DiceApp.Domain.Games;

public interface GamesRepository extends CrudRepository<Games, Integer>{
	public List<Games> findByPlayerPlayerId(int playerId);
}
