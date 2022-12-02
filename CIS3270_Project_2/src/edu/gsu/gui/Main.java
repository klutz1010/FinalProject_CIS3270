package edu.gsu.gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	
	Stage stg;

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		primaryStage.setTitle("Flight Reservation System");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
	
}
