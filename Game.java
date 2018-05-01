package application;

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
		labels.getChildren().addAll(new Label("TBD"),new Label("TBD"));
		
		VBox scores = new VBox();
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(1);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(1);
		scores.getChildren().addAll(t1, t2, new Button("Submit"));

		
		hb.getChildren().add(labels);
		hb.getChildren().add(scores);

	}
	
	public Game(Team teamOne, Team teamTwo) {
		hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setPadding(new Insets(10,10,10,10));
		
		labels = new VBox();
		labels.setAlignment(Pos.TOP_CENTER);
		labels.setSpacing(10);
		labels.setPadding(new Insets(5, 0, 0, 0));
		labels.getChildren().addAll(new Label(teamOne.getName()),new Label(teamTwo.getName()));
		
		VBox scores = new VBox();
		TextField t1 = new TextField("Score");
		t1.setPrefColumnCount(1);
		TextField t2 = new TextField("Score");
		t2.setPrefColumnCount(1);
		scores.getChildren().addAll(t1, t2, new Button("Submit"));

		
		hb.getChildren().add(labels);
		hb.getChildren().add(scores);
	}
	
	public void setLabels (Team teamOne, Team teamTwo) {
		labels.getChildren().setAll(new Label(teamOne.getName()),new Label(teamTwo.getName()));
		
	}
	
	public HBox getBox() {
		return hb;
	}
	
//	public VBox getScores() {
//		return scores;
//	}
//	
//	public VBox getLabels() {
//		return labels;
//	}
}
