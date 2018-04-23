package application;

public class Team {
	
	private int seed;
	private String name;
	private int previousScore;
	
	
	Team() {
		this.seed = 0;
		this.name = null;
		this.previousScore = 0;
	}
	
	Team(String name, int seed){
		this.seed = seed;
		this.name = name;
		this.previousScore = 0;
	}
	
	public int getSeed() {
		return this.seed;
	}
	
	public void setSeed(int seed) {
		this.seed = seed;
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
