module com.example.appcrud {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires jbcrypt;
    requires mysql.connector.j;

    opens com.example.appcrud to javafx.fxml;
    exports com.example.appcrud;
    exports controllers;
    opens controllers to javafx.fxml;
}