package application;

import com.sun.javafx.tk.Toolkit.Task;

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
	private  VBox lbls; 
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
		
		
		lbls = new VBox();
	
		lbls.setAlignment(Pos.TOP_CENTER);
		lbls.setSpacing(10);
		lbls.setPadding(new Insets(5, 0, 0, 0));
		lbl1 = new Label("TBD");
		lbl2 = new Label("TBD");
		lbls.getChildren().addAll(lbl1,lbl2);
		
		VBox scores = new VBox();
		scores.setAlignment(Pos.CENTER_RIGHT);
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(4);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(4);
		scores.getChildren().addAll(t1, t2, new Button("Submit"));

		
		hb.getChildren().add(lbls);
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

		
		
		
		newbie.setOnAction(e -> { //compares the scores
			
			Integer txt1 = Integer.valueOf(t1.getText());
			Integer txt2 = Integer.valueOf(t2.getText());
			
			if (txt1 > txt2 ) {
				//should give us the winner 
				//put into the next game
				
				teamOne.setWinner(txt1);
				Main main = new Main();
				if (game == "firstRoundGameLeftOne") {
					//main.quarterFinalGameLeftOne.team1 = teamOne;
					//main.quarterFinalGameLeftOne.labels.getChildren().addAll(new Label(teamOne.getName()),new Label("TBD"));
					//main.quarterFinalGameLeftOne.setLabels(teamOne, teamTwo);
					
					if (main.quarterFinalGameLeftOne.equals(null)) {
						System.out.println("null");
					}
					else {
						System.out.println(main.quarterFinalGameLeftOne.lbl1.getText());
						main.quarterFinalGameLeftOne.lbl1.setText("face");
						System.out.println(main.quarterFinalGameLeftOne.lbl1.getText());
						//hb.getChildren().addAll(lbl1);
						
						
					}
					
					//main.quarterFinalGameLeftOne.labels.set
					if(main.firstRoundGameLeftTwo != null) {
						
						main.quarterFinalGameLeftOne.team2 = teamTwo;
					}
					
					
				}
				if (game == "firstRoundGameLeftTwo") {
					main.quarterFinalGameLeftOne.team2 = teamTwo;
					if(main.firstRoundGameLeftOne != null) {
						main.quarterFinalGameLeftOne.team1 = teamOne;
						
					}
					
				}
				if (game == "firstRoundGameLeftThree") {
					
				}
				if (game == "firstRoundGameLeftFour") {
					
				}
				
				if (game == "firstRoundGameRightOne") {
					
				}
				
				if (game == "firstRoundGameRightTwo") {
					
				}
				if (game == "firstRoundGameRightThree") {
					
				}
				if (game == "firstRoundGameRightFour") {
					
				}
				
				
				
				
			}
				
				
					
			else {
				System.out.println(txt2);
			}
		});

		
		hb.getChildren().add(labels);
		hb.getChildren().add(scores);
	}
	
	private void check () {
		
	}
	
	public void setLabels (Team teamOne, Team teamTwo) {
		lbls.getChildren().setAll(new Label(teamOne.getName()),new Label(teamTwo.getName()));
		
	}
	
	public void getTeamOneScore () {
		
	}
	
	public void getTeamTwoScore () {
		
	}
	
	
	public HBox getBox() {
		return hb;
	}
	

}
