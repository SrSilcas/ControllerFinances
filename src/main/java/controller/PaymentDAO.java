package controller;

import model.Payment;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    public static void save(Payment payment){
        String SQL = "INSERT INTO payment (value, paid, month, year)" +
                "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement =  null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setDouble(1, payment.getValue());
            statement.setBoolean(2, payment.isStatus());
            statement.setInt(3, payment.getMonth());
            statement.setInt(4, payment.getYear());

            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException("Error to save payment into database" + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection,statement);
        }
    }
    public static void removeById(int paymentId){
        String SQL = "DELETE FROM payment WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement =  null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, paymentId);

            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException("Error to");
        }finally {
            ConnectionFactory.closeConnection(connection,statement);
        }
    }
    public static List<Payment> getAllByMonth(int month){
        String SQL = "SELECT * FROM payment WHERE month = ?";
        Connection connection = null;
        PreparedStatement statement =  null;
        ResultSet result = null;
        List<Payment> payments = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1,month);
            result = statement.executeQuery();

            while(result.next()){
                Payment payment = new Payment();
                payment.setId(result.getInt("id"));
                payment.setStatus(result.getBoolean("status"));
                payment.setValue(result.getDouble("value"));
                payment.setMonth(result.getInt("month"));
                payment.setYear(result.getInt("year"));
                payments.add(payment);
            }

        }catch (SQLException ex){
            throw new RuntimeException("Error to");
        }finally {
            ConnectionFactory.closeConnection(connection,statement,result);
        }
        return  payments;
    }
    public static List<Payment> getAll(){
        String SQL = "SELECT * FROM payment";
        Connection connection = null;
        PreparedStatement statement =  null;
        ResultSet result = null;
        List<Payment> payments = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            result = statement.executeQuery();

            while(result.next()){
                Payment payment = new Payment();
                payment.setId(result.getInt("id"));
                payment.setStatus(result.getBoolean("status"));
                payment.setValue(result.getDouble("value"));
                payment.setMonth(result.getInt("month"));
                payment.setYear(result.getInt("year"));
                payments.add(payment);
            }

        }catch (SQLException ex){
            throw new RuntimeException("Error to get all payments" + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection,statement,result);
        }
        return payments;
    }
}
