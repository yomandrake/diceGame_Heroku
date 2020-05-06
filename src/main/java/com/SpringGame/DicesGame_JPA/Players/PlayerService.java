package com.SpringGame.DicesGame_JPA.Players;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	//GET PLAYER BY playerId
	public Optional<Player> getPlayerById(int playerId) {
		return playerRepository.findById(playerId);
	}
	
	///GET ALL PLAYERS
	public List<Player> getAllPlayers() {
		List<Player> allPlayers = new ArrayList<Player>();
		//playerRepository.findAll().forEach(allPlayers::add);//With method reference
		playerRepository.findAll().forEach(p -> allPlayers.add(p));//With lambda
		return allPlayers;
	}
	
	//POST -ADD NEW PLAYER
	public void addNewPlayer(Player newPlayer) {
		if(newPlayer.getPlayerName()=="") {
			newPlayer.setPlayerName("Anonimo");
		}
		newPlayer.setPlayerRegDate(LocalDateTime.now().toString());		
		playerRepository.save(newPlayer);		
	}
	
	//PUT or UPDATE PLAYER
	public void updatePlayer(Player newPlayer) {
		if(newPlayer.getPlayerName()=="") {
			newPlayer.setPlayerName("Anonimo");
		}		
		playerRepository.save(newPlayer);
	}
	
	//DELETE PLAYER
	public void deletePlayer(int playerId) {
		playerRepository.deleteById(playerId);
	}
	
	//GET Name availability 
	public boolean isNameUsed(String playerName) {
		List<String> usedNames = new ArrayList<String>();
		List<Player> registeredPlayers = this.getAllPlayers();
		for (Player player : registeredPlayers) {
			usedNames.add(player.getPlayerName().toLowerCase());
		}
		return usedNames.contains(playerName);
	}

}
