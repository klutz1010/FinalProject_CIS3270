package edu.gsu.common;

import java.util.Scanner;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AzureTeesting {
	
	public static void main(String[] aregs) throws SQLException, ClassNotFoundException{
		
		Scanner input = new Scanner(System.in);
		
		Connection conn = null;
		
		System.out.println("Driver Loaded");
		
		//making a connection db
		
		try {
			 conn = DriverManager.getConnection
				      ("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			System.out.println("Database connected");
		 
		}catch (SQLException ex) {
			
			System.out.println("Database NOT connected");
			
		}
		//query
		String query = "SELECT * FROM FlightData";
		//statement
		Statement st = conn.createStatement();
		//handle the results
		ResultSet rs = st.executeQuery(query);
		

		//display result
		while (rs.next()) {
			
			 System.out.println(rs.getString(1) + "\t" +
				        rs.getString(2) + "\t" + rs.getString(3));
			
		}
		
		
		
	}
	


}
