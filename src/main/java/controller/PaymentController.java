package controller;

import model.Payment;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PaymentController {
    public void save(Payment payment){
        String SQL = "INSERT INTO payment (value, paid, month, year)" +
                "VALUES (?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement =  null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setDouble(1, payment.getValue());
            statement.setBoolean(2, payment.isPaid());
            statement.setInt(3, payment.getMonth());
            statement.setInt(4, payment.getYear());

            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException("Error to save payment into database" + ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(connection,statement);
        }
    }
    public void removeById(int paymentId){
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
    public List<Payment> getAll(){
        String SQL = "";
        Connection connection = null;
        PreparedStatement statement =  null;
        ResultSet result = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
        }catch (SQLException ex){
            throw new RuntimeException("Error to");
        }finally {
            ConnectionFactory.closeConnection(connection,statement,result);
        }
        return  null;
    }
}
