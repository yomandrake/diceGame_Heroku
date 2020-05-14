package com.mdkGame.DiceApp.Domain;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity
@SequenceGenerator(name="seq2", initialValue=15, allocationSize=100)
public class Games {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq2")
	private int gameId;
	private String gameDateTime;
	private int dice1;
	private int dice2;
	private int dice3;
	private int dice4;
	private int isWin;
	private int playerId;
	
	@ManyToOne
	private Player player;//Foreign Key
	
	
	public Games() {
					
	}
	
	public Games(int playerId) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		this.setGameDate(currentDateTime.toString());
		this.dice1 = new Random().nextInt(7);
		this.dice2 = new Random().nextInt(7);
		this.dice3 = new Random().nextInt(7);
		this.dice4 = new Random().nextInt(7);
		
		///Decide whether is a Win or Not
		if(
			(this.dice1 == this.dice2 && this.dice1 == this.dice3 && this.dice1 == this.dice4)
			||
			(this.dice1 + this.dice2 + this.dice3 + this.dice3 >= 16)			
				) {
			//this.setWin(true);
			this.isWin = 1;
		}else {
			//this.setWin(false);
			this.isWin = 0;
		}
		
		//Set playerId to persist in DB, for non relational porpouse
		this.setPlayerId(playerId);
		
		//Set Id Foreign Key
		Player player = new Player();
		player.setPlayerId(playerId);
		this.player = player;		
	}
	
	//getters and setters
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getIsWin() {
		return isWin;
	}

	public void setIsWin(int isWin) {
		this.isWin = isWin;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getDice1() {
		return dice1;
	}


	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}


	public int getDice2() {
		return dice2;
	}


	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public int getDice3() {
		return dice3;
	}

	public void setDice3(int dice3) {
		this.dice3 = dice3;
	}

	public int getDice4() {
		return dice4;
	}

	public void setDice4(int dice4) {
		this.dice4 = dice4;
	}

	public String getGameDate() {
		return gameDateTime;
	}


	public void setGameDate(String gameDate) {
		this.gameDateTime = gameDate;
	}


	public int isWin() {
		return isWin;
	}


	public void setWin(int isWin) {
		this.isWin = isWin;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
	

}
