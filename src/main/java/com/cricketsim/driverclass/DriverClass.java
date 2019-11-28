package com.cricketsim.driverclass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.cricketsim.dto.Player;
import com.cricketsim.matchsimulationservice.SimulateCricketMatch;

public class DriverClass {

	public static void main(String[] args) {
		
		
		List<Player> players = new LinkedList<>();
		/*Initializing static scores as:
		 * 0 - considered as Dot
		 * 1 - considered as 1run scored by batsman
		 * 2 - considered as 2runs scored by batsman
		 * 3 - considered as 3runs scored by batsman
		 * 4 - considered as 4runs scored by batsman
		 * 5 - considered as 5runs scored by batsman
		 * 6 - considered as 6runs scored by batsman
		 * 7 - considered as OUT
		 * */
		List<Integer> scoresArray = new ArrayList<Integer>();
		scoresArray.add(0);scoresArray.add(1);scoresArray.add(2);scoresArray.add(3);scoresArray.add(4);scoresArray.add(5);scoresArray.add(6);scoresArray.add(7);
		
		/*Adding player-1 per run probability to list*/
		List<Double> scoringProbabilityListForPlayer1 = new ArrayList<>();
		scoringProbabilityListForPlayer1.add(0.05);
		scoringProbabilityListForPlayer1.add(0.30);
		scoringProbabilityListForPlayer1.add(0.25);
		scoringProbabilityListForPlayer1.add(0.10);
		scoringProbabilityListForPlayer1.add(0.15);
		scoringProbabilityListForPlayer1.add(0.01);
		scoringProbabilityListForPlayer1.add(0.09);
		scoringProbabilityListForPlayer1.add(0.05);
		
		/*Adding player-2 per run probability to list*/
		List<Double> scoringProbabilityListForPlayer2 = new ArrayList<>();
		scoringProbabilityListForPlayer2.add(0.10);
		scoringProbabilityListForPlayer2.add(0.40);
		scoringProbabilityListForPlayer2.add(0.20);
		scoringProbabilityListForPlayer2.add(0.05);
		scoringProbabilityListForPlayer2.add(0.10);
		scoringProbabilityListForPlayer2.add(0.01);
		scoringProbabilityListForPlayer2.add(0.04);
		scoringProbabilityListForPlayer2.add(0.10);
		
		
		/*Adding player-3 per run probability to list*/
		List<Double> scoringProbabilityListForPlayer3 = new ArrayList<>();
		scoringProbabilityListForPlayer3.add(0.20);
		scoringProbabilityListForPlayer3.add(0.30);
		scoringProbabilityListForPlayer3.add(0.15);
		scoringProbabilityListForPlayer3.add(0.05);
		scoringProbabilityListForPlayer3.add(0.05);
		scoringProbabilityListForPlayer3.add(0.01);
		scoringProbabilityListForPlayer3.add(0.04);
		scoringProbabilityListForPlayer3.add(0.20);
		
		
		/*Adding player-4 per run probability to list*/
		List<Double> scoringProbabilityListForPlayer4 = new ArrayList<>();
		scoringProbabilityListForPlayer4.add(0.30);
		scoringProbabilityListForPlayer4.add(0.25);
		scoringProbabilityListForPlayer4.add(0.05);
		scoringProbabilityListForPlayer4.add(0.0);
		scoringProbabilityListForPlayer4.add(0.05);
		scoringProbabilityListForPlayer4.add(0.01);
		scoringProbabilityListForPlayer4.add(0.04);
		scoringProbabilityListForPlayer4.add(0.30);
		
		
		Player player1 = new Player();
		player1.setPlayerName("Kirat Boli");
		player1.setPlayersScoreProbability(scoringProbabilityListForPlayer1);
		player1.setBallsPlayed("0");
		player1.setRunsScored("0");
		player1.setStatus("not out");
		
		
		Player player2 = new Player();
		player2.setPlayerName("N.S Nodhi");
		player2.setPlayersScoreProbability(scoringProbabilityListForPlayer2);
		player2.setBallsPlayed("0");
		player2.setRunsScored("0");
		player2.setStatus("not out");
		
		
		Player player3 = new Player();
		player3.setPlayerName("R Rumrah");
		player3.setPlayersScoreProbability(scoringProbabilityListForPlayer3);
		player3.setBallsPlayed("0");
		player3.setRunsScored("0");
		player3.setStatus("not out");
		
		
		Player player4 = new Player();
		player4.setPlayerName("Shashi Henra");
		player4.setPlayersScoreProbability(scoringProbabilityListForPlayer4);
		player4.setBallsPlayed("0");
		player4.setRunsScored("0");
		player4.setStatus("not out");
		
		players.add(player1);players.add(player2);players.add(player3);players.add(player4);
		
		/* 4-represents number of overs left
		 * 40-represents number of runs need to win
		 * */
		SimulateCricketMatch scm = new SimulateCricketMatch(players,scoresArray,4,40);
		scm.predictTheMatch();
		System.out.println();
		System.out.println();
		if(scm.getMatchStatus().equalsIgnoreCase("won"))
			System.out.println("Banglore won......!!!");
		else
			System.out.println("Banglore lost......!!!");
		System.out.println();
		System.out.println();
		players.stream().forEach(e -> {System.out.println("Match summary.........");System.out.println(e.getPlayerName()+" scored :"+e.getRunsScored()+" runs & played: "+e.getBallsPlayed()+" balls & batting status: "+e.getStatus());System.out.println("-----------------------");});

	}

}
