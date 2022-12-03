package edu.gsu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;

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
		
		


}
