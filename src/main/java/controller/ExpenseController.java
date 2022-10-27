package controller;

import model.Expense;
import model.Payment;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ExpenseController {
    public void save(Expense expense, Payment payment){
        String SQL = "INSERT INTO expense (idpayment, value, usedproducts, month, year)" +
                "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1,payment.getId());
            statement.setDouble(2, expense.getValue());
            statement.setString(3, expense.getUsedProducts());
            statement.setInt(4, expense.getMonth());
            statement.setInt(5, expense.getYear());

            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException("Error to save expense into database");
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    public void removeById(int expenseId){
        String SQL = "DELETE FROM expense WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, expenseId);

            statement.execute();
        }catch (SQLException ex){
            throw new RuntimeException("Error to delete expense from database");
        }finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    public List <Expense> getAll(){
        String SQL = "";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
        }catch (SQLException ex){
            throw new RuntimeException("Error to");
        }finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return null;
    }
}
