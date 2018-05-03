///////////////////////////////////////////////////////////////////////////////
//                   
// Title:            Milestone 3, Final Project
// Files:            Game.java, Main.java, Team.java, application.css
// Semester:         CS 400, Spring 2018
//
// Author(s):        Brennan Fife, Brian Guth, Emma Groblewski, 
//		     Mustafa Musabeyli, Jared Glaub
// Lecturer's Name:  Deb Deppeler
// Section:          001	
//
///////////////////////////////////////////////////////////////////////////////

package application;

public class Team {
	
	private int seed;
	private String name;
	private int previousScore;
	private int scoreTeam;
	
	
	public Team() {
		this.seed = 0;
		this.name = null;
		this.previousScore = 0;
	}
	
	public Team(String name, int seed){
		this.seed = seed;
		this.name = name;
		this.previousScore = 0;
	}
	
	
	public void setWinner(int score) {
		this.scoreTeam = score;
	}
	
	public int getWinner() {
		return scoreTeam;
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
