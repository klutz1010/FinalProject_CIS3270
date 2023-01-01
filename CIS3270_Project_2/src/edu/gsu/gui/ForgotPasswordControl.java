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
import javafx.scene.control.Label;
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
    @FXML
    private Button button_securityQuestion;
	@FXML
	private Label label_securityQuestion;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
//		label_securityQuestion.setText(displayQuestion);
		
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
		
		button_securityQuestion.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				displayQuestion(event, tf_username.getText());

					
				}

		});
		
	}

	public static void resetPassword(ActionEvent event, String userName, String securityAnswer, String newPassword) {
		
		Connection resetCN = null;
		PreparedStatement resetPS = null;
		PreparedStatement newpwPS = null;
		ResultSet resetRS = null;
		
		try {
			resetCN = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
					+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
					+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			resetPS = resetCN.prepareStatement("SELECT securityAnswer FROM CustomerData WHERE userName = ? ");
			resetPS.setString(1, userName);
			resetRS = resetPS.executeQuery();
			
			if (resetRS.isBeforeFirst()) {
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setContentText("Your Answer Matches!, Your Password has been Reset");
				alert.show();
				
				newpwPS = resetCN.prepareStatement("UPDATE customerData SET userPassword = ? WHERE userName = ?");
				newpwPS.setString(1, newPassword);
				newpwPS.setString(2, userName);
				newpwPS.executeUpdate();
				
			} else {

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Your Answer does not Match!");
				alert.show();
				
			}
			
		
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
	
	private void displayQuestion(ActionEvent Event, String userName) {

		Connection questionCN = null;
		PreparedStatement questionPS = null;
		ResultSet questionRS = null;
		
		try {
			questionCN = DriverManager.getConnection("jdbc:sqlserver://cis3270finalproject.database.windows.net:1433;"
					+ "database=Project;user=cis3270admin@cis3270finalproject;password={Cis3270finalproject};"
					+ "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
			
			questionPS = questionCN.prepareStatement("SELECT securityQuestion FROM CustomerData WHERE userName = ? ");
			questionPS.setString(1, userName);
			questionRS = questionPS.executeQuery();
			
			if (questionRS.next()) {
				
				String question = questionRS.getString("securityQuestion");
				label_securityQuestion.setText(question);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (NullPointerException e) {
			
			e.printStackTrace();
			
		}
		

		
	}
	
}
