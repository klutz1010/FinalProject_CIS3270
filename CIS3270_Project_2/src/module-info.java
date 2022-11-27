module CIS3270_Project_1 {
	requires javafx.controls;
	requires java.sql;
	
	opens GUI to javafx.graphics, javafx.fxml;
}
