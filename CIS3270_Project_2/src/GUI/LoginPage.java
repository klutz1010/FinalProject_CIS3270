package GUI;

import java.sql.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.application.Application;
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

public class LoginPage extends Application{
		
	public static void display(String Title, String Message) {
		
		private static String user = "";
		private static String password = "";
		public static Scene scene;

		public static void main(String[] args) {

			Application.launch(args);

		}

		public void start(Stage primaryStage) throws Exception {

			primaryStage.setTitle("Log In");
			primaryStage.setResizable(false);
			AnchorPane anchor = new AnchorPane();
			anchor.setPadding(new Insets(10, 10, 10, 10));

			Label loginLabel = new Label("Enter your username and password");
			loginLabel.setAlignment(javafx.geometry.Pos.CENTER);
			loginLabel.setLayoutX(144.0);
			loginLabel.setLayoutY(51.0);
			loginLabel.setPrefHeight(32.0);
			loginLabel.setPrefWidth(351.0);
			loginLabel.setText("Enter Your Username And Password");
			loginLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
			loginLabel.setFont(new Font(22.0));

			Label usernameLabel = new Label("Username:");
			usernameLabel.setLayoutX(189.0);
			usernameLabel.setLayoutY(131.0);
			usernameLabel.setText("Username:");
			usernameLabel.setFont(new Font(20.0));

			TextField userTxt = new TextField();
			userTxt.setLayoutX(311.0);
			userTxt.setLayoutY(133.0);
			userTxt.setPromptText("Username");

			Label passwordLabel = new Label("Password:");
			passwordLabel.setLayoutX(193.0);
			passwordLabel.setLayoutY(174.0);
			passwordLabel.setFont(new Font(20.0));

			PasswordField passwordTxt = new PasswordField();
			passwordTxt.setLayoutX(311.0);
			passwordTxt.setLayoutY(177.0);
			passwordTxt.setPromptText("Password");
			passwordTxt.setOnAction(e -> {// Exception handling for connecting to the database
				try {
					// get a connection to the database
					// Connection myConn = DriverManager.getConnection();
					// create a statement
					//Statement myStat = myConn.createStatement();
					// execute a query
					//ResultSet myRs;

					// collects user name from the user name text field and assigns to a string
					// called user
					// setUser(userTxt.getText().trim());

					// Collects password from the password text field and assigns to a string called
					// password
					// setPassword(passwordTxt.getText().trim());

					// SQL query to check if user name and password is in database
					//String sqlUserCheck = "SELECT `username`, `id` FROM `flights`.`users` where username = '" + getUser()
					//		+ "' and password = '" + getPassword() + "'";
					//myRs = myStat.executeQuery(sqlUserCheck);

					// Creates a variable for future checking
					int count = 0;

					// While loop that will determine if user is in the database
					//while (myRs.next()) {
					count = count + 1;

					//}
					//myStat.close();
					//myRs.close();
					//myConn.close();
					// If user is in the database and the password is correct it it will take user
					// to main page
					if (count == 1) {
						Main MainPage = new Main();
						MainPage.start(primaryStage);

					}

					/**
					 * If user is not in database or password is incorrect, an error message is
					 * displayed prompting change in user name or password, attempt password
					 * recovery, or prompts the user to register if they do not have an account
					 **/
					else if (count < 1) {
						AlertBox.display("Incorrect Log In",
								"Username and password combination is either incorrect or the account does not exist.\n Please select The forgot password if your password is unknonwn, or the register option to create an account.");
					}

				}

				catch (Exception ex) {

				}

			});

			// login button and event handler
			Button login = new Button("Log In");
			login.setLayoutX(237.0);
			login.setLayoutY(222.0);
			login.setMnemonicParsing(false);
			login.setPrefHeight(25.0);
			login.setPrefWidth(149.0);
			login.setText("Log In");

			login.setOnAction(e -> {

				// Exception handling for connecting to the database
				try {
					// get a connection to the database
					Connection myConn = DriverManager.getConnection(
							"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
							"Tdgiheay12");
					// create a statement
					Statement myStat = myConn.createStatement();
					// execute a query
					ResultSet myRs;

					// collects user name from the user name text field and assigns to a string
					// called user
					//setUser(userTxt.getText().trim());

					// Collects password from the password text field and assigns to a string called
					// password
					//setPassword(passwordTxt.getText().trim());

					// SQL query to check if user name and password is in database
					String sqlUserCheck = "SELECT `username` FROM `flights`.`users` where username = '" + getUser()
							+ "' and password = '" + "'";
					myRs = myStat.executeQuery(sqlUserCheck);

					// Creates a variable for future checking
					int count = 0;

					// While loop that will determine if user is in the database
					while (myRs.next()) {

						count = count + 1;

					}

					myRs.close();
					myStat.close();
					myConn.close();

					// If user is in the database and the password is correct it it will take user
					// to main page
					if (count == 1) {
						Main MainPage = new Main();
						MainPage.start(primaryStage);
						

					}

					/**
					 * If user is not in database or password is incorrect, an error message is
					 * displayed prompting change in user name or password, attempt password
					 * recovery, or prompts the user to register if they do not have an account
					 **/
					else if (count < 1) {
						AlertBox.display("Incorrect Log In",
								"Username and password combination is either incorrect or the account does not exist.\n Please select The 'Forgot Password' option if your password is unknonwn, \n or the register option to create an account.");
					}

				}

				catch (Exception ex) {

				}
				;
			});

			Button register = new Button("Register");
			register.setLayoutX(237.0);
			register.setLayoutY(255.0);
			register.setMnemonicParsing(false);
			register.setPrefHeight(25.0);
			register.setPrefWidth(149.0);
			register.setOnAction(e -> {
				Register registerPage = new Register();
				try {
					registerPage.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});

			Button passwordRecover = new Button("Forgot Password");
			passwordRecover.setLayoutX(236.0);
			passwordRecover.setLayoutY(290.0);
			passwordRecover.setMnemonicParsing(false);
			passwordRecover.setPrefHeight(26.0);
			passwordRecover.setPrefWidth(150.0);
			passwordRecover.setOnAction(e -> {
				
				PasswordRecovery recoverPage = new PasswordRecovery();
				
				try {

					recoverPage.start(primaryStage);
					
				}

				catch (Exception e1) {
				}
			});

			Button exit = new Button("Exit");
			exit.setLayoutX(236.0);
			exit.setLayoutY(328.0);
			exit.setMnemonicParsing(false);
			exit.setPrefHeight(25.0);
			exit.setPrefWidth(150.0);
			exit.setOnAction(e -> {
				AlertBox.display("Exit", "System Will Now exit.");
				System.exit(0);
			});

			exit.setMinWidth(150);
			register.setMinWidth(150);
			passwordRecover.setMinWidth(150);
			login.setMinWidth(150);

			anchor.getChildren().addAll(userTxt, passwordTxt, login, register, passwordRecover, usernameLabel, exit,
					loginLabel, passwordLabel);
			BackgroundImage myBI = new BackgroundImage(new Image(" "
					),
					BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
					BackgroundSize.DEFAULT);
			anchor.setBackground(new Background(myBI));
			scene = new Scene(anchor, 550, 370);
			;
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.centerOnScreen();


		
		}


}
