package com.mdkGame.DiceApp.Controllers;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdkGame.DiceApp.Domain.Player;
import com.mdkGame.DiceApp.Domain.PlayerDTO;
import com.mdkGame.DiceApp.Services.GamesService;
import com.mdkGame.DiceApp.Services.PlayerService;
import com.mdkGame.DiceApp.Services.StatsService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private StatsService statsService;
	
	/////////////////////
	/*--POST REQUESTs--*/
	/////////////////////
	//POST -ADD NEW PLAYER
	@RequestMapping(method=RequestMethod.POST, value = "/players")
	public ResponseEntity<?> addPlayer(@RequestBody Player newPlayerDTO){
		try {
			
			if(playerService.isLogNameUsed(newPlayerDTO.getPlayerLogName().toLowerCase())) {
				return new ResponseEntity<>("Sorry the name is not Available. Try A different one",HttpStatus.CONFLICT);
			}else {
				
				
				PlayerDTO newPlayerDTOSaved = playerService.addNewPlayer(newPlayerDTO);
				return new ResponseEntity<>(newPlayerDTOSaved,HttpStatus.OK);
			}

		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
	}
	
	////////////////////
	/*--GET REQUESTs--*/
	////////////////////
	///GET ALL PLAYERS
	@RequestMapping("/players")//GET ALL PLAYERS
	public ResponseEntity<?> getAllPlayers() {
		List<Player> listPlayers;
		try {
			//Retrieve all players
			listPlayers = playerService.getAllPlayers();
			
			//Calculate their Stats
			listPlayers.forEach(player -> player.setAvgIsWin(statsService.getStatics(gamesService.getAllGamesForPlayer(player.getPlayerId())).getAvgIsWin()));
			
			//Transform to DTOs
			List<PlayerDTO> allPlayersDTO = new ArrayList<>();
			listPlayers.forEach(player -> allPlayersDTO.add(new PlayerDTO(player)));			
			
			//Return as PLayerDTOs List
			return new ResponseEntity<>(allPlayersDTO,HttpStatus.OK);
			
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
	}
	
	///GET PLAYER BY ID
	@RequestMapping(method=RequestMethod.GET, value = "/players/{playerId}")
	public ResponseEntity<?> getPlayer(@PathVariable int playerId) {
		Player requestedPlayer;
		try {
			//Retrieve Player
			requestedPlayer = playerService.getPlayerById(playerId);
			
			//Calculate Win Stats
			requestedPlayer.setAvgIsWin(statsService.getStatics(gamesService.getAllGamesForPlayer(playerId)).getAvgIsWin());
						
			//Return DTO Player
			return new ResponseEntity<>(new PlayerDTO(requestedPlayer),HttpStatus.OK);

		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>(  "Something Went Wrong!!..", HttpStatus.BAD_REQUEST);
        }
		
	}
	
	///GET PLAYER BY UUID
	@RequestMapping(method=RequestMethod.GET, value = "/players/uuid/{playerUuid}")
	public ResponseEntity<?> getPlayerByUuid(@PathVariable String playerUuid) {
		List<Player> requestedPlayers;
		try {
			//Retrieve Players
			requestedPlayers = playerService.getPlayerByUuid(playerUuid.toString());
			
			//Return DTO Player
			return new ResponseEntity<>(requestedPlayers,HttpStatus.OK);

		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>(  "Something Went Wrong!!..", HttpStatus.BAD_REQUEST);
        }
		
	}
	
	
	
	////////////////////	
	/*--PUT REQUESTs--*/
	////////////////////
	//PUT -UPDATE PLAYER
	@RequestMapping(method=RequestMethod.PUT, value = "/players")
	public ResponseEntity<String> updatePlayer(@RequestBody Player newPlayer) {
		
		try {
			playerService.updatePlayer(newPlayer);
			return new ResponseEntity<>("Player Updated",HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
		
		
		
	}
	
	///////////////////////
	/*--DELETE REQUESTs--*/
	///////////////////////
	//DELETE PLAYER
	@RequestMapping(method=RequestMethod.DELETE, value = "/players/{playerId}")
	public ResponseEntity<String> deletePlayer(@PathVariable int playerId) {
		try {
			//Next is not needed in JDBC if the table are well initiated with Cascade Constrain
			//gamesService.deleteAllGamesForPlayer(playerId);
			playerService.deletePlayer(playerId);
			return new ResponseEntity<>( "Player and all its games deleted" , HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
		
	}
	

	
	
//	////////////////////
//	/*--EXTRA REQUESTs (Controller Test Zone for Developing process)--*/
//	////////////////////
	
//	//GET Availability confirmation for a particular Name
//	@RequestMapping(method=RequestMethod.GET, value = "/players/isNameUsed/{playerName}")
//	public ResponseEntity<String> checkNameIsAvailable(@PathVariable String playerName){
//				
//		if(playerService.isNameUsed(playerName.toLowerCase())) {
//			return new ResponseEntity<>("Sorry the name is not Available. Try A different one",HttpStatus.CONFLICT);
//		}else {
//			return new ResponseEntity<>("Name available!!",HttpStatus.OK);
//		}
//		
//	}

	
}
