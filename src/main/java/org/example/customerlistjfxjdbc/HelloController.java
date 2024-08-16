package org.example.customerlistjfxjdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

public class HelloController {
    public TextField nameTxtField;
    public TextField idTxtField;
    public TextField addressTxtField;
    public TextField salTxtField;
    public TextField conTxtField;
    public VBox alertBox;
    public Label alertMessage;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void cancelOnClick(ActionEvent actionEvent) {
        idTxtField.setText(null);
        nameTxtField.setText(null);
        addressTxtField.setText(null);
        salTxtField.setText(null);
        conTxtField.setText(null);
    }

    public void addOnClick(ActionEvent actionEvent) {
        String SQL="Insert into Customer values('"+idTxtField.getText()+"'"+","+"'"+nameTxtField.getText()+"'"+","+"'"+addressTxtField.getText()+"'"+","+"'"+salTxtField.getText()+"'"+","+"'"+conTxtField.getText()+"')";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerData", "root", "rootpassword");
            java.sql.Statement stm=connection.createStatement();
            stm.executeUpdate(SQL);
            alertMessage.setText("Added Successfully!");
            alertBox.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException ex) {
            alertMessage.setText("Enter All Data !");
            alertBox.setVisible(true);
            System.out.println(ex.getMessage());
        }

    }

    public void closeAlert(ActionEvent actionEvent) {
        alertBox.setVisible(false);
        idTxtField.setText(null);
        nameTxtField.setText(null);
        addressTxtField.setText(null);
        salTxtField.setText(null);
        conTxtField.setText(null);
    }
}