package com.mdkGame.DiceApp.Controllers;


import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdkGame.DiceApp.Domain.Games;
import com.mdkGame.DiceApp.Domain.Player;
import com.mdkGame.DiceApp.Domain.PlayerDTO;
import com.mdkGame.DiceApp.Domain.Stats;
import com.mdkGame.DiceApp.Services.GamesService;
import com.mdkGame.DiceApp.Services.PlayerService;
import com.mdkGame.DiceApp.Services.StatsService;




@RestController
public class StatsController {
	
	@Autowired
	private StatsService statsService;

	@Autowired
	private GamesService gamesService;
	
	@Autowired
	private PlayerService playerService;
	
	//GET General Statistics for all Games
	@RequestMapping(method=RequestMethod.GET,value = "/players/statics")
	public ResponseEntity<?> getGeneralStatics() {
		
		try {
			List<Games> everyGame = gamesService.getAllGames();
			return new ResponseEntity<>(statsService.getStatics(everyGame),HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
		
	}
	
	//GET Statistics for one player by playerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/stats")
	public ResponseEntity<?> getStaticsForPlayerById(@PathVariable int playerId) {
		
		try {
			List<Games> allGamesForPlayer = gamesService.getAllGamesForPlayer(playerId);
			Stats reqStats = statsService.getStatics(allGamesForPlayer);
			return new ResponseEntity<>(reqStats,HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
		
	}
	
	//GET Best Player Statics
	@RequestMapping(method=RequestMethod.GET,value = "/players/ranking/winner")
	public ResponseEntity<?> getBestPlayerStatics() {		
		try {
			List<Player> allPlayers = playerService.getAllPlayers();
			allPlayers.forEach(player -> player.setAvgIsWin(statsService.getStatics(gamesService.getAllGamesForPlayer(player.getPlayerId())).getAvgIsWin()));
			allPlayers.sort(Comparator.comparing(Player::getAvgIsWin));//Tested outside App
			PlayerDTO bestPlayer = new PlayerDTO(allPlayers.get(allPlayers.size()-1));		
			
			return new ResponseEntity<>(bestPlayer,HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
		
	}
	
	//GET Worst Player Statics
	@RequestMapping(method=RequestMethod.GET,value = "/players/ranking/looser")
	public ResponseEntity<?> getWorstPlayerStatics() {

		try {
			//Get all Games
			List<Player> allPlayers = playerService.getAllPlayers();
			allPlayers.forEach(player -> player.setAvgIsWin(statsService.getStatics(gamesService.getAllGamesForPlayer(player.getPlayerId())).getAvgIsWin()));
			allPlayers.sort(Comparator.comparing(Player::getAvgIsWin));//Tested outside App
			PlayerDTO worstPlayer =new PlayerDTO(allPlayers.get(0));	
			return new ResponseEntity<>(worstPlayer,HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }
	}
	
}




















