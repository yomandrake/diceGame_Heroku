package com.mdkGame.DiceApp.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdkGame.DiceApp.Domain.Player;
import com.mdkGame.DiceApp.Domain.PlayerDTO;
import com.mdkGame.DiceApp.Repository.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	//GET PLAYER BY playerId
	public Player getPlayerById(int playerId) {
		return playerRepository.findById(playerId).get();
	}
	//GET PLAYER BY uuid
		public List<Player> getPlayerByUuid(String playerUuid) {
			return playerRepository.findByUuid(playerUuid);
		}
	
	///GET ALL PLAYERS
	public List<Player> getAllPlayers() {
		List<Player> allPlayers = new ArrayList<Player>();
		//playerRepository.findAll().forEach(allPlayers::add);//With method reference
		playerRepository.findAll().forEach(p -> allPlayers.add(p));//With lambda
		return allPlayers;
	}
	
	//POST -ADD NEW PLAYER
	public PlayerDTO addNewPlayer(Player newPlayer) {
		if(newPlayer.getPlayerName()=="") {
			newPlayer.setPlayerName("Anonimo");
		}
		newPlayer.setPlayerRegDate(LocalDateTime.now().toString());
		String newUUID = UUID.randomUUID().toString();
		newPlayer.setUuid(newUUID);
		PlayerDTO newPlayerDTO = new PlayerDTO(playerRepository.save(newPlayer)) ;
		return newPlayerDTO;
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
	public boolean isLogNameUsed(String playerLogName) {
		List<String> usedNames = new ArrayList<String>();
		List<Player> registeredPlayers = this.getAllPlayers();
		for (Player player : registeredPlayers) {
			usedNames.add(player.getPlayerLogName().toLowerCase());
		}
		return usedNames.contains(playerLogName);
	}
	
	

}
