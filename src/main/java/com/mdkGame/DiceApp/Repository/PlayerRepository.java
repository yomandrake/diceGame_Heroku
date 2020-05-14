package com.mdkGame.DiceApp.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mdkGame.DiceApp.Domain.Player;


public interface PlayerRepository extends CrudRepository<Player, Integer>{
	
//	 @Query(value = "SELECT next_val FROM hibernate_sequence limit 1", nativeQuery = 
//		        true)
//	int getNextSeriesId();
}
