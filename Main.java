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

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application {
	//NO NEGATIVE VALUES,
	//NO STRINGS
	//WHEN TIE, DELETE THE NAME
	//increase the length of the label
	
	public Game championshipGame;
	
	public Game semiFinalGameLeft;
	public Game semiFinalGameRight;
	
	public Game quarterFinalGameLeftOne ;
	Game quarterFinalGameLeftTwo;
	public Game quarterFinalGameRightOne;
	public Game quarterFinalGameRightTwo;
	
	public Game firstRoundGameLeftOne;
	public Game firstRoundGameLeftTwo;
	public Game firstRoundGameLeftThree;
	public Game firstRoundGameLeftFour;
	public Game firstRoundGameRightOne;
	public Game firstRoundGameRightTwo;
	public Game firstRoundGameRightThree;
	public Game firstRoundGameRightFour;
	
	Thread myTaskThread;
	MyTask myTask;
	
	GridPane gPane = new GridPane();
	
	//String looserR
	String looserL;
	
	
	@Override
	public void start(Stage primaryStage) {
	
		List <Team>teams = new ArrayList();
		
		
		
		teams.add(new Team("Brian", 1));
		teams.add(new Team("Jared", 2));
		teams.add(new Team("Brennan", 3));
		teams.add(new Team("Mustafa", 4));
		teams.add(new Team("Caitlyn", 5));
		teams.add(new Team("Jacob", 6));
		teams.add(new Team("Phyllis", 7));
		teams.add(new Team("Michael", 8));
		teams.add(new Team("Lisa", 1));
		teams.add(new Team("Mary-Ellen", 2));
		teams.add(new Team("Mark", 3));
		teams.add(new Team("Steve", 4));
		teams.add(new Team("Corky", 5));
		teams.add(new Team("Paul", 6));
		teams.add(new Team("David", 7));
		teams.add(new Team("Lillian", 8));
		
		gPane.setAlignment(Pos.CENTER);
		
		ArrayList<VBox> rows = new ArrayList<VBox>();
		
		for(int i = 0; i < 8; i++) {
			rows.add(new VBox());
			rows.get(i).setAlignment(Pos.CENTER);
		}
		
		if (teams.size() == 1) {
		}
		
		if (teams.size() > 1) {
			championshipGame = new Game(null,null, "TBD");
			if (teams.size() > 2) {
				rows.get(3).getChildren().addAll(championshipGame.getBox());
				semiFinalGameLeft = new Game(null, null, "TBD");
				semiFinalGameRight = new Game(null, null, "TBD");
				if (teams.size() > 4) {
					rows.get(2).getChildren().addAll(semiFinalGameLeft.getBox());
					rows.get(4).getChildren().addAll(semiFinalGameRight.getBox());
					

					quarterFinalGameLeftOne = new Game(null, null, "TBD");
					quarterFinalGameLeftTwo = new Game(null, null, "TBD");
					quarterFinalGameRightOne = new Game(null, null, "TBD");
					quarterFinalGameRightTwo = new Game(null, null, "TBD");
					if (teams.size() > 8) {
						
					
						
						firstRoundGameLeftOne = new Game(teams.get(0), teams.get(15), "firstRoundGameLeftOne");
						firstRoundGameLeftTwo = new Game(teams.get(2), teams.get(13), "firstRoundGameLeftTwo");
						
						firstRoundGameLeftOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(firstRoundGameLeftOne.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameLeftOne.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameLeftOne.nl.setText(firstRoundGameLeftOne.nl.getText());
							}
							else if (txt1 < txt2) {
								quarterFinalGameLeftOne.nl.setText(firstRoundGameLeftOne.nl2.getText());
							}
							else {
								
							}
							
							}
						});
						
						
						firstRoundGameLeftTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {

								int txt1 = Integer.parseInt(firstRoundGameLeftTwo.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameLeftTwo.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameLeftOne.nl2.setText(firstRoundGameLeftTwo.nl.getText());
							}
							else if (txt1 < txt2) {
								quarterFinalGameLeftOne.nl2.setText(firstRoundGameLeftTwo.nl2.getText());
							}
							else {
								
							}
							
							}
						});
				
						firstRoundGameLeftThree = new Game(teams.get(4), teams.get(11), "firstRoundGameLeftThree");
						firstRoundGameLeftFour = new Game(teams.get(6), teams.get(9), "firstRoundGameLeftFour");
						
						firstRoundGameLeftThree.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(firstRoundGameLeftThree.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameLeftThree.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameLeftTwo.nl.setText(firstRoundGameLeftThree.nl.getText());
							}
							else if (txt1 < txt2) {
								quarterFinalGameLeftTwo.nl.setText(firstRoundGameLeftThree.nl2.getText());
							}
							else {
								
							}
							
							}
						});
						
						firstRoundGameLeftFour.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(firstRoundGameLeftFour.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameLeftFour.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameLeftTwo.nl2.setText(firstRoundGameLeftFour.nl.getText());
							}
							else if (txt1 < txt2 ) {
								quarterFinalGameLeftTwo.nl2.setText(firstRoundGameLeftFour.nl2.getText());
							}
							else {
								
							}
							
							}
						});

						firstRoundGameRightOne = new Game(teams.get(1), teams.get(14), "firstRoundGameRightOne");
						
						firstRoundGameRightOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(firstRoundGameRightOne.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameRightOne.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameRightOne.nl.setText(firstRoundGameRightOne.nl.getText());
							}
							else if (txt1 < txt2) {
								quarterFinalGameRightOne.nl.setText(firstRoundGameRightOne.nl2.getText());
							}
							else {
								
							}
							
							}
						});

						
						firstRoundGameRightTwo = new Game(teams.get(3), teams.get(12), "firstRoundGameRightTwo");
						
						firstRoundGameRightTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {

								int txt1 = Integer.parseInt(firstRoundGameRightTwo.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameRightTwo.t2.getText());

							if(txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameRightOne.nl2.setText(firstRoundGameRightTwo.nl.getText());
							}
							else if (txt1 < txt2) {
								quarterFinalGameRightOne.nl2.setText(firstRoundGameRightTwo.nl2.getText());
							}
							else {
								
							}
							
							}
						});
						
						firstRoundGameRightThree = new Game(teams.get(5), teams.get(10), "firstRoundGameRightThree");
						
						
						firstRoundGameRightThree.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(firstRoundGameRightThree.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameRightThree.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameRightTwo.nl.setText(firstRoundGameRightThree.nl.getText());
							}
							else if (txt1 < txt2) {
								quarterFinalGameRightTwo.nl.setText(firstRoundGameRightThree.nl2.getText());
							}
							else {
								
							}
							
							}
						});
						
						
						firstRoundGameRightFour = new Game(teams.get(7), teams.get(8), "firstRoundGameRightFour");
						firstRoundGameRightFour.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(firstRoundGameRightFour.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameRightFour.t2.getText());

								
							if (txt1 > txt2) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameRightTwo.nl2.setText(firstRoundGameRightFour.nl.getText());
								
								
							}
							else if (txt1 < txt2) {
								quarterFinalGameRightTwo.nl2.setText(firstRoundGameRightFour.nl2.getText());
							}
							else {
								
							}
							

							}
						});
						
						quarterFinalGameLeftOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								int txt1 = Integer.parseInt(quarterFinalGameLeftOne.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameLeftOne.t2.getText());

							if (txt1 > txt2) {
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								semiFinalGameLeft.nl.setText(quarterFinalGameLeftOne.nl.getText());
							}
							else if (txt1 < txt2) {
								semiFinalGameLeft.nl.setText(quarterFinalGameLeftOne.nl2.getText());
								
							}
							else {
								
							}
							
							}
						});
						
						quarterFinalGameLeftTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								//quarterFinalGameRightTwo = new Game(quarterFinalGameRightTwo.team1,quarterFinalGameRightTwo.team2, "quarterFinalGameRightTwo");
								
								//System.out.println(quarterFinalGameRightTwo == null);

								int txt1 = Integer.parseInt(quarterFinalGameLeftTwo.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameLeftTwo.t2.getText());

							if (txt1 > txt2) {
								
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								semiFinalGameLeft.nl2.setText(quarterFinalGameLeftTwo.nl.getText());
							}
							else if (txt1 < txt2) {
								semiFinalGameLeft.nl2.setText(quarterFinalGameLeftTwo.nl2.getText());
								
							}
							else {
								
							}
							
							}
						});

						quarterFinalGameRightTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								//quarterFinalGameRightTwo = new Game(quarterFinalGameRightTwo.team1,quarterFinalGameRightTwo.team2, "quarterFinalGameRightTwo");
								
								//System.out.println(quarterFinalGameRightTwo == null);

								int txt1 = Integer.parseInt(quarterFinalGameRightTwo.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameRightTwo.t2.getText());

							if (txt1 > txt2) {
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								semiFinalGameRight.nl2.setText(quarterFinalGameRightTwo.nl.getText());
							}
							else if (txt1 < txt2) {
								semiFinalGameRight.nl2.setText(quarterFinalGameRightTwo.nl2.getText());
								
							}
							else {
								
							}
							
							}
						});
	
						
						quarterFinalGameRightOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								//quarterFinalGameRightTwo = new Game(quarterFinalGameRightTwo.team1,quarterFinalGameRightTwo.team2, "quarterFinalGameRightTwo");
								
								//System.out.println(quarterFinalGameRightTwo == null);

								int txt1 = Integer.parseInt(quarterFinalGameRightOne.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameRightOne.t2.getText());
								
							if(txt1 > txt2) {
								
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								semiFinalGameRight.nl.setText(quarterFinalGameRightOne.nl.getText());
							}
							else if (txt1 < txt2) {
								semiFinalGameRight.nl.setText(quarterFinalGameRightOne.nl2.getText());
								
							}
							else {
								
							}
							
							}
						});
						
						
						semiFinalGameLeft.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								//quarterFinalGameRightTwo = new Game(quarterFinalGameRightTwo.team1,quarterFinalGameRightTwo.team2, "quarterFinalGameRightTwo");
								
								//System.out.println(quarterFinalGameRightTwo == null);

								int txt1 = Integer.parseInt(semiFinalGameLeft.t1.getText());
								int  txt2 = Integer.parseInt(semiFinalGameLeft.t2.getText());

							if (txt1 > txt2) {
								
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								championshipGame.nl.setText(semiFinalGameLeft.nl.getText());
								looserL = championshipGame.nl2.getText();
								//Team looserLeft = 
							}
							else if (txt1 < txt2) {
								championshipGame.nl.setText(semiFinalGameLeft.nl2.getText());
								looserL = championshipGame.nl2.getText();
								
							}
							else {
								
							}
							
							}
						});
						
						semiFinalGameRight.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								//quarterFinalGameRightTwo = new Game(quarterFinalGameRightTwo.team1,quarterFinalGameRightTwo.team2, "quarterFinalGameRightTwo");
								
								//System.out.println(quarterFinalGameRightTwo == null);

								int txt1 = Integer.parseInt(semiFinalGameRight.t1.getText());
								int  txt2 = Integer.parseInt(semiFinalGameRight.t2.getText());


								
							if(txt1 > txt2) {
								
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								championshipGame.nl2.setText(semiFinalGameRight.nl.getText());
								//looserR = semiFinalGameRight.t2.getText();
								
							}
							else if (txt1 < txt2) {
								championshipGame.nl2.setText(semiFinalGameRight.nl2.getText());
								//looserR = semiFinalGameRight.t1.getText();
								
							}
							else {
								
							}
							
							}
						});
						
						championshipGame.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								Label firsPlace = new Label();
								Label secPlace = new Label();
								//quarterFinalGameRightTwo = new Game(quarterFinalGameRightTwo.team1,quarterFinalGameRightTwo.team2, "quarterFinalGameRightTwo");
								
								//System.out.println(quarterFinalGameRightTwo == null);

								int txt1 = Integer.parseInt(championshipGame.t1.getText());
								int  txt2 = Integer.parseInt(championshipGame.t2.getText());//semiFinalGameRight
								
							if(txt1 > txt2) {	
								//semiFinalGameRight = new Game(teamOne,null, "TBD");
								//championshipGame.nl2.setText(semiFinalGameRight.nl.getText());								
								String ans = "1st " + championshipGame.nl.getText();				
								firsPlace = new Label(ans);		
								String sec = "2nd" + championshipGame.nl2.getText();
								Label secondPlace = new Label(sec);	
								VBox rank = new VBox();
								rank.getChildren().addAll(firsPlace,secondPlace);
								rows.get(3).getChildren().setAll(rank);
							}
							else if (txt1 < txt2) {
								String ans = "1st " + championshipGame.nl2.getText();
								
								firsPlace = new Label(ans);
								
								String sec = "2nd" + championshipGame.nl.getText();
								Label secondPlace = new Label(sec);
							
								
								VBox rank = new VBox();
								rank.getChildren().addAll(firsPlace,secondPlace);
								rows.get(3).getChildren().setAll(rank);
								
								
							}
							else {
								//TIE
							}

							}
						});
					
						rows.get(1).getChildren().addAll(quarterFinalGameLeftOne.getBox(),
								quarterFinalGameLeftTwo.getBox());					
						rows.get(5).getChildren().addAll(quarterFinalGameRightOne.getBox(),
								quarterFinalGameRightTwo.getBox());				
						rows.get(0).getChildren().addAll(firstRoundGameLeftOne.getBox(), firstRoundGameLeftTwo.getBox(),
								firstRoundGameLeftThree.getBox(),firstRoundGameLeftFour.getBox());
						rows.get(7).getChildren().addAll(firstRoundGameRightOne.getBox(), firstRoundGameRightTwo.getBox(),
								firstRoundGameRightThree.getBox(),firstRoundGameRightFour.getBox());

					} else {
						quarterFinalGameLeftOne.setLabels(teams.get(0), teams.get(7));
						quarterFinalGameRightOne.setLabels(teams.get(1), teams.get(6));
						quarterFinalGameLeftTwo.setLabels(teams.get(2), teams.get(5));
						quarterFinalGameRightTwo.setLabels(teams.get(3), teams.get(4));
						rows.get(1).getChildren().addAll(quarterFinalGameLeftOne.getBox(),
								quarterFinalGameLeftTwo.getBox());
						
						rows.get(5).getChildren().addAll(quarterFinalGameRightOne.getBox(),
								quarterFinalGameRightTwo.getBox());
					}
				} else {
					semiFinalGameLeft.setLabels(teams.get(0), teams.get(3));
					semiFinalGameRight.setLabels(teams.get(1), teams.get(2));
					rows.get(2).getChildren().addAll(semiFinalGameLeft.getBox());
					rows.get(4).getChildren().addAll(semiFinalGameRight.getBox());
				}
			} else {
				championshipGame.setLabels(teams.get(0), teams.get(1));
				rows.get(3).getChildren().addAll(championshipGame.getBox());
			}
			
			
		}
		
