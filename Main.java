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
	
	
	public Game championshipGame;
	
	public Game semiFinalGameLeft;
	public Game semiFinalGameRight;
	
	public Game quarterFinalGameLeftOne = new Game();
	public Game quarterFinalGameLeftTwo;
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
			;
		}
		
		if (teams.size() > 1) {
			championshipGame = new Game();
			if(teams.size() > 2) {
				rows.get(3).getChildren().addAll(championshipGame.getBox());
				semiFinalGameLeft = new Game();
				semiFinalGameRight = new Game();
				if(teams.size() > 4) {
					rows.get(2).getChildren().addAll(semiFinalGameLeft.getBox());
					rows.get(4).getChildren().addAll(semiFinalGameRight.getBox());
					quarterFinalGameLeftOne = new Game();
					quarterFinalGameLeftTwo = new Game();
					quarterFinalGameRightOne = new Game();
					quarterFinalGameRightTwo = new Game();
					if(teams.size() > 8) {
						
					
						
						firstRoundGameLeftOne = new Game(teams.get(0), teams.get(15), "firstRoundGameLeftOne");
						firstRoundGameLeftTwo = new Game(teams.get(2), teams.get(13), "firstRoundGameLeftTwo");
						
						
						firstRoundGameLeftOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								
								
								int txt1 = Integer.parseInt(firstRoundGameLeftOne.t1.getText());
								int  txt2 = Integer.parseInt(firstRoundGameLeftOne.t2.getText());

								
							if(txt1 > txt2 ) {
								//System.out.println(firstRoundGameLeftOne.lbl1.getText());
								quarterFinalGameLeftOne.lbl1.setText(firstRoundGameLeftOne.nl.getText());
							}
							else if (txt1 < txt2 ) {
								quarterFinalGameLeftOne.lbl1.setText(firstRoundGameLeftOne.nl2.getText());
							}
							else {
								
							}
							
							}
						});
						
						
						
						
				
						firstRoundGameLeftThree = new Game(teams.get(4), teams.get(11), "firstRoundGameLeftThree");
						firstRoundGameLeftFour = new Game(teams.get(6), teams.get(9), "firstRoundGameLeftFour");
						firstRoundGameRightOne = new Game(teams.get(1), teams.get(14), "firstRoundGameRightOne");
						firstRoundGameRightTwo = new Game(teams.get(3), teams.get(12), "firstRoundGameRightTwo");
						firstRoundGameRightThree = new Game(teams.get(5), teams.get(10), "firstRoundGameRightThree");
						firstRoundGameRightFour = new Game(teams.get(7), teams.get(8), "firstRoundGameRightFour");
						
						
	
						
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
		//rows.get(3).getChildren().addAll(championshipGame.getBox());
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
	
	public void updateGames () {
		
		
	quarterFinalGameLeftOne.hb.getChildren().add(quarterFinalGameLeftOne.lbl1);
	
	quarterFinalGameLeftOne.labels.getChildren().add(quarterFinalGameLeftOne.lbl1);
		
		
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

//public void helper () {
//	
//	Task<Integer> task = new Task<Integer>() {
//        @Override
//        protected Integer call() throws Exception {
//            int i;
//            for (i = 0; i < 1001; i++) {
//                final int val = i;
//                System.out.println(val);
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException ie) {
//                }
//
//                // Update the GUI on the JavaFX Application Thread
//                Platform.runLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                      quarterFinalGameLeftOne. 
//                    }
//                });
//
//            }
//            return i;
//        }
//     };
//  
//
//     Thread th = new Thread(task);
//     th.setDaemon(true);
//     th.start();
//}
		
			
	

	
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
