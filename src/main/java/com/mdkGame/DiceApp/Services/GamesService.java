package com.mdkGame.DiceApp.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdkGame.DiceApp.Domain.Games;
import com.mdkGame.DiceApp.Repository.GamesRepository;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;

	public Games addNewGameForPlayer(int playerId) {
		Games newGame = new Games(playerId);
		Games savedGame = gamesRepository.save(newGame);
		return savedGame;
		
	}
		
	public List<Games> getAllGamesForPlayer(int playerId) {
		List<Games> allGamesForPlayer = new ArrayList<>();
		gamesRepository.findByPlayerPlayerId(playerId).forEach(allGamesForPlayer::add);
		return allGamesForPlayer;
	}
	
	public Games getGameByGameId(int gameId) {
		return gamesRepository.findById(gameId).get();
	}
		
	public void deleteAllGamesForPlayer(int playerId) {
		List<Games> allGamesForPlayer = this.getAllGamesForPlayer(playerId);
		for (Games games : allGamesForPlayer) {
			gamesRepository.deleteById(games.getGameId());
		}		
	}
	
	public List<Games> getAllGames() {
	List<Games> allGames = new ArrayList<>();
	gamesRepository.findAll().forEach(allGames::add);
	return allGames;
}

}
