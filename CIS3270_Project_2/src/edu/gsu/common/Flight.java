package edu.gsu.common;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Flight {
	
	private final StringProperty airlineName;
	private final StringProperty flightNumber;
	private final StringProperty originCity;
	private final StringProperty destinationCity;
	private final StringProperty departureDate;
	private final StringProperty departureTime;
	private final StringProperty arrivalDate;
	private final StringProperty arrivalTime;
	private final StringProperty flightCapacity;
	private final StringProperty seatsAvailable;
	private final StringProperty isFull;
	
	public Flight() {
		
		airlineName = new SimpleStringProperty(this, "airlineName");
		flightNumber = new SimpleStringProperty(this, "flightNumber");
		originCity = new SimpleStringProperty(this, "originCity");
		destinationCity = new SimpleStringProperty(this, "destinationCity");
		departureDate = new SimpleStringProperty(this, "departureDate");
		departureTime = new SimpleStringProperty(this, "departureTime");
		arrivalDate = new SimpleStringProperty(this, "arrivalDate");
		arrivalTime = new SimpleStringProperty(this, "arrivalTime");
		flightCapacity = new SimpleStringProperty(this, "flightCapacity");
		seatsAvailable = new SimpleStringProperty(this, "seatsAvailable");
		isFull = new SimpleStringProperty(this, "isFull");
		
	}
	
	public StringProperty airlineNameProperty() { return airlineName; }
    public String getAirlineName() { return airlineName.get(); }
    public void setAirlineName(String newId) { airlineName.set(newId); }
 
    public StringProperty flightNumberProperty() { return flightNumber; }
    public String getFlightNumber() { return flightNumber.get(); }
    public void setFlightNumber(String newName) { flightNumber.set(newName); }
 
    public StringProperty originCityProperty() { return originCity; }
    public String getOriginCity() { return originCity.get(); }
    public void setOriginCity(String newMobile) { originCity.set(newMobile); }
    
    public StringProperty destinationCityProperty() { return destinationCity; }
    public String getDestinationCity() { return destinationCity.get(); }
    public void setDestinationCity(String newCourse) { destinationCity.set(newCourse); }
    
    public StringProperty departureDateProperty() { return departureDate; }
    public String getDepartureDate() { return departureDate.get(); }
    public void setDepartureDate(String newCourse) { departureDate.set(newCourse); }
    
    public StringProperty departureTimeProperty() { return departureTime; }
    public String getDepartureTime() { return departureTime.get(); }
    public void setDepartureTime(String newCourse) { departureTime.set(newCourse); }
    
    public StringProperty arrivalDateProperty() { return arrivalDate; }
    public String getArrivalDate() { return arrivalDate.get(); }
    public void setArrivalDate(String newCourse) { arrivalDate.set(newCourse); }
    
    public StringProperty arrivalTimeProperty() { return arrivalTime; }
    public String getArrivalTime() { return arrivalTime.get(); }
    public void setArrivalTime(String newCourse) { arrivalTime.set(newCourse); }
    
    public StringProperty flightCapacityProperty() { return flightCapacity; }
    public String getFlightCapacity() { return flightCapacity.get(); }
    public void setFlightCapcity(String newCourse) { flightCapacity.set(newCourse); }
    
    public StringProperty seatsAvailableProperty() { return seatsAvailable; }
    public String getSeatsAvailable() { return seatsAvailable.get(); }
    public void setSeatsAvailable(String newCourse) { seatsAvailable.set(newCourse); }
    
    public StringProperty isFullProperty() { return isFull; }
    public String getIsFull() { return isFull.get(); }
    public void setIsFull(String newCourse) { isFull.set(newCourse); }

}
