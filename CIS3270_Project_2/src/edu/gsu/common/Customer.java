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

	public static void bookFlight(ActionEvent event, String userName, String airlineName, String flightNumber, String originCity, String destinationCity,
													String departureDate, String departureTime, String arrivalDate, String arrivalTime, String seatsAvailable) {
		
		Connection bookFlightDataConn = null;
		PreparedStatement bookFlightDataPs = null;
		ResultSet bookFlightDataRs = null;
		
		try {
			bookFlightDataConn = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			
			bookFlightDataPs = bookFlightDataConn.prepareStatement("INSERT INTO  Reservation "
					+ "(userName, airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, "
					+ "arrivalDate, arrivalTime, seatsAvailable)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				
			bookFlightDataPs.setString(1, userName);
			bookFlightDataPs.setString(2, airlineName);
			bookFlightDataPs.setString(3, flightNumber);
			bookFlightDataPs.setString(4, originCity);
			bookFlightDataPs.setString(5, destinationCity);
			bookFlightDataPs.setString(6, departureDate);
			bookFlightDataPs.setString(7, departureTime);
			bookFlightDataPs.setString(8, arrivalDate);
			bookFlightDataPs.setString(9, arrivalTime);
			bookFlightDataPs.setString(10, seatsAvailable);
			bookFlightDataPs.executeUpdate();
			
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setContentText("Flight Booked Successfully! ");
			alert.show();
			
			} catch (SQLException e) {
					
				e.printStackTrace();
					
			} finally {
				
				if (bookFlightDataRs != null) {
					
					try {
						bookFlightDataRs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					
				}
				
				if (bookFlightDataPs != null) {
					try {
						
						bookFlightDataPs.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
				if (bookFlightDataPs != null) {
					
					try {
						bookFlightDataPs.close();
						
					} catch (SQLException e) {
				
						e.printStackTrace();
						
					}
					
				if (bookFlightDataConn != null) {
					
					try {
						
						bookFlightDataConn.close();
						
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
