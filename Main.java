package application;

import java.util.ArrayList;

import javafx.application.Application;
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
	@Override
	public void start(Stage primaryStage) {
		GridPane gPane = new GridPane();
		gPane.setAlignment(Pos.CENTER);
		
		ArrayList<VBox> rows = new ArrayList<VBox>();
		
		for(int i = 0; i < 8; i++) {
			rows.add(new VBox());
			rows.get(i).setAlignment(Pos.CENTER);
		}
		
		//row 1
		for(int i = 0; i < 4; i++) {
			rows.get(0).getChildren().add(makeTeamBoxLeft());
		}
		
		//row2
		rows.get(1).getChildren().addAll(makeTeamBoxLeft(), makeTeamBoxLeft());
		
		//row3
		rows.get(2).getChildren().add(makeTeamBoxLeft());
		
		//row4
		VBox winners = new VBox();
		winners.getChildren().addAll(new Label("Winners"), new Label("1st Place"), new Label("Team"), 
				new Label("2nd Place"), new Label("Team"),
				new Label("3rd Place"), new Label("Team"));
		winners.setAlignment(Pos.CENTER);
		winners.setSpacing(1);
		rows.get(3).getChildren().add(winners);
		
		//row5
		rows.get(4).getChildren().add(makeTeamBoxRight());
		
		//row6
		rows.get(5).getChildren().addAll(makeTeamBoxRight(), makeTeamBoxRight());
		
		//row7
		for(int i = 0; i < 4; i++) {
			rows.get(6).getChildren().add(makeTeamBoxRight());
		}
		
		//adding rows to gpanes
		for(int i = 0; i < rows.size(); i++) {
			gPane.add(rows.get(i), i, 0);
		}
		
		Scene scene = new Scene(gPane, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();

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
		scores.getChildren().addAll(t1, t2, new Button("Submit"));

		
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
	
	public static void main(String[] args) {
		launch(args);
	}
}
