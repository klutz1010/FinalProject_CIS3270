package edu.gsu.db; //copy and paste from professor's google drive need to work on this.

public class DBQueries {
	
	public static void login(Customer co) throws Exception {
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection
					      ("jdbc:mysql://localhost/test","root","password");
					       // ("jdbc:mysql://104.196.113.68/test","root","password");
					
			System.out.println("Database connected");

			// Create a statement
			PreparedStatement statement = connection.prepareStatement(Queries.LOGIN);
				    
			statement.setString(1, co.getUserName());
			statement.setString(2, co.getPassword());
				    
			// Execute a statement
			ResultSet resultSet = statement.executeQuery();
			
			int count = 0;

			// Iterate through the result and print the student names
			while (resultSet.next()) {
				System.out.println("Number of Users:" + resultSet.getInt(1));
				count = resultSet.getInt(1);
			}
			
			if (count == 0)
				throw new LoginException("Invalid UserName or Password!");
				     
	    
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
		}
		finally {
			
			connection.close();
		}
	}    
	
	public static void getFlights(Customer co) throws Exception {
		
		// can I run a query on reservation table that select all teh rows with customerID comes from co
		
		Flight f1 = new Flight();
		f1.setAirlineName("Delta 303");
		
		Flight f2 = new Flight();
		f2.setAirlineName("Delta 500");
		
		Flight f3 = new Flight();
		f3.setAirlineName("Delta 777");
		
		co.getFlights().add(f1);
		co.getFlights().add(f2);
		co.getFlights().add(f3);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		Customer c0 = new Customer();
		login(c0);
		
		
	}

}
