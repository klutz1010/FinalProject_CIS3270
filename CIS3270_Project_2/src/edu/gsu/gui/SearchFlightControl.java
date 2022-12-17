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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
    private Button button_bookFlight;
    
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
		//(s.h) search button needs to go to pop up message that confirms flight
		button_bookFlight.setOnAction(new EventHandler<ActionEvent>(){
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
				
				Customer.addFlight(event, data.getUserName(), Integer.parseInt(tf_id.getText()));
				
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
	    	
	    
	    //displays all or current record if no matches
	    FilteredList < Flight > filteredData = new FilteredList<>( list, b -> true);
	    
	   /* tf_originCity.textProperty().addListener((observable, oldValue, newValue) -> {
	    	filteredData.setPredicate(Flight -> {
	    		
	    		if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
	    			return true;
	    		}
	    		
	    		String searchKeyword = newValue.toLowerCase();
	    		
	    		if(Flight.getDepartureDate().toLowerCase().indexOf(searchKeyword) > -1) {
	    			return true;
	    		}
	    		else if(Flight.getOriginCity().toLowerCase().indexOf(searchKeyword) > -1) {
	    			return true;
	    		}
	    		else if(Flight.getDestinationCity().toLowerCase().indexOf(searchKeyword) > -1) {
	    			return true;
	    		}
	    		else
	    			return false;
	    		
	    	});
	 
	    });*/
	    tf_originCity.textProperty().addListener((observable, oldValue, newValue) -> {
	    	filteredData.setPredicate(Flight -> {
	    		
	    		if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
	    			return true;
	    		}
	    		
	    		String searchKeyword = newValue.toLowerCase();
	    		
	    		if(Flight.getOriginCity().toLowerCase().indexOf(searchKeyword) > -1) {
	    			return true;
	    		}
	    		else
	    			return false;
	    	 });
	    });
	    tf_date.textProperty().addListener((observable2, oldValue2, newValue2) -> {
	    	filteredData.setPredicate(Flight -> {
	    		
	    		if (newValue2.isEmpty() || newValue2.isBlank() || newValue2 == null) {
	    			return true;
	    		}
	    		
	    		String searchKeyword = newValue2.toLowerCase();
	    		
	    		if(Flight.getDepartureDate().toLowerCase().indexOf(searchKeyword) > -1) {
	    			return true;
	    		}
	    		else
	    			return false;
	    	});
	    });
	    tf_destinationCity.textProperty().addListener((observable3, oldValue3, newValue3) -> {
	    	filteredData.setPredicate(Flight -> {
	    		
	    		if (newValue3.isEmpty() || newValue3.isBlank() || newValue3 == null) {
	    			return true;
	    		}
	    		
	    		String searchKeyword = newValue3.toLowerCase();
	    		
	    		if(Flight.getDestinationCity().toLowerCase().indexOf(searchKeyword) > -1) {
	    			return true;
	    		}
	    		else
	    			return false;
	   
	   
	
	    });
	    });
	    
	    SortedList <Flight > sortedData = new SortedList <> (filteredData);
	    
	    //Connect sorted data with table view
	    sortedData.comparatorProperty().bind(table_flightTable.comparatorProperty());
	    table_flightTable.setItems(sortedData);
	
	    }
}
