package org.example.customerlistjfxjdbc;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteController {
    public TextField idTxtField;
    public TextField nameTxtField;
    public TextField addressTxtField;
    public TextField salTxtField;
    public TextField conTxtField;
    public VBox alertBox;
    public Label alertMessage;

    public void cancelOnClick(ActionEvent actionEvent) {
        idTxtField.setText(null);
        nameTxtField.setText(null);
        addressTxtField.setText(null);
        salTxtField.setText(null);
        conTxtField.setText(null);
    }

    public void idOnClick(ActionEvent actionEvent) {
        String SQL = "Select * from Customer where id="+idTxtField.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerData", "root", "rootpassword");
            java.sql.Statement stm = connection.createStatement();
            //stm.executeUpdate(SQL);
            ResultSet rst = stm.executeQuery(SQL);

            if(rst.next()){
                String contactNo = rst.getString("contactNo"); //rst.getString(1);
                String name = rst.getString("name");
                String address = rst.getString("address");
                String salary = rst.getString("salary");
                nameTxtField.setText(name);
                addressTxtField.setText(address);
                salTxtField.setText(salary);
                conTxtField.setText(contactNo);
            }
            else{ alertMessage.setText("Invalid Id!");
                alertBox.setVisible(true);}
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteOnClick(ActionEvent actionEvent) {
        String SQL = "delete from Customer " +
                "WHERE id = " + idTxtField.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerData", "root", "rootpassword");
            java.sql.Statement stm=connection.createStatement();
            stm.executeUpdate(SQL);
            alertMessage.setText("Successfully Deleted");
            alertBox.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException ex) {
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
