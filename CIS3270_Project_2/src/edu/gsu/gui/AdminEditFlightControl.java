package edu.gsu.gui;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import edu.gsu.common.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminEditFlightControl implements Initializable {
	
	@FXML
	private Button button_goback;
	
    @FXML
    private Button button_add;

    @FXML
    private Button button_delete;

    @FXML
    private Button button_update;

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
    private TextField tf_airlineName;

    @FXML
    private TextField tf_destinationCity;

    @FXML
    private TextField tf_flightNumber;

    @FXML
    private TextField tf_originCity;

    @FXML
    void Add(ActionEvent event) {
    		
    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Update(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL location, ResourceBundle resource) {
    	
    	showFlights();
    	
    	button_goback.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "AdminPage.fxml", "Welcome", null);
				
			}
    	
    	});

    }

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
    	
    	String query = "SELECT airlineName, flightNumber, originCity, destinationCity, departureDate, departureTime, "
    			+ "arrivalDate, arrivalTime, flightCapacity, seatsAvailable, isFull FROM FlightData";
    	Statement st;
    	ResultSet rs;
    	
    	try {
    		
    		st = connection.createStatement();
    		rs = st.executeQuery(query);
    		Flight flights;
    		
    		while(rs.next()) {
    			
    			flights = new Flight(rs.getString("airlineName"), rs.getString("flightNumber"), rs.getString("originCity"),
    					rs.getString("destinationCity"), rs.getString("departureDate"), rs.getString("departureTime"),
    					rs.getString("arrivalDate"), rs.getString("arrivalTime"), rs.getInt("flightCapacity"), rs.getInt("seatsAvailable"), rs.getInt("isFull"));
    			
    			flightList.add(flights);
    		}

    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return flightList;
    }
    
    public void showFlights() {
    	
    	ObservableList<Flight> list = getFlightList();
    	
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

}
