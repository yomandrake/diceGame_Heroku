package com.mdkGame.DiceApp.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mdkGame.DiceApp.Domain.GameDTO;
import com.mdkGame.DiceApp.Domain.Games;
import com.mdkGame.DiceApp.Services.GamesService;

@RestController
public class GamesController {

	@Autowired
	private GamesService gamesService;
	
//    @Autowired
//    private ModelMapper modelMapper;
	
	
	/////////////////////
	/*--POST REQUESTs--*/
	/////////////////////
	/*--POST--*/
	//POST -ADD NEW GAME TO A PLAYER (by playerId)
	@RequestMapping(method=RequestMethod.POST, value = "/players/{playerId}/games")
	public ResponseEntity<?> newGameForPlayer(@PathVariable int playerId) {
		try {
			//New Game for Player
			Games newGame = gamesService.addNewGameForPlayer(playerId);
			//Catch after persisted and return Game DTO
			GameDTO gameDTO = new GameDTO(newGame);
			
			return new ResponseEntity<>(gameDTO,HttpStatus.OK);
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
	///GET ALL GAMES for a Player by PlayerId
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games")//GET ALL PLAYERS
	public ResponseEntity<?> getAllGames(@PathVariable int playerId) {
		try {
			List<GameDTO> allGamesDTO = new ArrayList<>();
			gamesService.getAllGamesForPlayer(playerId).forEach(game -> allGamesDTO.add(new GameDTO(game)));
				
			return new ResponseEntity<>(allGamesDTO,HttpStatus.OK);
		}
		 catch (Exception e)
        {
            String errorString =  "ERROR " + e.getMessage();
            System.out.println(errorString);
            return new ResponseEntity<>( "Something Went Wrong!!.." , HttpStatus.BAD_REQUEST);
        }	
	}
		
	///GET GAME for a Player by GameId. With DTO conversion.
	@RequestMapping(method=RequestMethod.GET,value = "/players/{playerId}/games/{gameId}")//GET ALL PLAYERS
	public ResponseEntity<?> getGameByGameId(@PathVariable int gameId,@PathVariable int playerId) {
		try {
			GameDTO requestedGame = new GameDTO(gamesService.getGameByGameId(gameId));
			//Check if playerId matches
			if(requestedGame.getPlayerId() == playerId)	{
				return new ResponseEntity<>(requestedGame,HttpStatus.OK);
			}else {
				 return new ResponseEntity<>( "Sure all data match?.." , HttpStatus.BAD_REQUEST);
			}
			
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
	@RequestMapping(method=RequestMethod.DELETE, value = "/players/{playerId}/games")
	public ResponseEntity<?> deleteAllGamesForPlayer(@PathVariable int playerId) {
				
		try {
			gamesService.deleteAllGamesForPlayer(playerId);
			return new ResponseEntity<>( "All Games for player Deleted correctly! " , HttpStatus.BAD_REQUEST);
			
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
//	//GET game by GameId converted to GameDTO (include only playerId) Special mapping for DTO, used while generating DTO transformation
//	@RequestMapping(method=RequestMethod.GET, value = "/players/{playerId}/games/DTO/{gameId}")
//	public GameDTO getPlayerDTO(@PathVariable int gameId) {
//		Optional<Games> requestedGame = gamesService.getGameByGameId(gameId);
//		return 	convertToDto(requestedGame.get());
//	}
//	
}
