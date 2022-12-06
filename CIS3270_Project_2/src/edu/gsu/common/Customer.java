package edu.gsu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class Customer {
	//holding customer's user name
	private static final Customer storedUserName = new Customer();
	
	//intentional blank
	private Customer() {}
	
	//return customer's user name to other class
	public static Customer getStoredUserName() {
		
		return storedUserName;
		
	}
	
	private int id;
	private String userName;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String address;
	private String state;
	private String zip;
	private String emailAddress;
	private String ssn;
	private String securityAnswer;
	
	public Customer(int id, String userName, String userPassword, String firstName, String lastName, String address,
			String state, String zip, String emailAddress, String ssn, String securityAnswer) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
		this.zip = zip;
		this.emailAddress = emailAddress;
		this.ssn = ssn;
		this.securityAnswer = securityAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	
	public static void addFlight(ActionEvent event, String userName, int id) {
		
		Connection addFlightDataConn = null;
		PreparedStatement addFlightDataPs = null;
		ResultSet addFlightDataRs = null;
		
		try {
			addFlightDataConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			
			addFlightDataPs = addFlightDataConn.prepareStatement("INSERT INTO  Reservation "
					+ "(airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, "
					+ "arrivalDate, arrivalTime, seatsAvailable) WHERE userName Value = '" +getStoredUserName() + "' AND "
					+ "SELECT airlineName,flightNumber,originCity,destinationCity, "
					+ "departureDate, departureTime, arrivalDate, arrivalTime, seatsAvailable "
					+ "FROM FlightData WHERE id = ?");
				
//			addFlightDataPs.setString(1, getStoredUserName() + "");
			addFlightDataPs.setInt(1, id);
//			addFlightDataPs.setString(2, airlineName);
//			addFlightDataPs.setString(3, flightNumber);
//			addFlightDataPs.setString(4, originCity);
//			addFlightDataPs.setString(5, destinationCity);
//			addFlightDataPs.setString(6, departureDate);
//			addFlightDataPs.setString(7, departureTime);
//			addFlightDataPs.setString(8, arrivalDate);
//			addFlightDataPs.setString(9, arrivalTime);
//			addFlightDataPs.setInt(10, seatsAvailable);
//			addFlightDataPs.setInt(11, id);
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

	//making a method for canceling a flight
	public static void cancelFlight(ActionEvent event, int id) {
		
		Connection cancelFlightDataConn = null;
		PreparedStatement cancelFlightDataPs = null;
		ResultSet cancelFlightDataRs = null;
		
		try {
			cancelFlightDataConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			

			cancelFlightDataPs = cancelFlightDataConn.prepareStatement("DELETE FROM Reservation WHERE id = ?");
				
			cancelFlightDataPs.setInt(1, id);
			cancelFlightDataPs.executeUpdate();
				

			} catch (SQLException e) {
					
				e.printStackTrace();
					
			} finally {
				
				if (cancelFlightDataRs != null) {
					
					try {
						cancelFlightDataRs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
				}
				
				if (cancelFlightDataPs != null) {
					try {
						
						cancelFlightDataPs.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
				if (cancelFlightDataPs != null) {
					
					try {
						cancelFlightDataPs.close();
						
					} catch (SQLException e) {
				
						e.printStackTrace();
						
					}
					
				if (cancelFlightDataConn != null) {
					
					try {
						
						cancelFlightDataConn.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
		}
		
	}
}