//		//row 1
		
//		for(int i = 0; i < 4; i++) {
//			rows.get(0).getChildren().add(makeTeamBoxLeft());
//		}
//		
//		//row2
//		rows.get(1).getChildren().addAll(makeTeamBoxLeft(), makeTeamBoxLeft());
//		
//		//row3
//		rows.get(2).getChildren().add(makeTeamBoxLeft());
//		
//		//row4
//		rows.get(3).getChildren().addAll(championshipGame.getBox());
//		
//		//row5
//		rows.get(4).getChildren().add(makeTeamBoxRight());
//		
//		//row6
//		rows.get(5).getChildren().addAll(makeTeamBoxRight(), makeTeamBoxRight());
//		
//		//row7
//		for(int i = 0; i < 4; i++) {
//			rows.get(6).getChildren().add(makeTeamBoxRight());
//		}
//		
		//adding rows to gpanes
		for(int i = 0; i < rows.size(); i++) {
			gPane.add(rows.get(i), i, 1);
		}
		
		
		//Have yet to decide how to deal with displaying the winners
//		VBox winners = new VBox();
//		HBox placesAndTeams= new HBox();
//		VBox places = new VBox();
//		places.setAlignment(Pos.CENTER);
//		VBox winningTeams = new VBox();
//		winningTeams.setAlignment(Pos.CENTER);
//		
//		places.getChildren().addAll(new Label("1st Place:"), new Label("2nd Place:"), new Label("3rd Place:"));
//		winningTeams.getChildren().addAll( new Label("Team"),  new Label("Team"), new Label("Team"));
//		
//		placesAndTeams.getChildren().addAll(places, winningTeams);
//		winners.getChildren().addAll(new Label("Winners"), placesAndTeams); 
//		winners.setAlignment(Pos.CENTER);
//		winners.setSpacing(1);
//		
//		gPane.add(winners, 3, 0);

		
		Scene scene = new Scene(gPane, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
		//quarterFinalGameLeftOne.lbl1.setText("H:");

	}

	public HBox makeTeamBoxLeft() {
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(10,10,10,10));
		VBox labels = new VBox();
		labels.setAlignment(Pos.TOP_CENTER);
		labels.setSpacing(10);
		labels.setPadding(new Insets(5, 0, 0, 0));
		labels.getChildren().addAll(new Label("Team1"),new Label("Team2"));
		VBox scores = new VBox();
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(1);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(1);
		scores.getChildren().addAll(t1, t2, new Button("Useless"));
		hb.getChildren().add(labels);
		hb.getChildren().add(scores);
		return hb;
	}
	
