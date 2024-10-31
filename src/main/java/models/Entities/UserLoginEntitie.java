package models.Entities;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserLoginEntitie {

    private IntegerProperty idUser;
    private StringProperty userName;
    private StringProperty userPassword;
    private StringProperty email;
    private StringProperty fullName;
    private StringProperty phoneNumber;
    private ObjectProperty<LocalDate> dateOfBirth;
    private ObjectProperty<LocalDateTime> registrationDate;

    /*--------------------------------- Constructors -----------------------------------*/

    // Parameterless constroctor
    public UserLoginEntitie(){

    }

    // Constructor with parameters
    public UserLoginEntitie(int idUser, String userName, String userPassword, String email, String fullName, String phoneNumber, LocalDate dateOfBirth, LocalDateTime registrationDate) {
        this.idUser = new SimpleIntegerProperty(idUser);
        this.userName = new SimpleStringProperty(userName);
        this.userPassword = new SimpleStringProperty(userPassword);
        this.email = new SimpleStringProperty(email);
        this.fullName = new SimpleStringProperty(fullName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.dateOfBirth = new SimpleObjectProperty<>(dateOfBirth);
        this.registrationDate = new SimpleObjectProperty<>(registrationDate);
    }

    /*--------------------------------- Getters and Setters -----------------------------------*/

    public int getIdUser() {
        return idUser.get();
    }

    public IntegerProperty idUserProperty() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser.set(idUser);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getUserPassword() {
        return userPassword.get();
    }

    public StringProperty userPasswordProperty() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword.set(userPassword);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getFullName() {
        return fullName.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth.get();
    }

    public ObjectProperty<LocalDate> dateOfBirthProperty() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate.get();
    }

    public ObjectProperty<LocalDateTime> registrationDateProperty() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate.set(registrationDate);
    }
}
