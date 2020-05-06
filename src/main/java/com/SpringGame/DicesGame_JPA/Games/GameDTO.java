package com.SpringGame.DicesGame_JPA.Games;

public class GameDTO {
	private int gameId;
	private String gameDateTime;
	private int dice1;
	private int dice2;
	private int isWin;
	private int playerId;
	private String playerPlayerLogName;///With this name, the mapper search into linked player attributes (player object linked with each game by FK playerId)
	
	
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
	public String getPlayerPlayerLogName() {
		return playerPlayerLogName;
	}
	public void setPlayerPlayerLogName(String playerPlayerLogName) {
		this.playerPlayerLogName = playerPlayerLogName;
	}

}
