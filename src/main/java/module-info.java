module org.example.customerlistjfxjdbc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;
    requires static lombok;


    opens org.example.customerlistjfxjdbc to javafx.fxml;
    exports org.example.customerlistjfxjdbc;
}