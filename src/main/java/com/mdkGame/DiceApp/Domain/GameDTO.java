package com.mdkGame.DiceApp.Domain;

import java.util.Random;

public class GameDTO {
	
	private int gameId;
	private String gameDateTime;
	private int dice1;
	private int dice2;
	private int dice3;
	private int dice4;
	private int isWin;
	private int playerId;
	//private String playerPlayerLogName;///With this name, the mapper search into linked player attributes (player object linked with each game by FK playerId)
	
	public GameDTO(Games game) {
		
		this.gameId = game.getGameId();
		this.gameDateTime = game.getGameDate();
		this.dice1 = game.getDice1();
		this.dice2 = game.getDice2();
		this.dice3 = game.getDice3();
		this.dice4 = game.getDice4();
		this.isWin = game.getIsWin();
		this.playerId = game.getPlayerId();				
	
	}
	
	
	
	
	public int getGameId() {
		return gameId;
	}
	
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameDateTime() {
		return gameDateTime;
	}
	public void setGameDateTime(String gameDateTime) {
		this.gameDateTime = gameDateTime;
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
	public int getIsWin() {
		return isWin;
	}
	public void setIsWin(int isWin) {
		this.isWin = isWin;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	

}
