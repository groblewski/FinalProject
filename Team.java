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
	private String name;
	private int scoreTeam;
	
	public Team() {
		this.name = null;
	}
	
	public Team(String name){
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
}
