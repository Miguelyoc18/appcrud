package models.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection;
    private final static String userConnection = "root";
    private final static String passwordConnection = "Mikymcvd#16020";
    private final static int localHost = 3306;
    private final static String db = "appcrud";
    private final static String url = "jdbc:mysql://localhost:" + localHost + "/" + db;

    /*--------------------------------- Constructor  -----------------------------------*/

    private ConnectionDB() {

    }

    /*--------------------------------- Methods -----------------------------------*/

    //Start
    public static synchronized Connection startConnection() {
        if (connection == null || connectionStatus(connection)) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, userConnection, passwordConnection);
                System.out.println("Successful connection");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Driver not found: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Database connection error: " + e.getMessage());
            }
        }
        return connection;
    }

    //Close
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("The connection is closed");
            } catch (SQLException e) {
                System.out.println("error closing connection: " + e.getMessage());
            }
        }
    }

    public static boolean connectionStatus(Connection conn) {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            System.out.println("Error checking connection status: " + e.getMessage());
            return true;
        }
    }
}
