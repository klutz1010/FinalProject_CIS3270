package edu.gsu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.gsu.gui.Action;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class Admin {
	
	private String adminID;
	private String adminPassowrd;
	
	public String getAdminID() {
		return adminID;
	}
	public void setAdminID(String adminID) {
		this.adminID = adminID;
	}
	public String getAdminPassowrd() {
		return adminPassowrd;
	}
	public void setAdminPassowrd(String adminPassowrd) {
		this.adminPassowrd = adminPassowrd;
	}
	
	//Admin Login, can be logged into Adminpage instead of Customer Page
	//Admin Info, ID: Admin PW: Admin1234
	public static void adminLogin(ActionEvent event, String userName, String userPassword) {
		
		Connection adminConn = null;
		PreparedStatement adminPS = null;
		ResultSet adminRS = null;
		
		try {
			adminConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
					+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
					+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			adminPS = adminConn.prepareStatement("SELECT userPassword FROM CustomerData WHERE userName = ? ");
			adminPS.setString(1, userName);
			adminRS = adminPS.executeQuery();
			
			if (!adminRS.isBeforeFirst()) {
				
				System.out.println("Please Input Correct Credential");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Please Input Correct Credential");
				alert.show();
				
			} else {
				//comparing password
				while(adminRS.next()) {
					//getting password form the resultset
					String retrievedPassword = adminRS.getString("userPassword"); 
					// if password is correct, change the scene.
					if (retrievedPassword.equals(userPassword)) {
						
							Action.changeScene(event, "AdminPage.fxml", "Welcome", null);

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
			if (adminRS != null) {
				try {
					adminRS.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//closing prepared statement	
			if (adminPS != null) {
				try {
					adminPS.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			//closing connection
			if (adminConn != null) {
				try {
					adminConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
		
	//giving Admin a power, adding a new Flight Data
	public static void addFlightData(ActionEvent event, String airlineName, String flightNumber, String originCity, String destinationCity,
										String departureDate, String departureTime, String arrivalDate, String arrivalTime,
										int flightCapacity, int seatsAvailable, int isFull) {
		
		Connection addFlightDataConn = null;
		PreparedStatement addFlightDataPs = null;
		ResultSet addFlightDataRs = null;
		
		try {
			addFlightDataConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			

				addFlightDataPs = addFlightDataConn.prepareStatement("INSERT INTO FlightData "
						+ "(airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, arrivalDate, arrivalTime, "
						+ "flightCapacity, seatsAvailable, isFull)"
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
				addFlightDataPs.setString(1, airlineName);
				addFlightDataPs.setString(2, flightNumber);
				addFlightDataPs.setString(3, originCity);
				addFlightDataPs.setString(4, destinationCity);
				addFlightDataPs.setString(5, departureDate);
				addFlightDataPs.setString(6, departureTime);
				addFlightDataPs.setString(7, arrivalDate);
				addFlightDataPs.setString(8, arrivalTime);
				addFlightDataPs.setInt(9, flightCapacity);
				addFlightDataPs.setInt(10, seatsAvailable);
				addFlightDataPs.setInt(11, isFull);
				addFlightDataPs.executeUpdate();
				

			} catch (SQLException e) {
					
				e.printStackTrace();
					
			} finally {
				
				if (addFlightDataRs != null) {
					
					try {
						addFlightDataRs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
				}
				
				if (addFlightDataPs != null) {
					try {
						
						addFlightDataPs.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
				if (addFlightDataPs != null) {
					
					try {
						addFlightDataPs.close();
						
					} catch (SQLException e) {
				
						e.printStackTrace();
						
					}
					
				if (addFlightDataConn != null) {
					
					try {
						
						addFlightDataConn.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
		}
		
	}
	//Give admin a feature, updating flight data inside the admin page.
	public static void updateFlightData(ActionEvent event, int id, String airlineName, String flightNumber, String originCity, String destinationCity,
				String departureDate, String departureTime, String arrivalDate, String arrivalTime,
				int flightCapacity, int seatsAvailable, int isFull) {
	
		Connection updateFlightDataConn = null;
		PreparedStatement updateFlightDataPs = null;
		ResultSet updateFlightDataRs = null;
		
		try {
			updateFlightDataConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			updateFlightDataPs = updateFlightDataConn.prepareStatement("UPDATE FlightData "
			+ "SET airlineName=?, flightNumber=?, originCity=?, destinationCity=?, departureDate=?, departureTime=?, arrivalDate=?, arrivalTime=?, "
			+ "flightCapacity=?, seatsAvailable=?, isFull=? "
			+ "WHERE id = ?");
			
			updateFlightDataPs.setString(1, airlineName);
			updateFlightDataPs.setString(2, flightNumber);
			updateFlightDataPs.setString(3, originCity);
			updateFlightDataPs.setString(4, destinationCity);
			updateFlightDataPs.setString(5, departureDate);
			updateFlightDataPs.setString(6, departureTime);
			updateFlightDataPs.setString(7, arrivalDate);
			updateFlightDataPs.setString(8, arrivalTime);
			updateFlightDataPs.setInt(9, flightCapacity);
			updateFlightDataPs.setInt(10, seatsAvailable);
			updateFlightDataPs.setInt(11, isFull);
			updateFlightDataPs.setInt(12, id);
			
			updateFlightDataPs.executeUpdate();
				

			} catch (SQLException e) {
					
				e.printStackTrace();
					
			} finally {
				
				if (updateFlightDataRs != null) {
					
					try {
						updateFlightDataRs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
				}
				
				if (updateFlightDataPs != null) {
					try {
						
						updateFlightDataPs.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
				if (updateFlightDataPs != null) {
					
					try {
						updateFlightDataPs.close();
						
					} catch (SQLException e) {
				
						e.printStackTrace();
						
					}
					
				if (updateFlightDataConn != null) {
					
					try {
						
						updateFlightDataConn.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
		}
		
	}
	//Give admin a feature, deleting flight data inside the admin page.
	public static void deleteFlightData(ActionEvent event, int id) {

	Connection deleteFlightDataConn = null;
	PreparedStatement deleteFlightDataPs = null;
	ResultSet updateFlightDataRs = null;
	
	try {
		deleteFlightDataConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
							+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
							+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		

		deleteFlightDataPs = deleteFlightDataConn.prepareStatement("DELETE FROM FlightData WHERE id = ?");
			
		deleteFlightDataPs.setInt(1, id);
		deleteFlightDataPs.executeUpdate();
			

		} catch (SQLException e) {
				
			e.printStackTrace();
				
		} finally {
			
			if (updateFlightDataRs != null) {
				
				try {
					updateFlightDataRs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			}
			
			if (deleteFlightDataPs != null) {
				try {
					
					deleteFlightDataPs.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
			if (deleteFlightDataPs != null) {
				
				try {
					deleteFlightDataPs.close();
					
				} catch (SQLException e) {
			
					e.printStackTrace();
					
				}
				
			if (deleteFlightDataConn != null) {
				
				try {
					
					deleteFlightDataConn.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
			
		}
	}
	
}
}
