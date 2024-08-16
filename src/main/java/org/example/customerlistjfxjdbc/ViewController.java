package org.example.customerlistjfxjdbc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewController {

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> contactNo;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> salary;

    @FXML
    private TableView<Customer> tbl;

    public void reloadOnClick(ActionEvent actionEvent) {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        contactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        String SQL = "Select * from Customer";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerData", "root", "rootpassword");
            java.sql.Statement stm = connection.createStatement();
            //stm.executeUpdate(SQL);
            ResultSet rst = stm.executeQuery(SQL);
            ObservableList<Customer> customerList = FXCollections.observableArrayList();

            // Populate the list with data from the ResultSet
            while (rst.next()) {
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("address");
                String salary = rst.getString("salary");
                String contactNo = rst.getString("contactNo");
                customerList.add(new Customer(id, name, address, salary, contactNo));
            }
            // Set the items for the table
            tbl.setItems(customerList);

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
