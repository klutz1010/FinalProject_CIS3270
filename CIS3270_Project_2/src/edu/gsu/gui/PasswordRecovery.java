package edu.gsu.gui;

import java.sql.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class PasswordRecovery  {
	
//	public static String user = "";
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		launch(args);
//
//	}
//	
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//
//		primaryStage.setTitle("Recover Password");
//		primaryStage.setResizable(false);
//		GridPane grid = new GridPane();
//		grid.setPadding(new Insets(10, 10, 10, 10));
//		grid.setVgap(10);
//		grid.setHgap(10);
//
//		Label passwordRecoverLabel = new Label("Recover Your Password");
//		GridPane.setConstraints(passwordRecoverLabel, 1, 0);
//		grid.setAlignment(Pos.TOP_CENTER);
//		GridPane.setHalignment(passwordRecoverLabel, HPos.CENTER);
//
//		Label usernameLabel = new Label("Enter Your Username Below");
//		GridPane.setConstraints(usernameLabel, 1, 1);
//		grid.setAlignment(Pos.TOP_CENTER);
//		GridPane.setHalignment(usernameLabel, HPos.CENTER);
//
//		TextField username = new TextField();
//		GridPane.setConstraints(username, 1, 2);
//		grid.setAlignment(Pos.CENTER);
//
//		Button recover = new Button("Recover Password");
//		GridPane.setConstraints(recover, 1, 4);
//		recover.setOnAction(e -> {
//
//			try {
//				// get a connection to the database
//				Connection myConn = DriverManager.getConnection(
//						"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
//						"Tdgiheay12");
//				// create a statement
//				Statement myStat = myConn.createStatement();
//				// execute a query
//				ResultSet myRs;
//				user = username.getText().trim();
//				String sqlUserCheck = "SELECT `username` FROM `flights`.`users` where username = '" + user + "'";
//				myRs = myStat.executeQuery(sqlUserCheck);
//
//				// Creates a variable for future checking
//				int count = 0;
//
//				while (myRs.next()) {
//
//					count = count + 1;
//
//				}
//				myRs.close();
//				myStat.close();
//				myConn.close();
//
//				// If user is in the database and the password is correct it it will take user
//				// to main page
//				if (count == 1) {
//
//					ForgotPassword recoveryPage = new ForgotPassword();
//					
//					try {
//
//						recoveryPage.start(primaryStage);
//						
//					} catch (Exception e1) {
//
//					}
//				}
//
//				else {
//					AlertBox.display("Incorrect Username", "There is no user with the username: " + user);
//
//				}
//
//			}
//
//			catch (Exception e1) {
//
//			}
//
//		});
//
//		Button login = new Button("Return To Log In");
//		GridPane.setConstraints(login, 1, 5);
//		login.setOnAction(e -> {
//			Login loginPage = new Login();
//			try {
//
//				loginPage.start(primaryStage);
//			}
//
//			catch (Exception e1) {
//			}
//		});
//
//		login.setMinWidth(150);
//		recover.setMinWidth(150);
//
//		Scene scene = new Scene(grid, 320, 350);
//
//		grid.getChildren().addAll(passwordRecoverLabel, usernameLabel, username, recover, login);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//		primaryStage.centerOnScreen();
//	}

}
