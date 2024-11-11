package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {


    @FXML
    private Button btnReturnLogin;

    @FXML
    private Button btnSignUpRegister;

    @FXML
    private TextField tstUserNameRegister;

    @FXML
    private DatePicker txtBirthdateRegister;

    @FXML
    private TextField txtEmailRegister;

    @FXML
    private TextField txtFullNameRegister;

    @FXML
    private TextField txtPasswordRegister;

    @FXML
    private TextField txtPhoneNumberRegister;

    @FXML
    void actionButtonReturnLogin(ActionEvent event) {

    }

    @FXML
    void actionButtonSignUpRegister(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
