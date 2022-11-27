package GUI;
	
import application.ConfirmBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Stage window;
	Scene scene1;
	Button loginButton, registerButton, forgotPasswordButton;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
		window = primaryStage;
		
		//Creating Buttons for the main page
		Button loginButton = new Button("Login");
		loginButton.setOnAction(e-> CustomerPage.display("",""));
		Button registerButton = new Button("Register");
		Button forgotPasswordButton = new Button("Forgot Password?");
		
		
		//Layout1 - children are laid out in vertical column;
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(loginButton, registerButton, forgotPasswordButton);
		Scene scene1 = new Scene(layout1, 800, 600);
		layout1.setAlignment(Pos.CENTER);
		
		//set title
		window.setTitle("Flight Reservation System");
		window.setScene(scene1);
		window.show();
		
		window.setOnCloseRequest(e-> closeProgram());
	
	}
	
	//Close Request Method
	private void closeProgram() {
			
			boolean answer = ConfirmBox.display("", "Are you sure?");
			
			if (answer)
				window.close();
			
		}
	
}
