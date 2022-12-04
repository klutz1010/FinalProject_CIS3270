package edu.gsu.gui;

import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
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
    private TableColumn<?, ?> col_airlineName;

    @FXML
    private TableColumn<?, ?> col_destinationCity;

    @FXML
    private TableColumn<?, ?> col_flightNumber;

    @FXML
    private TableColumn<?, ?> col_originCity;

    @FXML
    private TableView<?> table_viewFlight;

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
    	
    	String airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, arrivalDate, arrivalTime;
    	int flightCapacity, seatsavilable, isFull;
    	
    	airlineName = tf_airlineName.getText();
    	flightNumber = tf_flightNumber.getText();
    	originCity = tf_originCity.getText();
    	destinationCity = tf_destinationCity.getText();
    	
    	
    	
    	
    	
    	
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
    
    Connection tableConn;
    PreparedStatement tableST;
    
    
 

}
