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

public class Game {
	private HBox hb;
	private VBox labels;
	private VBox scores;
	private Team team1;
	private Team team2;
	//private  VBox lbls; 
	private Label lbl1;
	private Label lbl2;
	public Game() {
//		hb = new HBox();
//		hb.setAlignment(Pos.CENTER);
//		hb.setPadding(new Insets(10,10,10,10));
//		labels = new VBox();
//		labels.setAlignment(Pos.TOP_CENTER);
//		labels.setSpacing(10);
//		labels.setPadding(new Insets(5, 0, 0, 0));
//		VBox scores = new VBox();
//		scores.getChildren().addAll(new Button("Submit"));
		hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(10,10,10,10));
		
		
		labels = new VBox();
	
		labels.setAlignment(Pos.TOP_CENTER);
		labels.setSpacing(10);
		labels.setPadding(new Insets(5, 0, 0, 0));
		lbl1 = new Label("TBD");
		lbl2 = new Label("TBD");
		labels.getChildren().addAll(lbl1,lbl2);
		
		
		VBox scores = new VBox();
		scores.setAlignment(Pos.CENTER_RIGHT);
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(4);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(4);
		scores.getChildren().addAll(t1, t2, new Button("Submit"));

		
		hb.getChildren().add(labels);
		hb.getChildren().add(scores);

	}
	
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
		labels.getChildren().addAll(new Label(teamOne.getName()),new Label(teamTwo.getName()));
		
		VBox scores = new VBox();
		scores.setAlignment(Pos.CENTER_RIGHT);
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(4);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(4);
		Button newbie = new Button ("ERT");
		scores.getChildren().addAll(t1, t2, newbie);

		
		
		
		newbie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				if (game == "firstRoundGameLeftOne") {
					System.out.println("succ");
					Main main = new Main();
					//main.quarterFinalGameLeftOne = new Game(teamOne,teamTwo, "bla");
				
				
		
			

			main.quarterFinalGameLeftOne.lbl1.setText("f");
			
			
		
			
			
		



			
				}
			
			}
		});
		
		hb.getChildren().add(labels);
		hb.getChildren().add(scores);
	}
	


	
	public void setLabels (Team teamOne, Team teamTwo) {
		 Main main = new Main();
		 main.quarterFinalGameLeftOne.labels.getChildren().setAll(new Label(teamOne.getName()),new Label(teamTwo.getName()));
		 main.quarterFinalGameLeftOne.hb.getChildren().setAll(new Label(teamOne.getName()),new Label(teamTwo.getName()));
		
	}
	
	public void getTeamOneScore () {
		
	}
	
	public void getTeamTwoScore () {
		
	}
	
	
	public HBox getBox() {
		return hb;
	}
	

}
