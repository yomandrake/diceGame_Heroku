package com.mdkGame.DiceApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mdkGame.DiceApp.Domain.Games;
import com.mdkGame.DiceApp.Domain.Stats;

@Service
public class StatsService {
	
	//GET STATIC FOR A PLAYER BY PlayerId
	public Stats getStatics(List<Games> games){

		int qtGames = games.size();
		int qtIsWin = 0;
		//Iterate everyGame(List) to know how many are win
		for (int i = 0; i < qtGames; i++) {
			if(games.get(i).getIsWin()==1) {
				qtIsWin += 1;
			}
		}
		//System.out.println("qtGames: "+ qtGames + "qtIsWin= "+ qtIsWin);
		Stats requestedStats = new Stats(qtGames,qtIsWin);
		return requestedStats;
	}
	

}
