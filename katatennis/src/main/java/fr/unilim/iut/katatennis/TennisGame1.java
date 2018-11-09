package fr.unilim.iut.katatennis;

public class TennisGame1 implements TennisGame {

	private int scoreJoueur1;
	private int scoreJoueur2;
	private String player1Name;
	

	public TennisGame1(String player1Name) {
		this.player1Name = player1Name;
		
		this.scoreJoueur1=0;
		this.scoreJoueur2=0;
	}

	public void wonPoint(String playerName) {
		if (playerName == player1Name)
			scoreJoueur1 += 1;
		else
			scoreJoueur2 += 1;
	}

	public String getScore() {
		String score = "";
		int tempScore = 0;
		if (scoreJoueur1 == scoreJoueur2) {
			score = nameOfEgalityScored();
		} else if (scoreJoueur1 >= 4 || scoreJoueur2 >= 4) {
			score = scoreForAdvantageAndMore();
		} else {
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					tempScore = scoreJoueur1;
				else {
					score += "-";
					tempScore = scoreJoueur2;
				}
				switch (tempScore) {
				case 0:
					score += "Love";
					break;
				case 1:
					score += "Fifteen";
					break;
				case 2:
					score += "Thirty";
					break;
				case 3:
					score += "Forty";
					break;
				default :
					System.err.println("Erreur");
				}
			}
		}
		return score;
	}

	private String scoreForAdvantageAndMore() {
		String score;
		int minusResult = scoreJoueur1 - scoreJoueur2;
		if (minusResult == 1)
			score = "Advantage player1";
		else if (minusResult == -1)
			score = "Advantage player2";
		else if (minusResult >= 2)
			score = "Win for player1";
		else
			score = "Win for player2";
		return score;
	}

	private String nameOfEgalityScored() {
		String score;
		switch (scoreJoueur1) {
		case 0:
			score = "Love-All";
			break;
		case 1:
			score = "Fifteen-All";
			break;
		case 2:
			score = "Thirty-All";
			break;
		default:
			score = "Deuce";
			break;

		}
		return score;
	}
}