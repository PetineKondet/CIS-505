/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * @author Petine Kondet CIS-505 Bellevue University
 * 
 *         Class for Grade Book App
 */

public class KondetGradeBookApp extends Application {

	// Create TexFields
	private TextField firstNameField = new TextField();
	private TextField lastNameField = new TextField();
	private TextField courseField = new TextField();

	// Create TextArea for grades output
	private TextArea gradeResults = new TextArea();

	// Create Labels for the controllers
	private Label lblFirstName = new Label("First Name:");
	private Label lblLastName = new Label("Last Name:");
	private Label lblCourse = new Label("Course:");
	private Label lblGrade = new Label("Grade:");

	// Create ComboBox of type String for grades
	private ComboBox<String> gradesBox = new ComboBox<String>();

	// Create buttons
	private Button btnClear = new Button("Clear");
	private Button btnViewGrades = new Button("View Grades");
	private Button btnSaveGrades = new Button("Save Grades");

	/**
	 * Overridden start method for starting the GUI
	 */
	@Override
	public void start(Stage primaryStage) {

		// Create grid pane and set attributes
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		pane.setVgap(5.5);
		pane.setHgap(5.5);
		
		//Add controllers to GridPane
		pane.add(firstNameField, 1, 0);
		pane.add(lastNameField, 1, 1);
		pane.add(courseField, 1, 2);
		pane.add(gradeResults, 0, 5, 2, 1);
		pane.add(lblFirstName, 0, 0);
		pane.add(lblLastName, 0, 1);
		pane.add(lblCourse, 0, 2);
		pane.add(lblGrade, 0, 3);
		pane.add(gradesBox, 1, 3);
		//Set combobox to max width so it fills entire row
		gradesBox.setMaxWidth(Double.MAX_VALUE);
		// Add combobox items
		gradesBox.getItems().addAll("A", "B", "C", "D", "F");
		
		//Create HBox for buttons
		HBox actionBtnContainer = new HBox();
		actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
		actionBtnContainer.setSpacing(10);
		actionBtnContainer.getChildren().add(btnViewGrades);
		actionBtnContainer.getChildren().add(btnSaveGrades);
		actionBtnContainer.getChildren().add(btnClear);
		pane.add(actionBtnContainer, 1, 4);	

		//Set the scene, add title and show the GUI
		Scene scene = new Scene(pane, 350, 350);
		primaryStage.setTitle("Kondet Grade Book App");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		//Launch the window
		launch(args);
	}

}