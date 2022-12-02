package edu.gsu.db;

import java.util.Scanner;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AzureTeesting {
	
	public static void main(String[] aregs) throws SQLException, ClassNotFoundException{
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		System.out.println("Driver Loaded");
		
		//making a connection db
		
		try {
			 connection = DriverManager.getConnection
				      ("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
								+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
								+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			System.out.println("Database connected");
			
			//query
			String sql = "SELECT userName, userPassword FROM CustomerData";
			//creating statement
			statement = connection.createStatement();
			//executing query
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				
				String userName = resultSet.getString("userName");
				String userPassword = resultSet.getString("userPassword");
				
				System.out.println(userName + " " + userPassword + " ");
			}
		 
		}catch (SQLException e) {
			
			e.printStackTrace();
			
			System.out.println("Database NOT connected");
			
		} finally {
		//closing connection
		resultSet.close();
		statement.close();
		connection.close();
		}	
	}
	


}
