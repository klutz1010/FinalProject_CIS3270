package edu.gsu.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import edu.gsu.common.Flight;
import edu.gsu.common.Reservation;
import edu.gsu.common.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SearchFlightControl implements Initializable{

    @FXML
    private Button button_reserve;

    @FXML
    private Button button_search;
    
    @FXML
    private Button button_goback;

    @FXML
    private TableColumn<Flight, String> col_airlineName;

    @FXML
    private TableColumn<Flight, String> col_arrivalDate;

    @FXML
    private TableColumn<Flight, String> col_arrivalTime;

    @FXML
    private TableColumn<Flight, String> col_departureDate;

    @FXML
    private TableColumn<Flight, String> col_departureTime;

    @FXML
    private TableColumn<Flight, String> col_destinationCity;

    @FXML
    private TableColumn<Flight, String> col_flightNumber;

    @FXML
    private TableColumn<Flight, Integer> col_id;

    @FXML
    private TableColumn<Flight, String> col_originCity;

    @FXML
    private TableColumn<Flight, Integer> col_seatsAvailable;

    @FXML
    private Label lb_userName;

    @FXML
    private TableView<Flight> table_flightTable;

    @FXML
    private TextField tf_date;

    @FXML
    private TextField tf_destinationCity;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_originCity;
    //passing  customer user name value
    Customer data = Customer.getStoredUserName();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		lb_userName.setText(" " + data.getUserName());
		
		showCustomerFlights();
	
		//search function that shows filtered table
		button_search.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "CustomerPage.fxml", "Welcome Back", null );
				
			}
			
		});
		
		// going back to customer page
		button_goback.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "CustomerPage.fxml", "Welcome Back", null );
				
			}
			
		});
		
		// booking a flight
		button_reserve.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "CustomerPage.fxml", "Welcome Back", null );
				
			}
			
		});

	}
	
	 public ObservableList<Flight> getCustomerFlightList(){
	    	
	    	ObservableList<Flight> flightList = FXCollections.observableArrayList();
	    	
	    	Connection connection = Action.getConnection();
	    	
	    	String query = "SELECT id, airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, "
	    			+ "arrivalDate, arrivalTime, flightCapacity, seatsAvailable, isFull FROM FlightData";
	    	Statement st;
	    	ResultSet rs;
	    	
	    	try {
	    		
	    		st = connection.createStatement();
	    		rs = st.executeQuery(query);
	    		Flight flights;
	    		
	    		while(rs.next()) {
	    			
	    			flights = new Flight(rs.getInt("id"), rs.getString("airlineName"), rs.getString("flightNumber"), rs.getString("originCity"),
	    					rs.getString("destinationCity"), rs.getString("departureDate"), rs.getString("departureTime"),
	    					rs.getString("arrivalDate"), rs.getString("arrivalTime"), rs.getInt("flightCapacity"), rs.getInt("seatsAvailable"), rs.getInt("isFull"));
	    			
	    			flightList.add(flights);
	    		}

	    	} catch (Exception ex) {
	    		ex.printStackTrace();
	    	}
	    	
	    	return flightList;
	    }
	    //a method that puts the data in each column by column's name, and Display flight data on JavaFX table
	    public void showCustomerFlights() {
	    	
	    	ObservableList<Flight> list = getCustomerFlightList();
	    	
	    	col_id.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("id"));
	    	col_airlineName.setCellValueFactory(new PropertyValueFactory<Flight, String>("airlineName"));
	    	col_flightNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
	    	col_originCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("originCity"));
	    	col_destinationCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
	    	col_departureDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDate"));
	    	col_departureTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureTime"));
	    	col_arrivalDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalDate"));
	    	col_arrivalTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalTime"));
	    	col_seatsAvailable.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("seatsAvailable"));
	    	
	    	table_flightTable.setItems(list);
	    	
	    }
	
	

}
