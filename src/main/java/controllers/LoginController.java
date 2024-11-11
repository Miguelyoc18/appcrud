package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.methods.UserLoginDAO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private PasswordField pFPassword;

    @FXML
    private TextField txtUserLogin;

    /*--------------------------------- Action Buttons -----------------------------------*/

    //Action button User
    public final UserLoginDAO userLoginDAO = new UserLoginDAO();
    @FXML
    void actionButtonLogin(ActionEvent event) {
        String username = txtUserLogin.getText();
        String password = pFPassword.getText();

        if (userLoginDAO.validateUser(username, password)){
            openMenuWindow();
        } else {
            showAlert("Invalid credentials. Please try again.");
        }
    }

    //Method open menu windows
    private void openMenuWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/appcrud/Menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.setTitle("Menu");
            stage.show();

            // Cerrar la ventana de login
            Stage loginStage = (Stage) btnLogin.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            System.out.println("Error loading Menu window: " + e.getMessage());
        }
    }

    //Action button sing up
    @FXML
    void actionButtonSignUp(ActionEvent event) {

    }

    /*--------------------------------- Initialize -----------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Spaces are not allowed
        txtUserLogin.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.contains(" ")) {
                showAlert("Spaces are not allowed in the username or password");
                txtUserLogin.setText(newValue.replace(" ", ""));
            }
        });

        pFPassword.textProperty().addListener(((observableValue, oldValue, newValue) -> {
            if (newValue.contains(" ")) {
                showAlert("Spaces are not allowed in the username or password");
                pFPassword.setText(newValue.replace(" ", ""));
            }
        }));

        //Lambda


    }

    /*--------------------------------- Methods to display alerts -----------------------------------*/

    //Spaces
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Alert ⚠\uFE0F");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}