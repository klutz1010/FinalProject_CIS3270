module CIS3270_Project_1 {
	requires javafx.controls;
	requires java.sql;
	
	opens edu.gsu.gui to javafx.graphics, javafx.fxml;
}
