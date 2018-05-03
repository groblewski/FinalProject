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
	
	/**
	 * No argument constructor
	 */
	public Team() {
		this.name = null;
	}
	
	/**
	 * constructs Team object with a given name
	 * @param name name of team
	 */
	public Team(String name){
		this.name = name;
	}
	
	/*
	 * Sets winner and associates score
	 * @param score score of winner
	 */
	public void setWinner(int score) {
		this.scoreTeam = score;
	}
	
	/*
	 * gets winner
	 */
	public int getWinner() {
		return scoreTeam;
	}
	
	/*
	 * Gets name
	 */
	public String getName() {
		return this.name;
	}
	
	/*
	 * Sets name
	 * @param name name to be set 
	 */
	public void setName(String name) {
		this.name = name;
	}
}
