package models.methods;

import models.Entities.UserLoginEntitie;
import models.connection.ConnectionDB;
import utilities.PasswordUtils;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDAO {

    /*--------------------------------- Method Create -----------------------------------*/
    public boolean addUserLogin(UserLoginEntitie user) {
        String query = "INSERT INTO userTable (userName, userPassword,  email, fullName, phoneNumber,  dateOfBirth, registrationDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConnectionDB.startConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, user.getUserName());
            String hashedPassword = PasswordUtils.hashPassword(user.getUserPassword());
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getFullName());
            pstmt.setString(5, user.getPhoneNumber());
            pstmt.setObject(6, user.getDateOfBirth());
            pstmt.setObject(7, user.getRegistrationDate());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error when doing addUserLogin query to database: " + e.getMessage());
            return false;
        }
    }

    /*--------------------------------- Method Read -----------------------------------*/

    public List<UserLoginEntitie> listUserLogin(){
        List<UserLoginEntitie> users = new ArrayList<>();
        String query = "SELECT idUser, userName,   userPassword,  email, fullName,  phoneNumber, dateOfBirth,  registrationDate FROM userTable";
        try(Connection connection = ConnectionDB.startConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery()){
            while (rs.next()){
                UserLoginEntitie user = new UserLoginEntitie(
                        rs.getInt("idUser"),
                        rs.getString("userName"),
                        rs.getString("userPassword"),
                        rs.getString("email"),
                        rs.getString("fullName"),
                        rs.getString("phoneNumber"),
                        rs.getObject("dateOfBirth", LocalDate.class),
                        rs.getObject("registrationDate", LocalDateTime.class)
                );
                users.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error reading users from the database: " + e.getMessage());
        }
        return users;
    }

    /*--------------------------------- Method Update -----------------------------------*/
    public boolean updateUserLogin(UserLoginEntitie user){
        String query = "UPDATE userTable SET userName = ?, userPassword = ?, email = ?, fullName = ?, phoneNumber = ?, dateOfBirth = ?, registrationDate = ? WHERE idUser = ?";
        try(Connection connection = ConnectionDB.startConnection();
            PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setString(1, user.getUserName());
            String hashedPassword = PasswordUtils.hashPassword(user.getUserPassword());
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getFullName());
            pstmt.setString(5, user.getPhoneNumber());
            pstmt.setObject(6, user.getDateOfBirth());
            pstmt.setObject(7, user.getRegistrationDate());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error updating user in the database: " + e.getMessage());
            return false;
        }
    }

    /*--------------------------------- Method Delete -----------------------------------*/
    public boolean deleteUser(int idUser) {
        String query = "DELETE FROM userTable WHERE idUser = ?";
        try (Connection connection = ConnectionDB.startConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {

            pstmt.setInt(1, idUser);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting user from the database: " + e.getMessage());
            return false;
        }
    }

    /*--------------------------------- Validate User -----------------------------------*/
    public boolean validateUser(String userName, String password){
        String query = "SELECT userPassword FROM userTable WHERE BINARY userName = ?";
        try(Connection connection = ConnectionDB.startConnection();
        PreparedStatement pstmt = connection.prepareStatement(query)){
            pstmt.setString(1, userName);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()){
                String storedPassword = rs.getString("userPassword");
                return PasswordUtils.checkPassword(password, storedPassword);
            }
        } catch(SQLException e){
            System.out.println("Error during user validation: " + e.getMessage());
        }
        return false;
    }
}
