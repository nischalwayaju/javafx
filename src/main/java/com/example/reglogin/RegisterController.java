package com.example.reglogin;

import com.opencsv.CSVWriter;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.FileWriter;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField contactTextField;

    @FXML
    private DatePicker dobDatePicker;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void onRegisterButtonClick() {
        // Get user input
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String contact = contactTextField.getText();
        String dob = dobDatePicker.getValue() != null ? dobDatePicker.getValue().toString() : "";
        String password = passwordField.getText();

        // Path to the CSV file
        String pathToCSV = "src/main/resources/UserData.csv";

        try {
            // Create a FileWriter and CSVWriter to write to the CSV file
            FileWriter fileWriter = new FileWriter(pathToCSV, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            // Create an array of strings with user data
            String[] csvData = {firstName, lastName, email, contact, dob, password};

            // Write the data to the CSV file
            csvWriter.writeNext(csvData);

            // Close the CSVWriter
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

