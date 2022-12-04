module CIS3270_Project_1 {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens edu.gsu.gui to javafx.graphics, javafx.fxml;
	opens edu.gsu.common;
}
