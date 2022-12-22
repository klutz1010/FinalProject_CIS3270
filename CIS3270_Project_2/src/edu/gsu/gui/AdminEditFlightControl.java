package edu.gsu.gui;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import edu.gsu.common.Admin;
import edu.gsu.common.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminEditFlightControl implements Initializable {
	
	@FXML
	private Button button_goback;
	
    @FXML
    private Button button_addFlight;

    @FXML
    private Button button_deleteFlight;

    @FXML
    private Button button_updateFlight;

    @FXML
    private TableColumn<Flight, Integer> col_id;
    
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
    private TableColumn<Flight, Integer> col_flightCapacity;

    @FXML
    private TableColumn<Flight, String> col_flightNumber;

    @FXML
    private TableColumn<Flight, Integer> col_isFull;

    @FXML
    private TableColumn<Flight, String> col_originCity;

    @FXML
    private TableColumn<Flight, Integer> col_seatsAvailable;
    @FXML
    private TableView<Flight> table_viewFlight;

    @FXML
    private TextField tf_id;
    
    @FXML
    private TextField tf_airlineName;

    @FXML
    private TextField tf_arrivalDate;

    @FXML
    private TextField tf_arrivalTime;

    @FXML
    private TextField tf_departureDate;
    
    @FXML
    private DatePicker datepick_departureDate;

    @FXML
    private TextField tf_departureTime;

    @FXML
    private TextField tf_destinationCity;

    @FXML
    private TextField tf_flightCapacity;

    @FXML
    private TextField tf_flightNumber;

    @FXML
    private TextField tf_isFull;

    @FXML
    private TextField tf_originCity;

    @FXML
    private TextField tf_seatsAvailable;

    @FXML
    void Add(ActionEvent event) {
    		
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
    
    //Making selection from the table for add/update/delete flight data
    @FXML
    void handleMouseAction(MouseEvent event) {
    	
    	//LocalDate theDate = datepick_departureDate.getValue();
    	//String formattedTheDate = theDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    	
    	Flight flights = table_viewFlight.getSelectionModel().getSelectedItem();
    	tf_id.setText("" + flights.getId());
    	tf_airlineName.setText(flights.getAirlineName()); 
    	tf_flightNumber.setText("" + flights.getFlightNumber());
    	tf_originCity.setText(flights.getOriginCity());
    	tf_destinationCity.setText(flights.getDestinationCity());
    	tf_departureDate.setText(flights.getDepartureDate());
    	//datepick_departureDate.setPromptText(theDate.toString());;
    	tf_departureTime.setText(flights.getDepartureTime());
    	tf_arrivalDate.setText(flights.getArrivalDate());
    	tf_arrivalTime.setText(flights.getArrivalTime());
    	tf_flightCapacity.setText("" + flights.getFlightCapacity());
    	tf_seatsAvailable.setText("" + flights.getSeatsAvailable());
    	tf_isFull.setText("" + flights.getIsFull());
//    	tf_id.setTextFormatter(null);
    	
    }

    
    @Override
    public void initialize(URL location, ResourceBundle resource) {
    	//display table in javafx
    	showFlights();
    	//going back to main menu
    	button_goback.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "AdminPage.fxml", "Welcome", null);
				
			}

    	});
    	
    	button_addFlight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				
				
				Admin.addFlightData(event, Integer.parseInt(tf_id.getText()), tf_airlineName.getText(), tf_flightNumber.getText(), tf_originCity.getText(),
						tf_destinationCity.getText(), tf_departureDate.getText(), tf_departureTime.getText(), tf_arrivalDate.getText(),
						tf_arrivalTime.getText(), Integer.parseInt(tf_flightCapacity.getText()), Integer.parseInt(tf_seatsAvailable.getText()),
						Integer.parseInt(tf_isFull.getText()));
				

				
				showFlights();	
			}
    	});
			
		button_updateFlight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Admin.updateFlightData(event,Integer.parseInt(tf_id.getText()),tf_airlineName.getText(), tf_flightNumber.getText(), tf_originCity.getText(),
						tf_destinationCity.getText(), tf_departureDate.getText(), tf_departureTime.getText(), tf_arrivalDate.getText(),
						tf_arrivalTime.getText(), Integer.parseInt(tf_flightCapacity.getText()), Integer.parseInt(tf_seatsAvailable.getText()),
						Integer.parseInt(tf_isFull.getText()));
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("The Flight Data has been updated.");
				alert.show();
				
				showFlights();	
			}	
		
		});
    
		button_deleteFlight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Admin.deleteFlightData(event, Integer.parseInt(tf_id.getText()));
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("The Flight Data has been deleted.");
				alert.show();
				
				showFlights();	
			}	
		
		});

    }
    //making a connection, a public method
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
    //using OberservableList, to make a collection of data in a list
    public ObservableList<Flight> getFlightList(){
    	
    	ObservableList<Flight> flightList = FXCollections.observableArrayList();
    	
    	Connection connection = getConnection();
    	
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
    public void showFlights() {
    	
    	ObservableList<Flight> list = getFlightList();
    	
    	col_id.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("id"));
    	col_airlineName.setCellValueFactory(new PropertyValueFactory<Flight, String>("airlineName"));
    	col_flightNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
    	col_originCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("originCity"));
    	col_destinationCity.setCellValueFactory(new PropertyValueFactory<Flight, String>("destinationCity"));
    	col_departureDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDate"));
    	col_departureTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureTime"));
    	col_arrivalDate.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalDate"));
    	col_arrivalTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalTime"));
    	col_flightCapacity.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("flightCapacity"));
    	col_seatsAvailable.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("seatsAvailable"));
    	col_isFull.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("isFull"));
    	
    	table_viewFlight.setItems(list);
    	
    }
    
    public void getDate(ActionEvent event) {
    	
    	
    	
    	
    }
    

}
