package edu.gsu.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
//import javax.swing.JTextField;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


public class SearchFlightControl implements Initializable{
	@FXML
	private Text bookedTxt;
	
	@FXML
	private Button button_bookAFlight;

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
    private TextField tf_airlineName;

    @FXML
    private TextField tf_arrivalDate;

    @FXML
    private TextField tf_arrivalTime; 

    @FXML
    private TextField tf_date;

    @FXML
    private TextField tf_departureDate;

    @FXML
    private TextField tf_departureTime;

    @FXML
    private TextField tf_destinationCity;

    @FXML
    private TextField tf_flightNumber; 

    @FXML
    private TextField tf_id; 

    @FXML
    private TextField tf_originCity;
    
    @FXML
    private TextField tf_origin;
    
    @FXML
    private TextField tf_destination;
    
    @FXML
    private Button yourFlightButton;

    @FXML
    private TextField tf_seatsAvailable;
    
    //passing  customer user name value
    static Customer data = Customer.getStoredUserName();
    
    ObservableList<Flight> flightList = FXCollections.observableArrayList();
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    int index;
    
    @FXML
    void handleMouseAction(MouseEvent event) {
    	
    	Flight flights = table_flightTable.getSelectionModel().getSelectedItem();
    	
    	tf_airlineName.setText(flights.getAirlineName()); 
    	tf_flightNumber.setText("" + flights.getFlightNumber());
    	tf_originCity.setText(flights.getOriginCity());
    	tf_destinationCity.setText(flights.getDestinationCity());
    	tf_departureDate.setText(flights.getDepartureDate());
    	tf_departureTime.setText(flights.getDepartureTime());
    	tf_arrivalDate.setText(flights.getArrivalDate());
    	tf_arrivalTime.setText(flights.getArrivalTime());
    	tf_seatsAvailable.setText("" + flights.getSeatsAvailable());
    	
    	
	} 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		lb_userName.setText(" " + data.getUserName());
		
		showCustomerFlights();
	
		
		//(s.h) book flight from search flight page
		button_bookFlight.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				try {
					if(duplicateFlightCheck(tf_flightNumber.getText()) == true) {
						
						if(Integer.parseInt(tf_seatsAvailable.getText()) != 0) {

					 Customer.bookFlight(event, data.getUserName(), tf_airlineName.getText(), tf_flightNumber.getText(), tf_originCity.getText(),
							 tf_destinationCity.getText() , tf_departureDate.getText(), tf_departureTime.getText(), tf_arrivalDate.getText(),
							 tf_arrivalTime.getText(), tf_seatsAvailable.getText());
						} else {
							
							Alert alert = new Alert(Alert.AlertType.ERROR);
							alert.setContentText("No Seats Available");
							alert.show();
							
						}
					 
					} else {
						
						Alert alert = new Alert(Alert.AlertType.ERROR);
						alert.setContentText("Same Flight already exits");
						alert.show();
						
						
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
					
			}
			
		});
		
		// going back to customer page
		button_goback.setOnAction(new EventHandler<ActionEvent>(){
			//@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "CustomerPage.fxml", "Welcome", null );
				
			}
	
			
		});
		yourFlightButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				
				Action.changeScene(event, "CustomerEditFlight.fxml", "Your Flight", null);
				
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
	   
	    tf_origin.textProperty().addListener((observable, oldValue, newValue) -> {
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
	    tf_destination.textProperty().addListener((observable3, oldValue3, newValue3) -> {
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
	    
	    //a method that check if there's any duplicate flight in reservation db table.
    	static boolean duplicateFlightCheck(String flightNumber) throws SQLException {
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
						+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
						+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
				
				preparedStatement = connection.prepareStatement("SELECT * FROM Reservation "
						+ "WHERE flightNumber = ? AND userName = '" + data.getUserName() + "'");
						
				preparedStatement.setString(1, flightNumber);
				
				resultSet = preparedStatement.executeQuery();
				
				
				if (resultSet.isBeforeFirst()) {					
					
					return false;
					
				} else {
									
					return true;
					
				}

			} catch (Exception ex) {
				
				ex.printStackTrace();	
				
			} finally {
				
				connection.close();
			}
			
			return false;

		}
	    
}
