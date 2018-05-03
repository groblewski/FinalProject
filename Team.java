package application;

public class Team {
	private String name;
	private int previousScore;
	private int scoreTeam;
	
	public Team(String name) {
		this.name = name;
		this.previousScore = 0;
	}
	
	public void setWinner(int score) {
		this.scoreTeam = score;
	}
	
	public int getWinner() {
		return scoreTeam;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPreviousScore() {
		return this.previousScore;
	}
	
	public void setPreviousScore(int previousScore) {
		this.previousScore = previousScore;
	}
}
