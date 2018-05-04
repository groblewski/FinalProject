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

/**
 * Creates an instance of a Team to be put into @see Game that is put into @see Main
 * 
 *@author(s) Brennan Fife, Brian Guth, Emma Groblewski, Mustafa Musabeyli, Jared Glaub
 */
public class Team {
	
	private String name;
	
	public Team() {
		this.name = null;
	}
	
	public Team(String name){
		this.name = name;
	}
	
	/**
	*
	*@return name of team
	*/
	public String getName() {
		return this.name;
	}
	
	/**
	*Sets the name of this team
	*
	*/
	public void setName(String name) {
		this.name = name;
	}

}
