package edu.gsu.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Register2 {
	
	Stage window;
	
	public static void display(String title, String message) {
		
		Stage window = new Stage();
		window.setTitle("Login Page");
		window.show();
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(20, 20, 20, 20));
		grid.setVgap(10);
		grid.setHgap(10);
		
		//Constraints
		//ColumnConstraints column1 = new ColumnConstraints(100, 150, 300);
		//ColumnConstraints column2 = new ColumnConstraints(200, 300, 400);
		
	//	grid.getColumnConstraints().add(0, column1);
	//	grid.getColumnConstraints().add(1, column2);
		
		//First Name 
		Label firstNameLabel = new Label("First Name:");
		GridPane.setConstraints(firstNameLabel, 0, 0, 1, 1);
		TextField firstNameInput = new TextField("");
		firstNameInput.setPromptText("First Name");
		GridPane.setConstraints(firstNameInput, 1, 0, 1, 1);
		
		//Last Name
		Label lastNameLabel = new Label("Last Name: ");
		GridPane.setConstraints(lastNameLabel, 0, 1, 1, 1);
		TextField lastNameInput = new TextField("");
		lastNameInput.setPromptText("Last name");
		GridPane.setConstraints(lastNameInput, 1, 1, 1, 1);
		
		//Address
		Label addressLabel = new Label("Address: ");
		GridPane.setConstraints(lastNameLabel, 1, 1, 2, 2);
//		TextField addressInput  = new TextField("");
	//	addressInput.setPromptText("Address");
	//	GridPane.setConstraints(lastNameInput, 1, 2, 1, 1);
		
		//State
	//	Label stateLabel = new Label("State: ");
	//	GridPane.setConstraints(lastNameLabel, 0, 3);
	//	TextField stateInput  = new TextField("");
	//	stateInput.setPromptText("State");
	//	GridPane.setConstraints(lastNameInput, 1, 3);
		
		//Zip
	//	Label zipLabel = new Label("ZIP: ");
	//	GridPane.setConstraints(lastNameLabel, 0, 4);
	//	TextField zipInput  = new TextField("");
	//	zipInput.setPromptText("ZIP Code");
	//	GridPane.setConstraints(lastNameInput, 1, 4);
		

		
		//Register button
	//	Button loginButton = new Button("Register");
	//	GridPane.setConstraints(loginButton, 1, 5);
		
		grid.getChildren().addAll(
				firstNameLabel, firstNameInput, lastNameLabel, lastNameInput, addressLabel
				);
		
		Scene scene = new Scene(grid, 300, 600);
		window.setScene(scene);
		
	
		
	}
	
	
	//will check wheather ssn is consist of integers only
	private boolean isInt(TextField input, String Message) {
		
		try {
			
			int ssn = Integer.parseInt(input.getText());
			System.out.println("User is : " + ssn);
			return true;
			
			
		} catch (NumberFormatException e) {
			
			System.out.println("Error + message + is not a number");
			return false;
			
		}
		
	}

}
