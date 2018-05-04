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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends Application {
	static ArrayList<String> teamList;
	
	public Game championshipGame;
	
	public Game semiFinalGameLeft;
	public Game semiFinalGameRight;
	
	public Game quarterFinalGameLeftOne ;
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
	
	GridPane gPane = new GridPane();
	
	/**
	* Starts the program. Sets up the respective bracket. 'Newbie' is name for program's button.
	*
	*//
	@Override
	public void start(Stage primaryStage) {
		ArrayList<Team>teams = new ArrayList();
		
		for(int i = 0; i < teamList.size(); i++) {
			teams.add(new Team(teamList.get(i)));
		}
		
		gPane.setAlignment(Pos.CENTER);
		
		ArrayList<VBox> rows = new ArrayList<VBox>();
		
		for (int i = 0; i < 8; i++) {
			rows.add(new VBox());
			rows.get(i).setAlignment(Pos.CENTER);
		}
		
		if (teams.size() > 1) { //For files with more than 2 teams
			championshipGame = new Game(null,null, "TBD");
			
			championshipGame.newbie.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Label firsPlace = new Label();
					Label secPlace = new Label();
					Label thirdPlace = null;
					VBox rank = new VBox();
					
					String third;

					if(semiFinalGameLeft != null && semiFinalGameRight != null) {
						if(semiFinalGameLeft.getLoserScore() > semiFinalGameRight.getLoserScore()) {
							third = semiFinalGameLeft.getLoserTeam();
						} else {
							third = semiFinalGameRight.getLoserTeam();
						}
						thirdPlace = new Label("3rd Place: " + third);
					}

					try { 
						int txt1 = Integer.parseInt(championshipGame.t1.getText());
						int  txt2 = Integer.parseInt(championshipGame.t2.getText());

						if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
							if (txt1 > txt2) {								
								String ans = "1st: " + championshipGame.nl.getText(); //n1 = new label			
								firsPlace = new Label(ans);		
								String sec = "2nd: " + championshipGame.nl2.getText(); //nl2 = new label 
								secPlace = new Label(sec);

								if(thirdPlace != null) {
									rank.getChildren().addAll(firsPlace,secPlace,thirdPlace);
								} else {
									rank.getChildren().addAll(firsPlace,secPlace);
								}

								rows.get(3).getChildren().setAll(rank);
							}
							else if (txt1 < txt2) {
								String ans = "1st: " + championshipGame.nl2.getText();
								firsPlace = new Label(ans);
								String sec = "2nd:" + championshipGame.nl.getText();
								secPlace = new Label(sec);

								rank.getChildren().addAll(firsPlace,secPlace,thirdPlace);
								rows.get(3).getChildren().setAll(rank);
							}
						}
						
					} catch (NumberFormatException e) {

					}
				}
			});

			if (teams.size() > 2) { //if there is a file of 4+ teams
				rows.get(3).getChildren().addAll(championshipGame.getBox());
				semiFinalGameLeft = new Game(null, null, "TBD");
				semiFinalGameRight = new Game(null, null, "TBD");
				
				semiFinalGameLeft.newbie.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						try { 
							int txt1 = Integer.parseInt(semiFinalGameLeft.t1.getText());
							int  txt2 = Integer.parseInt(semiFinalGameLeft.t2.getText());

							if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
								if (txt1 > txt2) {
									championshipGame.nl.setText(semiFinalGameLeft.nl.getText());
									semiFinalGameLeft.setLoserScore(txt2);
									semiFinalGameLeft.setLoserTeam(semiFinalGameLeft.nl2.getText());
		 
								}
								else if (txt1 < txt2) {
									championshipGame.nl.setText(semiFinalGameLeft.nl2.getText());
									semiFinalGameLeft.setLoserScore(txt1);
									semiFinalGameLeft.setLoserTeam(semiFinalGameLeft.nl.getText());
									
								}
								semiFinalGameLeft.scores.getChildren().remove(2);
							}
						} catch (NumberFormatException e) {
							
						}
					}
				});

				semiFinalGameRight.newbie.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						try { 
							int txt1 = Integer.parseInt(semiFinalGameRight.t1.getText());
							int  txt2 = Integer.parseInt(semiFinalGameRight.t2.getText());

							if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
								if(txt1 > txt2) {
									championshipGame.nl2.setText(semiFinalGameRight.nl.getText());
									semiFinalGameRight.setLoserScore(txt2);
									semiFinalGameRight.setLoserTeam(semiFinalGameRight.nl2.getText());
								}
								else if (txt1 < txt2) {
									championshipGame.nl2.setText(semiFinalGameRight.nl2.getText());
									semiFinalGameRight.setLoserScore(txt1);
									semiFinalGameRight.setLoserTeam(semiFinalGameRight.nl.getText());
								}
								semiFinalGameRight.scores.getChildren().remove(2);
							}
							
						} catch (NumberFormatException e) {
							
						}
					}
				});
				
				if (teams.size() > 4) { //if file has 8+ teams
					rows.get(2).getChildren().addAll(semiFinalGameLeft.getBox());
					rows.get(4).getChildren().addAll(semiFinalGameRight.getBox());
					quarterFinalGameLeftOne = new Game(null, null, "TBD");
					quarterFinalGameLeftTwo = new Game(null, null, "TBD");
					quarterFinalGameRightOne = new Game(null, null, "TBD");
					quarterFinalGameRightTwo = new Game(null, null, "TBD");
					
					quarterFinalGameLeftOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							try { 
								int txt1 = Integer.parseInt(quarterFinalGameLeftOne.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameLeftOne.t2.getText());

								if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
									if (txt1 > txt2) {
										semiFinalGameLeft.nl.setText(quarterFinalGameLeftOne.nl.getText());
									}
									else if (txt1 < txt2) {
										semiFinalGameLeft.nl.setText(quarterFinalGameLeftOne.nl2.getText());
									}
									quarterFinalGameLeftOne.scores.getChildren().remove(2);
								}
								
							} catch (NumberFormatException e) {

							}
						}
					});

					quarterFinalGameLeftTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							try { 
								int txt1 = Integer.parseInt(quarterFinalGameLeftTwo.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameLeftTwo.t2.getText());

								if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
									if (txt1 > txt2) {
										semiFinalGameLeft.nl2.setText(quarterFinalGameLeftTwo.nl.getText());
									}
									else if (txt1 < txt2) {
										semiFinalGameLeft.nl2.setText(quarterFinalGameLeftTwo.nl2.getText());

									}
									quarterFinalGameLeftTwo.scores.getChildren().remove(2);
								}

							} catch (NumberFormatException e) {

							}
						}
					});

					quarterFinalGameRightTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							try { 
								int txt1 = Integer.parseInt(quarterFinalGameRightTwo.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameRightTwo.t2.getText());

								if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
									if (txt1 > txt2) {
										semiFinalGameRight.nl2.setText(quarterFinalGameRightTwo.nl.getText());
									}
									else if (txt1 < txt2) {
										semiFinalGameRight.nl2.setText(quarterFinalGameRightTwo.nl2.getText());

									}
									quarterFinalGameRightTwo.scores.getChildren().remove(2);
								}

							} catch (NumberFormatException e) {

							}
						}
					});

					quarterFinalGameRightOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							try { 
								int txt1 = Integer.parseInt(quarterFinalGameRightOne.t1.getText());
								int  txt2 = Integer.parseInt(quarterFinalGameRightOne.t2.getText());
								
								if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
									if(txt1 > txt2) {
										semiFinalGameRight.nl.setText(quarterFinalGameRightOne.nl.getText());
									}
									else if (txt1 < txt2) {
										semiFinalGameRight.nl.setText(quarterFinalGameRightOne.nl2.getText());

									}
									quarterFinalGameRightOne.scores.getChildren().remove(2);
								}
								
							} catch (NumberFormatException e) {
								
							}
						}
					});

					if (teams.size() > 8) { //if file has 16 teams
						firstRoundGameLeftOne = new Game(teams.get(0), teams.get(15), "firstRoundGameLeftOne");
						firstRoundGameLeftTwo = new Game(teams.get(2), teams.get(13), "firstRoundGameLeftTwo");
						firstRoundGameLeftThree = new Game(teams.get(4), teams.get(11), "firstRoundGameLeftThree");
						firstRoundGameLeftFour = new Game(teams.get(6), teams.get(9), "firstRoundGameLeftFour");
						firstRoundGameRightOne = new Game(teams.get(1), teams.get(14), "firstRoundGameRightOne");
						firstRoundGameRightTwo = new Game(teams.get(3), teams.get(12), "firstRoundGameRightTwo");
						firstRoundGameRightThree = new Game(teams.get(5), teams.get(10), "firstRoundGameRightThree");
						firstRoundGameRightFour = new Game(teams.get(7), teams.get(8), "firstRoundGameRightFour");

						firstRoundGameLeftOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 	
									int txt1 = Integer.parseInt(firstRoundGameLeftOne.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameLeftOne.t2.getText());
									
									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameLeftOne.nl.setText(firstRoundGameLeftOne.nl.getText());
						
										}
										else if (txt1 < txt2) {
											quarterFinalGameLeftOne.nl.setText(firstRoundGameLeftOne.nl2.getText());
											
										}
										firstRoundGameLeftOne.scores.getChildren().remove(2);
									}
									
								} catch (NumberFormatException e) {
									
								}
							}
						});

						firstRoundGameLeftTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameLeftTwo.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameLeftTwo.t2.getText());

									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameLeftOne.nl2.setText(firstRoundGameLeftTwo.nl.getText());
										}
										else if (txt1 < txt2) {
											quarterFinalGameLeftOne.nl2.setText(firstRoundGameLeftTwo.nl2.getText());
										}
										firstRoundGameLeftTwo.scores.getChildren().remove(2);
									}

								} catch (NumberFormatException e) {

								}
							}
						});

						firstRoundGameLeftThree.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameLeftThree.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameLeftThree.t2.getText());

									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameLeftTwo.nl.setText(firstRoundGameLeftThree.nl.getText());
										}
										else if (txt1 < txt2) {
											quarterFinalGameLeftTwo.nl.setText(firstRoundGameLeftThree.nl2.getText());
										}
										firstRoundGameLeftThree.scores.getChildren().remove(2);
									}

								} catch (NumberFormatException e) {
									
								}
							}
						});

						firstRoundGameLeftFour.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameLeftFour.t1.getText());
									int txt2 = Integer.parseInt(firstRoundGameLeftFour.t2.getText());

									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameLeftTwo.nl2.setText(firstRoundGameLeftFour.nl.getText());
										}
										else if (txt1 < txt2 ) {
											quarterFinalGameLeftTwo.nl2.setText(firstRoundGameLeftFour.nl2.getText());
										}
										firstRoundGameLeftFour.scores.getChildren().remove(2);
									}

								} catch (NumberFormatException e) {
									
								}
							}
						});

						firstRoundGameRightOne.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameRightOne.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameRightOne.t2.getText());

									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameRightOne.nl.setText(firstRoundGameRightOne.nl.getText());
										}
										else if (txt1 < txt2) {
											quarterFinalGameRightOne.nl.setText(firstRoundGameRightOne.nl2.getText());
										}
										firstRoundGameRightOne.scores.getChildren().remove(2);
									}
									
								} catch (NumberFormatException e) {
									
								}
							}
						});

						firstRoundGameRightTwo.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameRightTwo.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameRightTwo.t2.getText());

									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if(txt1 > txt2) {
											quarterFinalGameRightOne.nl2.setText(firstRoundGameRightTwo.nl.getText());
										}
										else if (txt1 < txt2) {
											quarterFinalGameRightOne.nl2.setText(firstRoundGameRightTwo.nl2.getText());
										}
										firstRoundGameRightTwo.scores.getChildren().remove(2);
									}

								} catch (NumberFormatException e) {
									
								}
							}
						});

						firstRoundGameRightThree.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameRightThree.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameRightThree.t2.getText());

									if(txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameRightTwo.nl.setText(firstRoundGameRightThree.nl.getText());
										}
										else if (txt1 < txt2) {
											quarterFinalGameRightTwo.nl.setText(firstRoundGameRightThree.nl2.getText());
										}
										firstRoundGameRightThree.scores.getChildren().remove(2);
									}
									
								} catch (NumberFormatException e) {
									
								}
							}
						});

						firstRoundGameRightFour.newbie.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								try { 
									int txt1 = Integer.parseInt(firstRoundGameRightFour.t1.getText());
									int  txt2 = Integer.parseInt(firstRoundGameRightFour.t2.getText());

									if (txt1 > 0 && txt2 > 0 && txt1 != txt2) {
										if (txt1 > txt2) {
											quarterFinalGameRightTwo.nl2.setText(firstRoundGameRightFour.nl.getText());
										}
										else if (txt1 < txt2) {
											quarterFinalGameRightTwo.nl2.setText(firstRoundGameRightFour.nl2.getText());
										}
										firstRoundGameRightFour.scores.getChildren().remove(2);
									}

								} catch (NumberFormatException e) {
									
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
						quarterFinalGameLeftOne.nl.setText(teams.get(0).getName());
						quarterFinalGameLeftOne.nl2.setText(teams.get(7).getName());
						quarterFinalGameRightOne.nl.setText(teams.get(1).getName());
						quarterFinalGameRightOne.nl2.setText(teams.get(6).getName());
						quarterFinalGameLeftTwo.nl.setText(teams.get(2).getName());
						quarterFinalGameLeftTwo.nl2.setText(teams.get(5).getName());
						quarterFinalGameRightTwo.nl.setText(teams.get(3).getName());
						quarterFinalGameRightTwo.nl2.setText(teams.get(4).getName());

						rows.get(1).getChildren().addAll(quarterFinalGameLeftOne.getBox(),
								quarterFinalGameLeftTwo.getBox());

						rows.get(5).getChildren().addAll(quarterFinalGameRightOne.getBox(),
								quarterFinalGameRightTwo.getBox());
					}
				} else {
					semiFinalGameLeft.nl.setText(teams.get(0).getName());
					semiFinalGameLeft.nl2.setText(teams.get(3).getName());
					semiFinalGameRight.nl.setText(teams.get(1).getName());
					semiFinalGameRight.nl2.setText(teams.get(2).getName());

					rows.get(2).getChildren().addAll(semiFinalGameLeft.getBox());
					rows.get(4).getChildren().addAll(semiFinalGameRight.getBox());
				}
			} else {
				championshipGame.nl.setText(teams.get(0).getName());
				championshipGame.nl2.setText(teams.get(1).getName());

				rows.get(3).getChildren().addAll(championshipGame.getBox());
			}
		}
		
		//adding rows to gpanes
		for(int i = 0; i < rows.size(); i++) {
			gPane.add(rows.get(i), i, 1);
		}
		
		Scene scene = new Scene(gPane, Color.BLACK);
		scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm()); //grab from .css file
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
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
			launch(args);
			}
		}
	}
