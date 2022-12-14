package edu.gsu.gui;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.common.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
// ACTION!!!!!
public class Action {
	
	Customer data = Customer.getStoredUserName();
	
	//DB Connection method
    public static Connection getConnection() {
    	
    	Connection connection = null;
    	
    	try {connection = DriverManager.getConnection
				      ("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
    	}  catch (Exception ex) {
    		System.out.println("Error: " + ex.getMessage());
    		return null;
    	}
		return connection;
    }
	
	public static void changeScene(ActionEvent event, String fxmlFile, String title, String userName) {
		
		Parent root = null;
		
		if (userName != null) {
			
			try {
				
				FXMLLoader loader = new FXMLLoader(Action.class.getResource(fxmlFile));
				root = loader.load();
				CustomerPageControl CustomerPageControl =loader.getController();
				//CustomerPageControl.setUserInformation(userName);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		} else {
			
			try {
				
				root = FXMLLoader.load(Action.class.getResource(fxmlFile));
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(title);
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
		
	}
	
	public static void signUp(ActionEvent event, String userName, String userPassword, String firstName,
												String lastName, String address, String state, String zip,
												String emailAddress, String ssn, String securityAnswer) {
		
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
			psCheckUsersExist.setString(1, userName);
			resultSet = psCheckUsersExist.executeQuery();
			
			if (resultSet.isBeforeFirst()) {
				
				System.out.print("Username already exits");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("You cannot use this username");
				alert.show();
				
			} else {
				//registering user (inserting data into database)
				psInsert = connection.prepareStatement("INSERT INTO CustomerData "
						+ "(userName, userPassword, firstName, lastName, address, state, zip, emailAddress, ssn, securityAnswer)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				psInsert.setString(1, userName);
				psInsert.setString(2, userPassword);
				psInsert.setString(3, firstName);
				psInsert.setString(4, lastName);
				psInsert.setString(5, address);
				psInsert.setString(6, state);
				psInsert.setString(7, zip);
				psInsert.setString(8, emailAddress);
				psInsert.setString(9, ssn);
				psInsert.setString(10, securityAnswer);
				psInsert.executeUpdate();
				
				changeScene(event, "CustomerPage.FXML", "Welcome ", userName + "!");
				
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
	
	public static void loginUser(ActionEvent event, String userName, String userPassword) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
					+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
					+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			preparedStatement = connection.prepareStatement("SELECT userPassword FROM CustomerData WHERE userName = ? ");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			
			if (!resultSet.isBeforeFirst()) {
				
				System.out.println("User not found in the databse.");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Your User Name CANNOT be found in our Database.");
				alert.show();
				
				
			} else {
				//comparing password
				while(resultSet.next()) {
					//getting password form the resultset
					String retrievedPassword = resultSet.getString("userPassword"); 
					// if password is correct, change the scene.
					if (retrievedPassword.equals(userPassword)) {
						
							changeScene(event, "CustomerPage.fxml", "Welcome", " " + userName);

					// if password is incorrect show alert.
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
