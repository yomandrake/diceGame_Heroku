package com.mdkGame.DiceApp.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;



@Entity
@SequenceGenerator(name="seq", initialValue=6, allocationSize=100)
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
	private int playerId;
	private String playerLogName;
	//private String playerLogPass;
	private String playerName;
	private String playerRegDate;
	private String uuid;
	
	@Transient
	private float playerWinStats = (float) 0.00;
	
	@Transient
	private Stats playerStats;
	
	

//	@PersistenceConstructor
//	public Player(String playerId, String playerLogName, String playerLogPass, String playerName, String playerRegDate) {
//		this.playerId = playerId;
//		this.playerLogName = playerLogName;
//		this.playerLogPass = playerLogPass;
//		this.playerName = playerName;
//		this.playerRegDate = playerRegDate;
//	}
	
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


	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	public Stats getPlayerStats() {
		return playerStats;
	}


	public void setPlayerStats(Stats playerStats) {
		this.playerStats = playerStats;
	}



	
//	public String getPlayerLogPass() {
//		return playerLogPass;
//	}
//
//	public void setPlayerLogPass(String playerLogPass) {
//		this.playerLogPass = playerLogPass;
//	}

	

}
