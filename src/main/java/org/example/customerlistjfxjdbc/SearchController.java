package org.example.customerlistjfxjdbc;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class SearchController {
    public TextField idTxtField;
    public TextField nameTxtField;
    public TextField addressTxtField;
    public TextField salTxtField;
    public TextField conTxtField;
    public Label alertMessage;
    public VBox alertBox;

    public void cancelOnClick(ActionEvent actionEvent) {
        idTxtField.setText(null);
        nameTxtField.setText(null);
        addressTxtField.setText(null);
        salTxtField.setText(null);
        conTxtField.setText(null);
    }

    public void searchOnClick(ActionEvent actionEvent){
        String SQL = "Select * from Customer where id="+idTxtField.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerData", "root", "rootpassword");
            java.sql.Statement stm = connection.createStatement();
            //stm.executeUpdate(SQL);
            ResultSet rst = stm.executeQuery(SQL);

            if (rst.next()) {
                String contactNo = rst.getString("contactNo"); //rst.getString(1);
                String name = rst.getString("name");
                String address = rst.getString("address");
                String salary = rst.getString("salary");
                nameTxtField.setText(name);
                addressTxtField.setText(address);
                salTxtField.setText(salary);
                conTxtField.setText(contactNo);
            } else {
                // If no results are found, show an alert
                alertMessage.setText("Invalid customer ID entered!");
                alertBox.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            alertMessage.setText("System Error!");
            alertBox.setVisible(true);
            System.out.println("Driver not found");
        } catch (SQLException ex) {
            if(Objects.nonNull(idTxtField)){
            alertMessage.setText("Please enter customer Id!");
            alertBox.setVisible(true);}
            System.out.println(ex.getMessage());
        }
    }

    public void closeAlert(ActionEvent actionEvent) {
        alertBox.setVisible(false);
    }
}