public HBox makeTeamBoxRight() {
		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(10,10,10,10));
		VBox labels = new VBox();
		labels.setAlignment(Pos.TOP_CENTER);
		labels.setSpacing(10);
		labels.setPadding(new Insets(5, 0, 0, 0));
		labels.getChildren().addAll(new Label("Team1"),new Label("Team2"));
		VBox scores = new VBox();
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(1);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(1);
		scores.getChildren().addAll(t1, t2, new Button("Submit"));
		hb.getChildren().add(scores);
		hb.getChildren().add(labels);
		return hb;
	}

public VBox makeTeamBoxChampionship() {
	VBox vb = new VBox();
	vb.setAlignment(Pos.CENTER);
	vb.setPadding(new Insets(10,10,10,10));
	TextField t1 = new TextField("Score");
	t1.setPrefColumnCount(1);
	TextField t2 = new TextField("Score");
	t2.setPrefColumnCount(1);
	vb.getChildren().addAll(new Label("Team1"), t1, new Label("Team2"), t2, new Button("SAD"));
	return vb;
}

	public static void main(String[] args) {
		launch(args);
	}
	class MyTask extends Task<Void>{
        
        @Override
        protected Void call() throws Exception {
            for (int i = 1; i <= 100; i++) {
                updateProgress(i, 100);
                Thread.sleep(100);
            }
            return null;
        }
    }
}
