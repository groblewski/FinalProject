package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	static ArrayList<String> teamList;
	
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
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		List <Team>teams = new ArrayList();
		
		for(int i=0; i < teamList.size(); i++) {
			teams.add(new Team(teamList.get(i)));
		}
		
//		
//		
//		teams.add(new Team("Brian", 1));
//		teams.add(new Team("Jared", 2));
//		teams.add(new Team("Brennan", 3));
//		teams.add(new Team("Mustafa", 4));
//		teams.add(new Team("Caitlyn", 5));
//		teams.add(new Team("Jacob", 6));
//		teams.add(new Team("Phyllis", 7));
//		teams.add(new Team("Michael", 8));
//		teams.add(new Team("Lisa", 1));
//		teams.add(new Team("Mary-Ellen", 2));
//		teams.add(new Team("Mark", 3));
//		teams.add(new Team("Steve", 4));
//		teams.add(new Team("Corky", 5));
//		teams.add(new Team("Paul", 6));
//		teams.add(new Team("David", 7));
//		teams.add(new Team("Lillian", 8));
	
		
		
		
		GridPane gPane = new GridPane();
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
		

		//adding rows to gpanes
		for(int i = 0; i < rows.size(); i++) {
			gPane.add(rows.get(i), i, 1);
		}

		
		Scene scene = new Scene(gPane, Color.BLACK);
		scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tournament Bracket");
		primaryStage.show();

	}
	
	public void updateGames (Team winner) {
		
	}
	
//	public HBox makeTeamBoxLeft() {
//		
//		HBox hb = new HBox();
//		hb.setAlignment(Pos.CENTER);
//		hb.setPadding(new Insets(10,10,10,10));
//		
//		VBox labels = new VBox();
//		labels.setAlignment(Pos.TOP_CENTER);
//		labels.setSpacing(10);
//		labels.setPadding(new Insets(5, 0, 0, 0));
//		
//		
//		
//		
//		labels.getChildren().addAll(new Label("Team1"),new Label("Team2"));
//		
//		
//		//newbie.setOnAction(e -> {
////		Integer txt1 = Integer.valueOf(t1.getText());
////		Integer txt2 = Integer.valueOf(t2.getText());
//	//	
////		if (txt1 > txt2 )
////			System.out.println(txt1);
////		else {
////			System.out.println(txt2);
////		}
//	//});
//
//		
//		VBox scores = new VBox();
//		TextField t1 = new TextField("Score");
//		t1.setPrefColumnCount(1);
//		TextField t2 = new TextField("Score");
//		t2.setPrefColumnCount(1);
//		
//	
//		
//		scores.getChildren().addAll(t1, t2, new Button("Useless"));
//		
//		
//		
//		
//		hb.getChildren().add(labels);
//		hb.getChildren().add(scores);
//		
//		return hb;
//	}
//	
//public HBox makeTeamBoxRight() {
//		
//		HBox hb = new HBox();
//		hb.setAlignment(Pos.CENTER);
//		hb.setPadding(new Insets(10,10,10,10));
//		
//		VBox labels = new VBox();
//		labels.setAlignment(Pos.TOP_CENTER);
//		labels.setSpacing(10);
//		labels.setPadding(new Insets(5, 0, 0, 0));
//		labels.getChildren().addAll(new Label("Team1"),new Label("Team2"));
//		
//		VBox scores = new VBox();
//		TextField t1 = new TextField("Score");
//		t1.setPrefColumnCount(1);
//		TextField t2 = new TextField("Score");
//		t2.setPrefColumnCount(1);
//		scores.getChildren().addAll(t1, t2, new Button("Submit"));
//
//		hb.getChildren().add(scores);
//		hb.getChildren().add(labels);
//		
//		return hb;
//	}
//
//public VBox makeTeamBoxChampionship() {
//	
//	VBox vb = new VBox();
//	vb.setAlignment(Pos.CENTER);
//	vb.setPadding(new Insets(10,10,10,10));
//	
//
//	TextField t1 = new TextField("Score");
//	t1.setPrefColumnCount(1);
//	TextField t2 = new TextField("Score");
//	t2.setPrefColumnCount(1);
//
//	vb.getChildren().addAll(new Label("Team1"), t1, new Label("Team2"), t2, new Button("SAD"));
//	
//	return vb;
//}
public static Stream<String> getWordStream(String filepath) throws IOException {
	
	Stream <String> stream = Files.lines(Paths.get(filepath));
	stream = stream.filter(str->str.trim().length() > 0);
	stream = stream.map(String::trim);
	stream = stream.map(String::toUpperCase);
	
	return stream;
}	
	public static void main(String[] args) {
	
		Stream <String> stream = null;
	
		if (0 == args.length) {
			System.out.println("Amount of arguments found: " + args.length);
			System.exit(-1);
		}
	
		else {
		
		String fileName = args[0];
		teamList = new ArrayList<String>();
	
		try {
			stream = Main.getWordStream(fileName);
		}
	
		catch (IOException e) {
			System.out.println("Unable to find the file: " + fileName);
			System.exit(-1);
		}
	
		teamList = (ArrayList<String>) stream.collect(Collectors.toList());
		System.out.print(teamList);
		launch(args);
		}
	}
}
