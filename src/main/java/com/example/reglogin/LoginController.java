package com.example.reglogin;

import com.opencsv.CSVReader;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML
    private TextField emailTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private void onLoginButtonClick() {
        // Get user input
        String email = emailTextField.getText();
        String password = passwordField.getText();

        // Implement your login logic here
        if (isValidLogin(email, password)) {
            showAlert("Login Successful", "Welcome, " + email + "!");
        } else {
            showAlert("Login Failed", "Invalid email or password. Please try again.");
        }
    }

    // Placeholder method for login validation (replace with your actual logic)
    private boolean isValidLogin(String email, String password) {
        try {
            // Path to the CSV file containing user data
            String pathToCSV = "src/main/resources/UserData.csv";

            // Create a CSVReader to read the CSV file
            CSVReader csvReader = new CSVReader(new FileReader(pathToCSV));

            // Read all rows from the CSV file
            List<String[]> rows = csvReader.readAll();

            // Iterate through each row (user data)
            for (String[] row : rows) {
                // Check if the email and password match any row in the CSV
                if (row.length >= 2 && email.equals(row[2]) && password.equals(row[5])) {
                    // Credentials match, so return true
                    return true;
                }
            }

            // If no match is found, return false
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any exceptions that may occur during CSV file reading
            return false;
        }
    }

    // Helper method to show an alert
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
