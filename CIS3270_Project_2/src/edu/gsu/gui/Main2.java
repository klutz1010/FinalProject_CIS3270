package edu.gsu.gui;
	
import application.ConfirmBox;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;


public class Main2 extends Application {
	
	Stage window;
	Scene scene1, scene2;
	Button loginButton, registerButton, forgotPasswordButton;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		window = primaryStage;
		
		//Creating Options for the main page
		//Login
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(5, 5, 5, 5));
		grid.setVgap(20);
		grid.setHgap(20);

		//name label
		Label nameLabel = new Label("UserName:");
		GridPane.setConstraints(nameLabel, 0, 0);
		//Name Input
		TextField nameInput = new TextField("");
		nameInput.setPromptText("UserName");
		GridPane.setConstraints(nameInput, 1, 0);
		
		//password label
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel, 0, 1);
		//password Input, Prompt Text
		TextField passInput = new TextField("");
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		//Login Button
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e-> CustomerPage.display("",""));
		GridPane.setConstraints(loginButton, 0, 2);
		GridPane.setHalignment(loginButton, HPos.LEFT);
		
		
		
		
		
		
		
		//Register Button
		Button registerButton = new Button("Register");
		registerButton.setOnAction(e-> Register.display("", ""));
		GridPane.setConstraints(registerButton, 0, 3);
		GridPane.setHalignment(registerButton, HPos.LEFT);
		
		//Forgotpassword Button
		Button forgotPasswordButton = new Button("Forgot Password?");
		forgotPasswordButton.setOnAction(e-> ForgotPassword.display("", ""));
		GridPane.setConstraints(forgotPasswordButton, 0, 4);
		GridPane.setHalignment(forgotPasswordButton, HPos.LEFT);
		
		
		//Layout1 - children are laid out in vertical column;
		//VBox layout1 = new VBox(20);
		//layout1.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, registerButton, forgotPasswordButton);
		//Scene scene1 = new Scene(layout1, 500, 300);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, registerButton, forgotPasswordButton);
		Scene scene = new Scene(grid, 600, 400);
		//grid.setAlignment(Pos.CENTER);
		
		//set title
		window.setTitle("Flight Reservation System");
		window.setScene(scene);
		window.show();
		window.setOnCloseRequest(e-> closeProgram());
	
	}
	
	
	//Close Request Method
	public void closeProgram() {
			
			boolean answer = ConfirmBox.display("", "Are you sure you want to exit?");
			
			if (answer)
				window.close();
			
	}
	
}
