module com.example.reglogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires opencsv;
    opens com.example.reglogin to javafx.fxml;
    exports com.example.reglogin;
}