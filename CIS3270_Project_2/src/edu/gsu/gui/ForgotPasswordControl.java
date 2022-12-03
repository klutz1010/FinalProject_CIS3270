package edu.gsu.gui;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ForgotPasswordControl implements Initializable{
	
	@FXML
	private TextField tf_username;
	@FXML
	private TextField tf_securityanswer;
	@FXML
	private TextField tf_newpassword;
	@FXML
	private Button button_resetyourpassword;
	@FXML
	private Button button_goback;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		button_goback.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				
				Action.changeScene(event, "Main.fxml", "Main", null);
				
			}
			
		});

		button_resetyourpassword.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				resetPassword(event, tf_username.getText(), tf_securityanswer.getText(), tf_newpassword.getText());
					
				}

		});
		
	}

	public static void resetPassword(ActionEvent event, String userName, String securityAnswer, String newPassword) {
		
		Connection resetCN = null;
		PreparedStatement resetPS = null;
		ResultSet resetRS = null;
		
		try {
			resetCN = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
					+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
					+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			resetPS = resetCN.prepareStatement("SELECT securityAnswer FROM CustomerData WHERE userName = ? ");
			resetPS.setString(1, userName);
			resetRS = resetPS.executeQuery();
			
			if (resetRS.isBeforeFirst()) {
				
				System.out.println("Your Asnwer Matches!");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Your Asnwer Matches!");
				alert.show();
				
				
			} else {
				
				System.out.println("Your Asnwer does not Match!");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Your Asnwer does not Match!");
				alert.show();
				
			}
			
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

}
