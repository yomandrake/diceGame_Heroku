package com.mdkGame.DiceApp.Domain;

public class PlayerDTO {
	private int playerId;
	private String playerLogName;
	private String playerName;
	private String playerRegDate;
	private float playerWinStats = (float) 0.10;
	
	public PlayerDTO() {
		
	}
	
	public PlayerDTO(Player player) {
		this.playerId = player.getPlayerId();
		this.playerLogName = player.getPlayerLogName();
		this.playerName = player.getPlayerName();
		this.playerRegDate = player.getPlayerRegDate();
		this.playerWinStats = player.getAvgIsWin();
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerLogName() {
		return playerLogName;
	}
	public void setPlayerLogName(String playerLogName) {
		this.playerLogName = playerLogName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerRegDate() {
		return playerRegDate;
	}
	public void setPlayerRegDate(String playerRegDate) {
		this.playerRegDate = playerRegDate;
	}

	public float getPlayerWinStats() {
		return playerWinStats;
	}

	public void setPlayerWinStats(float playerWinStats) {
		this.playerWinStats = playerWinStats;
	}


}
