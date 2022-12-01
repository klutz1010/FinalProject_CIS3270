package edu.gsu.gui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class DBUtils {
	
	public static void changeScene(ActionEvent event, String fxmlFile, String title, String userName) {
		
		Parent root = null;
		
		if (userName != null) {
			
			try {
				
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				CustomerPageControl LoginControl =loader.getController();
				LoginControl.setUserInformation(userName);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		} else {
			
			try {
				
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(title);
		stage.setScene(new Scene(root, 600, 400));
		stage.show();
		
	}
	
	public static void signUp(ActionEvent event, String username, String password) {
		
		Connection connection = null;
		PreparedStatement psInsert = null;
		PreparedStatement psCheckUsersExist = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			//to check if the user name is in the database or not.
			psCheckUsersExist = connection.prepareStatement("SELECT * FROM CustomerData WHERE userName = ?");
			psCheckUsersExist.setString(1, username);
			resultSet = psCheckUsersExist.executeQuery();
			
			if (resultSet.isBeforeFirst()) {
				
				System.out.print("Username already exits");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("You cannot use this username");
				alert.show();
				
			} else {
				//if there's a username, registering user (inserting data into database)
				psInsert = connection.prepareStatement("INSERT INTO CustomerData (userName, userPassword, VALUES (?, ?)");
				psInsert.setString(1, username);
				psInsert.setString(2, password);
				psInsert.executeUpdate();
				
				
				changeScene(event, "CustomerPage", "Welcome", username);
				
			}
			
			
		} catch (SQLException e) {
				
			e.printStackTrace();
				
		} finally {
			
			if (resultSet != null) {
				
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
			if (psCheckUsersExist != null) {
				try {
					
					psCheckUsersExist.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			if (psInsert != null) {
				
				try {
					psInsert.close();
					
				} catch (SQLException e) {
			
					e.printStackTrace();
					
				}
				
			if (connection != null) {
				
				try {
					
					connection.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
				
			}
		}
		
	}
	
	public static void loginUser(ActionEvent event, String username, String password) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
					+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
					+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			preparedStatement = connection.prepareStatement("SELECT userPassword FROM CustomerData WHERE userName = ?");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			
			if (!resultSet.isBeforeFirst()) {
				
				System.out.println("User not found in the databse.");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Provided credntials are incorrect.");
				alert.show();
				
			} else {
				//comparing password
				while(resultSet.next()) {
					String retrievedPassword = resultSet.getString("userPassword"); 
					// if password is correct
					if (retrievedPassword.equals(password)) {
						
						changeScene(event, "CustomerPage.fxml", "Welcome!", username);
					// if password is incorrect
					} else {
						
						System.out.println("The password did not match!");
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("the provided credentials are incorrect");
						alert.show();
						
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//closing result set
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//closing prepared statement	
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			//closing connection
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
}
