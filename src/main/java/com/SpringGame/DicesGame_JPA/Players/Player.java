package com.SpringGame.DicesGame_JPA.Players;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Player {
	@Id@GeneratedValue
	private int playerId;
	private String playerLogName;
	private String playerLogPass;
	private String playerName;
	private String playerRegDate;
	//Game playerGames;
	@Transient
	private float playerWinStats = (float) 0.00;
	
	public Player() {
	}
	
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPlayerLogName() {
		return playerLogName;
	}

	public void setPlayerLogName(String playerLogName) {
		this.playerLogName = playerLogName;
	}

	public String getPlayerLogPass() {
		return playerLogPass;
	}

	public void setPlayerLogPass(String playerLogPass) {
		this.playerLogPass = playerLogPass;
	}

	public String getPlayerRegDate() {
		return playerRegDate;
	}

	public void setPlayerRegDate(String playerRegDate) {
		this.playerRegDate = playerRegDate;
	}

	public float getAvgIsWin() {
		return playerWinStats;
	}

	public void setAvgIsWin(float avgIsWin) {
		this.playerWinStats = avgIsWin;
	}
	
	
	

}
