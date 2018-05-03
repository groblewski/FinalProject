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
	public HBox hb;
	public VBox labels;
	private VBox scores;
	private Team team1;
	private Team team2;
	//private  VBox lbls; 
	Label nl;
	Label nl2;
	public Label lbl1;
	public Label lbl2;
	
	public Button newbie;
	public int txt1;
	public int txt2;
	
	public TextField t1;
	public TextField t2;
	
	
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
		if(lbl1.getText() != "TBD" || lbl2.getText() != "TBD") {
			
		}
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
		nl = new Label(teamOne.getName());
		nl2 = new Label(teamTwo.getName());
		
		labels.getChildren().addAll(nl,new Label(teamTwo.getName()));
		hb.getChildren().add(labels);

		VBox scores = new VBox();
		scores.setAlignment(Pos.CENTER_RIGHT);
		 t1 = new TextField("Score");
		t1.setPrefColumnCount(4);
		 t2 = new TextField("Score");
		t2.setPrefColumnCount(4);
		 		 
		 
		newbie = new Button ("ERT");
		scores.getChildren().addAll(t1, t2, newbie);
		
		
		
		
		
		
		hb.getChildren().add(scores);
		
	

		
	}
	
	

	
	public void setLabels (Team teamOne, Team teamTwo) {
		 labels.getChildren().setAll(new Label(teamOne.getName()), new Label(teamTwo.getName()));
		
		
		
	}
	
	public void getTeamOneScore () {
		
	}
	
	public void getTeamTwoScore () {
		
	}
	
	
	public HBox getBox() {
		return hb;
	}
	

}
