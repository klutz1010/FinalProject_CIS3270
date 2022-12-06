package edu.gsu.gui;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import edu.gsu.common.Customer;
import edu.gsu.common.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CustomerEditFlightControl implements Initializable{

    @FXML
    private Button button_cancelFlight;

    @FXML
    private Button button_goback;

    @FXML
    private TableColumn<Reservation, String> col_airlineName;

    @FXML
    private TableColumn<Reservation, String> col_arrivalDate;

    @FXML
    private TableColumn<Reservation, String> col_arrivalTime;

    @FXML
    private TableColumn<Reservation, String> col_departureDate;

    @FXML
    private TableColumn<Reservation, String> col_departureTime;

    @FXML
    private TableColumn<Reservation, String> col_destinationCity;

    @FXML
    private TableColumn<Reservation, String> col_flightNumber;

    @FXML
    private TableColumn<Reservation, Integer> col_id;
    
    @FXML
    private TableColumn<Reservation, String> col_userName;

    @FXML
    private TableColumn<Reservation, String> col_originCity;

    @FXML
    private TableColumn<Reservation, Integer> col_seatsAvailable;

    @FXML
    private Label label_userName;

    @FXML
    private TableView<Reservation> table_viewFlight;

    @FXML
    private TextField tf_id;
    
	Customer data = Customer.getStoredUserName();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		label_userName.setText("Welcome " +data.getUserName());

		showReservations();
		
		button_cancelFlight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Customer.cancelFlight(event, Integer.parseInt(tf_id.getText()));
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("The Flight Data has been deleted.");
				alert.show();
				
				showReservations();	
			}	
		
		});
		
		button_goback.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "CustomerPage.fxml", "Welcome Back", null);
			
			}	
		
		});
		
	}
	
	public void setUserInformation(String userName) {
		
		label_userName.setText(("Welcome" + this.label_userName + " !"));
			
	}
	
	public ObservableList<Reservation> getReservationList(){
		
    	ObservableList<Reservation> reservationList = FXCollections.observableArrayList();
    	
    	Connection connection = Action.getConnection();
    	
    	String query = "SELECT id, userName, airlineName, flightNumber, originCity,"
    			+ "destinationCity, departureDate, departureTime, "
    			+ "arrivalDate, arrivalTime, seatsAvailable FROM Reservation "
    			+ "WHERE userName = '" + data.getUserName() + "'";
    	Statement st;
    	ResultSet rs;
    	
    	try {
    		
    		st = connection.createStatement();
    		rs = st.executeQuery(query);
    		Reservation reservations;
    		
    		while(rs.next()) {
    			
    			reservations = new Reservation(rs.getInt("ID"), rs.getString("userName"), rs.getString("airlineName"),
    					rs.getString("flightNumber"), rs.getString("originCity"), rs.getString("destinationCity"),
    					rs.getString("departureDate"), rs.getString("departureTime"), rs.getString("arrivalDate"),
    					rs.getString("arrivalTime"), rs.getInt("seatsAvailable"));
    			
    			reservationList.add(reservations);
    		}

    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return reservationList;
		
	}
	
	public void showReservations() {
		
		ObservableList<Reservation> list = getReservationList();
    	
    	col_id.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("id"));
    	col_userName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("userName"));
    	col_airlineName.setCellValueFactory(new PropertyValueFactory<Reservation, String>("airlineName"));
    	col_flightNumber.setCellValueFactory(new PropertyValueFactory<Reservation, String>("flightNumber"));
    	col_originCity.setCellValueFactory(new PropertyValueFactory<Reservation, String>("originCity"));
    	col_destinationCity.setCellValueFactory(new PropertyValueFactory<Reservation, String>("destinationCity"));
    	col_departureDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("departureDate"));
    	col_departureTime.setCellValueFactory(new PropertyValueFactory<Reservation, String>("departureTime"));
    	col_arrivalDate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("arrivalDate"));
    	col_arrivalTime.setCellValueFactory(new PropertyValueFactory<Reservation, String>("arrivalTime"));
    	col_seatsAvailable.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("seatsAvailable"));
    	
    	table_viewFlight.setItems(list);
			
	}

}