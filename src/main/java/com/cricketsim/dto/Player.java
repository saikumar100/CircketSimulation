package com.cricketsim.dto;

import java.util.List;

public class Player {
	String playerName;
	List<Double> playersScoreProbability;
	String status;
	String runsScored;
	String ballsPlayed;
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public List<Double> getPlayersScoreProbability() {
		return playersScoreProbability;
	}
	public void setPlayersScoreProbability(List<Double> playersScoreProbability) {
		this.playersScoreProbability = playersScoreProbability;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRunsScored() {
		return runsScored;
	}
	public void setRunsScored(String runsScored) {
		this.runsScored = runsScored;
	}
	public String getBallsPlayed() {
		return ballsPlayed;
	}
	public void setBallsPlayed(String ballsPlayed) {
		this.ballsPlayed = ballsPlayed;
	}
	

}
