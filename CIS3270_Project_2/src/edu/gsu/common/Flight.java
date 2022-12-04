package edu.gsu.common;

public class Flight {
	
	private String airlineName;
	private String flightNumber;
	private String originCity;
	private String destinationCity;
	private String departureDate;
	private String departureTime;
	private String arrivalDate;
	private String arrivalTime;
	private int flightCapacity;
	private int seatsAvailable;
	private int isFull;
	
	public Flight(String airlineName, String flightNumber, String originCity, String destinationCity,
			String departureDate, String departureTime, String arrivalDate, String arrivalTime, int flightCapacity,
			int seatsAvailable, int isFull) {
		
		this.airlineName = airlineName;
		this.flightNumber = flightNumber;
		this.originCity = originCity;
		this.destinationCity = destinationCity;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.flightCapacity = flightCapacity;
		this.seatsAvailable = seatsAvailable;
		this.isFull = isFull;
		
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getFlightCapacity() {
		return flightCapacity;
	}

	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getIsFull() {
		return isFull;
	}

	public void setIsFull(int isFull) {
		this.isFull = isFull;
	}
	

		
}
	

