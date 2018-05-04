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

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.sun.javafx.tk.Toolkit.Task;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
* Creates an instance of a game between two Teams. Adds GUI elements to the 
* screen. These elements can be edited 
* 
* Bugs: No known bugs
*
* @author Emma Groblewski
* @author Brian Guth
*/
public class Game {
	public HBox hb;
	public VBox labels;
	public VBox scores;
	public Team team1;
	public Team team2;
	Label nl;
	Label nl2;
	public Button newbie;
	public int txt1;
	public int txt2;
	public TextField t1;
	public TextField t2;
	private int loserScore;
	private String loserTeam;

	public Game(Team teamOne, Team teamTwo, String game) {
		this.team1 = teamOne;
		this.team2 = teamTwo;
		
		hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(10,10,10,10));
		
		labels = new VBox();
		labels.setAlignment(Pos.TOP_CENTER);
		labels.setSpacing(10);
		labels.setPadding(new Insets(5, 0, 0, 0));
		
		if (team1 == null || team2 == null) {
			nl = new Label("TBD");
			nl2 = new Label("TBD");
			labels.getChildren().addAll(nl,nl2);
			hb.getChildren().add(labels);
		
		}
	
		else {
			nl = new Label(teamOne.getName());
			System.out.println(nl + " is nl");
			nl2 = new Label(teamTwo.getName());
			labels.getChildren().addAll(nl,new Label(teamTwo.getName()));
			hb.getChildren().add(labels);
		}
	
		scores = new VBox();
		scores.setAlignment(Pos.CENTER_RIGHT);
		t1 = new TextField("Score");
		t1.setPrefColumnCount(4);
		t2 = new TextField("Score");
		t2.setPrefColumnCount(4);
	 	newbie = new Button ("Submit");
		scores.getChildren().addAll(t1, t2, newbie);
		hb.getChildren().add(scores);
	}

	/**
	* Returns the HBox
	* @return hb
	*/
	public HBox getBox() {
		return hb;
	}
	/**
	* Returns the losers Score
	* @return loserScore
	*/
	public int getLoserScore() {
		return loserScore;
	}
	/**
	* Sets the losers Score
	*/
	public void setLoserScore(int loserScore) {
		this.loserScore = loserScore;
	}
	/**
	* Returns the losing team
	* @return loserTeam
	*/
	public String getLoserTeam() {
		return loserTeam;
	}
	/**
	* Sets the losing team
	*/
	public void setLoserTeam(String team12) {
		this.loserTeam = team12;
	}
}
