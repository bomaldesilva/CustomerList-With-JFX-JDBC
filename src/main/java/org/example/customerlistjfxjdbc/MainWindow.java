package org.example.customerlistjfxjdbc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import java.io.IOException;

public class MainWindow{
    public void addOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 460);
        Stage stage = new Stage();
        stage.setTitle("Add Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void searchOnClick(ActionEvent actionEvent) throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 460);
        Stage stage = new Stage();
        stage.setTitle("Search Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void updateOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("update.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 460);
        Stage stage = new Stage();
        stage.setTitle("Update Customer");
        stage.setScene(scene);
        stage.show();
    }

    public void viewOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 460);
        Stage stage = new Stage();
        stage.setTitle("View Customers");
        stage.setScene(scene);
        stage.show();
    }

    public void deleteOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("delete.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 460);
        Stage stage = new Stage();
        stage.setTitle("Delete Customer");
        stage.setScene(scene);
        stage.show();
    }


}
