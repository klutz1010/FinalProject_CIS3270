package edu.gsu.gui;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		
		primaryStage.setTitle("Flight Reservation System");
		primaryStage.setScene(new Scene(root, 600, 400));
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		
		launch(args);
		
	}
	
}
