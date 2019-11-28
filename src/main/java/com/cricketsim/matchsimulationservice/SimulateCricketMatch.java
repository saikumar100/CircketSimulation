package com.cricketsim.matchsimulationservice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.cricketsim.dto.Player;
import com.cricketsim.enums.Scores;
import com.cricketsim.randomgenerator.GenerateRandomNumber;

public class SimulateCricketMatch {

	private Integer ballsLeft;
	private List<Player> playersList;
	private Integer runsNeededToWin;
	private List<Integer> scoresList;
	private boolean isPlayerOneAtStrike = true;
	private String matchStatus = "lost";

	/*
	 * Initializing
	 * 
	 * @param playersMap holds the individual players name and probability of runs
	 * for a given ball
	 * 
	 * @param oversLeft holds the number of balls left before match finishes
	 * 
	 * @param runsNeedToWin holds the number of needed by the batsmen to get results
	 */
	public SimulateCricketMatch(List<Player> playersMap, List<Integer> scoresList, Integer oversLeft,
			Integer runsNeedToWin) {
		this.ballsLeft = oversLeft * 6;
		this.playersList = playersMap;
		this.runsNeededToWin = runsNeedToWin;
		this.scoresList = scoresList;
	}

	public SimulateCricketMatch() {
		//No-op
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	/*
	 * Match prediction logic is processed here
	 */
	public Integer predictTheMatch() {
		Queue<Player> playersInQueue = new LinkedList<>();
		playersInQueue.addAll(playersList);
		Integer currentScore = 0;
		Integer ballsBowled = 0;
		Integer oversCount = (ballsLeft / 6);
		Player player1 = playersInQueue.poll();
		Player player2 = playersInQueue.poll();
		Integer player1BallPlayed = 0;
		Integer player2BallsPlayed = 0;
		Integer player1RunsScored = 0;
		Integer player2RunsScored = 0;
		for (int i = 0 ; i <= ballsLeft; i++) {
			if (currentScore >= runsNeededToWin) {
				matchStatus = "won";
				break;
			}
			if (ballsBowled % 6 == 0) {
				if (isPlayerOneAtStrike) {
					isPlayerOneAtStrike = false;
				} else {
					isPlayerOneAtStrike = true;
				}
				System.out.println(oversCount+" Overs left. "+(runsNeededToWin-currentScore)+" to win" );
				System.out.println("-----------------------------------------------------------");
				oversCount--;
			}
			if (isPlayerOneAtStrike) {
				player1BallPlayed++;
				Integer scoredByBatsmen1 = GenerateRandomNumber.getRandomItem(scoresList,
						player1.getPlayersScoreProbability());
				if (scoreType(scoredByBatsmen1) == -1)
					break;
				if (scoredByBatsmen1 == Scores.ONERUN.getAction() || scoredByBatsmen1 == Scores.THREERUNS.getAction()
						|| scoredByBatsmen1 == Scores.FIVERUNS.getAction()) {
					isPlayerOneAtStrike = false;
				}
				if (scoreType(scoredByBatsmen1) != Scores.OUT.getAction()) {
					player1RunsScored += scoredByBatsmen1;
					currentScore += scoredByBatsmen1;
					System.out.println(player1.getPlayerName() + " scores " + scoredByBatsmen1 + " runs");
					System.out.println();
				}
				if (scoredByBatsmen1 == Scores.OUT.getAction()) {
					ballsBowled++;
					System.out.println(player1.getPlayerName() + " is out....!!!");
					System.out.println();
					player1.setStatus("out");
					player1.setBallsPlayed(player1BallPlayed.toString());
					player1.setRunsScored(player1RunsScored.toString());
					player1BallPlayed = 0;
					player1RunsScored = 0;
					if (!playersInQueue.isEmpty())
						player1 = playersInQueue.poll();
					else {
						matchStatus = "lost";
						break;
					}
				}
				player1.setBallsPlayed(player1BallPlayed.toString());
				player1.setRunsScored(player1RunsScored.toString());
			} else {
				player2BallsPlayed++;
				Integer scoredByBatsmen2 = GenerateRandomNumber.getRandomItem(scoresList,
						player2.getPlayersScoreProbability());
				if (scoreType(scoredByBatsmen2) == -1)
					break;
				if (scoredByBatsmen2 == Scores.ONERUN.getAction() || scoredByBatsmen2 == Scores.THREERUNS.getAction()
						|| scoredByBatsmen2 == Scores.FIVERUNS.getAction()) {
					isPlayerOneAtStrike = true;
				}
				if (scoreType(scoredByBatsmen2) != Scores.OUT.getAction()) {
					player2RunsScored += scoredByBatsmen2;
					currentScore += scoredByBatsmen2;
					System.out.println(player2.getPlayerName() + " scores " + scoredByBatsmen2 + " runs");
					System.out.println();
				}
				if (scoredByBatsmen2 == Scores.OUT.getAction()) {
					ballsBowled++;
					System.out.println(player2.getPlayerName() + " is out....!!!");
					System.out.println();
					player2.setStatus("out");
					player2.setBallsPlayed(player2BallsPlayed.toString());
					player2.setRunsScored(player2RunsScored.toString());
					player2BallsPlayed = 0;
					player2RunsScored = 0;
					if (!playersInQueue.isEmpty())
						player2 = playersInQueue.poll();
					else {
						matchStatus = "lost";
						break;
					}
				}
				player2.setBallsPlayed(player2BallsPlayed.toString());
				player2.setRunsScored(player2RunsScored.toString());
				
			}
			ballsBowled++;
		}
		return 0;

	}

	private static Integer scoreType(Integer randomScorePerBall) {
		Integer score;
		switch (randomScorePerBall) {
		case 0:
			score = Scores.DOT.getAction();
			break;
		case 1:
			score = Scores.ONERUN.getAction();
			break;
		case 2:
			score = Scores.TWORUNS.getAction();
			break;
		case 3:
			score = Scores.THREERUNS.getAction();
			break;
		case 4:
			score = Scores.FOUR.getAction();
			break;
		case 5:
			score = Scores.FIVERUNS.getAction();
			break;
		case 6:
			score = Scores.SIXER.getAction();
			break;
		case 7:
			score = Scores.OUT.getAction();
			break;
		default:
			score = -1;
			break;
		}

		return score;

	}
}
