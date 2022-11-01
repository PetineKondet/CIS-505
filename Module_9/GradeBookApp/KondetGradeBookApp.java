/*
   Kondet Petine (2022). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.
   Krasso, R. (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved.

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
      Comprehensive Version (12th ed.). Pearson Education, Inc.
    
 */


import java.util.Set;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.text.DecimalFormat;
import javafx.geometry.Insets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;
import java.util.*;

public class KondetGradeBookApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }//end main method    

    //@Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("OpenEdX Gradebook App");                
        GridPane gp = new GridPane();
        gp.setHgap(5);
        gp.setVgap(5);
        
        //create labels
        Label lblFirstName = new Label("Student's First Name: ");
        Label lblLastName = new Label("Student's Last Name: ");
        Label lblCourseName = new Label("Course they completed: ");
        Label lblGrade = new Label("Student's course grade: ");
        //end labels
                       
        //start setup form controls
        TextField tfFirstName = new TextField();
        TextField tfLastName = new TextField();
        TextField tfCourseName = new TextField();
        //end textfields

        //start set up of results area
        TextArea taResults = new TextArea();
        //end textareas
                     
        ComboBox<String> cboBoxGrades = new ComboBox<String>();
        List<String> gradesList = new ArrayList<String>(Arrays.asList("A","B","C","D","F"));
        cboBoxGrades.getItems().addAll(gradesList);
        
        Button btnClear = new Button("Clear");
        btnClear.setOnAction(e -> clearFormFields(tfFirstName, tfLastName, tfCourseName, cboBoxGrades));
        Button btnSave = new Button("Save");
        btnSave.setOnAction(e -> saveGrades(tfFirstName.getText(), tfLastName.getText(), tfCourseName.getText(), cboBoxGrades.getValue(), taResults));
        Button btnView = new Button("View");
        btnView.setOnAction(e -> viewGrades(taResults));
        Button btnHelp = new Button ("Help");
        //end buttons
        //end setup form controls
                
        //start setup gridpane
        gp.setAlignment(Pos.CENTER);
        gp.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        gp.setHgap(5.5);
        gp.setVgap(5.5);
        
        //add controls to gridpane
        gp.add(lblFirstName, 1, 1);
        gp.add(tfFirstName, 2, 1);
        //end first row of grid
        
        gp.add(lblLastName, 1, 2);
        gp.add(tfLastName, 2, 2);
        //end second row of grid
        
        gp.add(lblCourseName, 1, 3);
        gp.add(tfCourseName, 2, 3);
        //end third row of grid
        
        gp.add(lblGrade, 1, 4);
        gp.add(cboBoxGrades, 2, 4);
        //end fourth row of grid
        
        gp.add(btnClear, 1, 5);
        gp.add(btnSave, 2, 5);
        //end fifth row of grid
        
        gp.add(btnView, 1, 6);
        gp.add(btnHelp, 2, 6);
        //end sixth row of grid

        gp.add(taResults,1,7,2,7);
        //end seventh row of grid
        //end add controls to gridpane
        //end setup gridpane
       
        Scene myScene = new Scene(gp);//set gridpane to scene
        primaryStage.setScene(myScene);
        primaryStage.show();
    }//end start override method

    private void clearFormFields(TextField t1, TextField t2, TextField t3, ComboBox<String> cb1){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        cb1.setValue(null);
    }

    private void saveGrades(String t1, String t2, String t3, String cb1, TextArea ta1){
        try{
            File file = new File("grades.csv");
            PrintWriter output = null;
            if(file.exists()) { 
                output = new PrintWriter(new FileOutputStream(new File("grades.csv"),true));
            }
            else{
                output = new PrintWriter("grades.csv");
                output.print("firstName,lastName,course,grade\n");
            }
            output.print(t1 + "," + t2 + "," + t3 + "," + cb1 + "\n");
            output.close();

            Student student = new Student();
            student.setFname(t1);
            student.setLname(t2);
            student.setCourseName(t3);
            student.setGrade(cb1);

            ta1.setText(student.toString());
        }
        catch(IOException e){
            System.out.println("\n  Exception: " + e.getMessage());
        }
    }

    private void viewGrades(TextArea ta1){
        String csvResults = "";
        try{
            Scanner scanner = new Scanner(new File("grades.csv"));

            scanner.useDelimiter(",");

            while(scanner.hasNext()){
                csvResults = csvResults + scanner.next() + ",  ";
            }

            scanner.close();

            ta1.setText(csvResults);
        }
        catch(IOException e){
            System.out.println("\n  Exception: " + e.getMessage());
        }
    }
}//end Main class