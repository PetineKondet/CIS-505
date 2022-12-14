/*
   Kondet Petine (2022). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
   Krasso, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
      Comprehensive Version (12th ed.). Pearson Education, Inc.
    
 */


import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
 
public class KondetEnhancedFutureValueApp extends Application {

    /**
     * Creating the following private variables for the needed components:
     *      tfMonthlyPayment .......-> TextField for the Monthly Payment value
     *      tfInterestRate .........-> TextField for the Interest Rate value
     *      taResult ...............-> TextArea for the output result
     *      lblMonthlyPayment ......-> Label for the Monthly Payment TextField
     *      lblInterestRate ........-> Label for the Interest Rate TextField
     *      lblInterestRateFormat ..-> Label for the Interest Rate Format helper text
     *      lblYears ...............-> Label for the Years ComboBox
     *      lblFutureValueDate .....-> Label for the date of creation to show above the output result TextArea
     *      btnClear ...............-> Button to clear all fields
     *      btnCalculate ...........-> Button to calculate Future Value based on values in MonthlyPayment, InterestRate, and Years
     *      cbYears ................-> ComboBox to display and allow a selection for the number of years desired into the future
     */
    private TextField tfMonthlyPayment;
    private TextField tfInterestRate;
    private TextArea taResult;
    private Label lblMonthlyPayment;
    private Label lblInterestRate;
    private Label lblInterestRateFormat;
    private Label lblYears;
    private Label lblFutureValueDate;
    private Button btnClear;
    private Button btnCalculate;
    private ComboBox<Integer> cbYears;
    

    /**
     * Overriding javafx.application.Application start() method:
     *      Called automatically on the JavaFX Application Thread,
     *      this method defines both what will be drawn onscreen.
     */
    @Override
    public void start(Stage primaryStage) {

        // Set window title to "Kondet Enhanced Future Value App"
        primaryStage.setTitle("Kondet Enhanced Future Value App");

        // Initialize private variables with the specified component objects and attributes
        tfMonthlyPayment = new TextField();
        tfInterestRate = new TextField();
        taResult = new TextArea();
        btnClear = new Button("Clear");
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate = new Button("Calculate");
        btnCalculate.setOnAction(e -> calculateResults());
        lblMonthlyPayment = new Label("Monthly Payment:");
        lblInterestRate = new Label("Interest Rate:");
        lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
        lblInterestRateFormat.setTextFill(Color.RED);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);
        lblYears = new Label("Years:");
        lblFutureValueDate = new Label();
        cbYears = new ComboBox<Integer>();
        cbYears.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
        cbYears.setPrefWidth(165); // Needed to make the Years ComboBox show as the correct width alongside the two TextFields

        // Create new GridPane object and set specified measurements
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5);
        pane.setVgap(5.5);

        // Create new HBox object to organize Buttons btnClear and btnCalculate
        HBox btnContainer = new HBox();
        btnContainer.setPadding(new Insets(15, 0, 15, 30));
        btnContainer.setSpacing(10);
        btnContainer.getChildren().add(btnClear);
        btnContainer.getChildren().add(btnCalculate);

        // Add initialized components to the GridPane in the specified locations
        pane.add(lblMonthlyPayment, 0, 0);
        pane.add(tfMonthlyPayment, 1, 0);
        pane.add(lblInterestRate, 0, 1);
        pane.add(tfInterestRate, 1, 1);
        pane.add(lblInterestRateFormat, 1, 2);
        pane.add(lblYears, 0, 3);
        pane.add(cbYears, 1, 3);
        pane.add(btnContainer, 1, 4);
        pane.add(lblFutureValueDate, 0, 5, 2, 1);
        pane.add(taResult, 0, 6, 2, 1);

        // Define the size of the Scene object created from the GridPane and draw the window onscreen
        primaryStage.setScene(new Scene(pane, 300, 300));
        primaryStage.show();

    } // End start


    /**
     * Void method clearFormFields:
     *      Resets on-screen text and Integer selections
     *      for use with the 'btnClear' component
     */
    private void clearFormFields() {
        
            tfMonthlyPayment.setText("");
            tfInterestRate.setText("");
            taResult.setText("");
            lblFutureValueDate.setText("");
            cbYears.setValue(0);

    } // End clearFormFields


    /**
     * Void method calculateResults:
     *      If the required components contain values,
     *      calls calculateFutureValue from FinanceCalculator.java and displays the returned
     *      value in TextArea taResult.
     *      Also, calls the dateOfCalculation method and displays the returned
     *      value in lblFutureValueDate.
     */
    private void calculateResults() {

        if(!tfMonthlyPayment.getText().isEmpty() && !tfInterestRate.getText().isEmpty() && !cbYears.getSelectionModel().isEmpty()) {

            double futureValue = FinanceCalculator.calculateFutureValue(Double.valueOf(tfMonthlyPayment.getText()), Double.valueOf(tfInterestRate.getText()), cbYears.getValue());
            taResult.setText(String.format("The future value is $%,.2f", futureValue));
            lblFutureValueDate.setText("Calculation as of " + dateOfCalculation());

        }

    } // End calculateResults


    /**
     * String method dateOfCalculation
     * @return Current date in specified String format
     */
    private String dateOfCalculation() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(new Date());

    } // End dateOfCalculation


    public static void main(String[] args) {

        launch(KondetEnhancedFutureValueApp.class, args);

    } // End main

} // End KondetEnhancedFutureValueApp class