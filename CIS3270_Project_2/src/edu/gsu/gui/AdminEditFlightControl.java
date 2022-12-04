package edu.gsu.gui;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import edu.gsu.common.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdminEditFlightControl {
	
    @FXML
    private Button button_add;

    @FXML
    private Button button_delete;

    @FXML
    private Button button_update;

    @FXML
    private TableColumn<Flight, String> col_airlineName;

    @FXML
    private TableColumn<Flight, String> col_destinationCity;

    @FXML
    private TableColumn<Flight, String> col_flightNumber;

    @FXML
    private TableColumn<Flight, String> col_originCity;

    @FXML
    private TableView<Flight> table_viewFlight;

    @FXML
    private TextField tf_airlineName;

    @FXML
    private TextField tf_destinationCity;

    @FXML
    private TextField tf_flightNumber;

    @FXML
    private TextField tf_originCity;

    @FXML
    void Add(ActionEvent event) {
    	
//    	String airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, arrivalDate, arrivalTime;
//    	int flightCapacity, seatsavilable, isFull;
//    	
//    	airlineName = tf_airlineName.getText();
//    	flightNumber = tf_flightNumber.getText();
//    	originCity = tf_originCity.getText();
//    	destinationCity = tf_destinationCity.getText();
    		
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
//    //getting tables
//    public void table() {
//    	
//    	connect();
//    	ObservableList<Flight> flights = FXCollections.observableArrayList();
//    	
//    	try {
//    		
//    		tablePS = tableConn.prepareStatement("");
//    		ResultSet tableRS = tablePS.executeQuery();
//    		{
//    		while (tableRS.next()) {
//    			
//    			Flight flight = new Flight();
//    			flight.setAirlineName(tableRS.getString("airlineName"));
//    			flight.setFlightNumber(tableRS.getString("flightNumber"));
//    			flight.setOriginCity(tableRS.getString("originCity"));
//    			flight.setDestinationCity(tableRS.getString("destinationCity"));
//    			flights.add(flight);
//
//    		}
//		}	
//    		table_viewFlight.setItems(flights);
//    		col_airlineName.setCellValueFactory(f -> f.getValue().airlineNameProperty());
//    		col_flightNumber.setCellValueFactory(f -> f.getValue().flightNumberProperty());
//    		col_originCity.setCellValueFactory(f -> f.getValue().originCityProperty());
//    		col_destinationCity.setCellValueFactory(f -> f.getValue().destinationCityProperty());
//    		
//    	} catch (SQLException e) {
//    		
//    		e.printStackTrace();
//    		
//    	}
    	

    
    public Connection getConnection() {
    	
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
    	
    public ObservableList<Flight> getFlightList(){
    	
    	ObservableList<Flight> flightList = FXCollections.observableArrayList();
    	
    	Connection connection = getConnection();
    	
    	String query = "SELECT * FROM FlightData";
    	Statement st;
    	ResultSet rs;
    	
    	try {
    		
    		st = connection.createStatement();
    		rs = st.executeQuery(query);
    		Flight flights;
    		
    		while(rs.next()) {
    			
    			flights = new Flight(rs.getString("airlineName"), rs.getString("flightNumber"), rs.getString("originCity"), rs.getString("destinationCity"));
    			
    			
    		}
    		
    		
    	} catch (Exception ex) {
    		
    		
    	}
    	
    	
    }


}
