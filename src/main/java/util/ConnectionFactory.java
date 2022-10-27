package util;

import java.sql.*;

public class ConnectionFactory {

    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/ControllerFinances";
    private static final String USER = "postgres";
    private static final String PASS = "lucas864713";
    //method to get connection
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Error to get connection" + ex.getMessage(), ex);
        }
    }
    //methods to close connection
    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error to close connection" + ex.getMessage(),ex);
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error to close connection" + ex.getMessage(),ex);
        }
    }
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet result){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (result != null){
                result.close();
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error to close connection" + ex.getMessage(),ex);
        }
    }
}
