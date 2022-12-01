package edu.gsu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerData {
	
	public boolean pass(String user, String pass) throws SQLException, ClassNotFoundException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String sql = "select * from customer where userName = ? and userPassword = ? ";
		
			try {
				
		    myConn = DriverManager.getConnection
		    		("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
							+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
							+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		    
		    myStmt = myConn.prepareStatement(sql);
		    myStmt.setString(1, user);
		    myStmt.setString(2, pass);
		    myRs = myStmt.executeQuery();
		    
		    if (myRs.next()) {
		    	return true;
		    }
		    else 
		    	return false;
			}
			
		    catch(Exception ex) {
				ex.printStackTrace();
			}
			finally {
			    myConn.close();
    		  }
			
			return false;
	}


}
