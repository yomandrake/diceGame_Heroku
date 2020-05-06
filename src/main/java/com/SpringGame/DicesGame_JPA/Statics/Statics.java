package com.SpringGame.DicesGame_JPA.Statics;

public class Statics {
	
	private int qtGames;
	private int qtIsWin;
	private float avgIsWin;
	
	public Statics() {
		
	}
	
	public Statics(int qtGames, int qtIsWin) {
		super();
		this.qtGames = qtGames;
		this.qtIsWin = qtIsWin;
		if(qtGames != 0) {
			this.avgIsWin = this.getQtIsWin() / this.getQtGames();
		}else {
			this.avgIsWin = (float) 0.0;
		}
		
		
		//this.avgIsWin = (float) 0.2;
	}
	public int getQtGames() {
		return qtGames;
	}
	public void setQtGames(int qtGames) {
		this.qtGames = qtGames;
	}
	public int getQtIsWin() {
		return qtIsWin;
	}
	public void setQtIsWin(int qtIsWin) {
		this.qtIsWin = qtIsWin;
	}
	public float getAvgIsWin() {
		return avgIsWin;
	}
	public void setAvgIsWin(float avgIsWin) {
		this.avgIsWin = avgIsWin;
	}
	
	
	
	

}
