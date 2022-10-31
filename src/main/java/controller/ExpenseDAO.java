package controller;

import model.Expense;
import model.Payment;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    public static void save(Expense expense, Payment payment){
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
    public static void removeById(int expenseId){
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
    public static List <Expense> getAllByMonth(int month){
        String SQL = "SELECT * FROM expense WHERE month = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Expense> expenses = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, month);
            result = statement.executeQuery();

            while (result.next()){
                Expense expense = new Expense();
                expense.setId(result.getInt("id"));
                expense.setIdPayment(result.getInt("idpayment"));
                expense.setValue(result.getDouble("value"));
                expense.setUsedProducts(result.getString("usedproducts"));
                expense.setMonth(result.getInt("month"));
                expense.setYear(result.getInt("year"));

                expenses.add(expense);
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error to get expenses by month");
        }finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return expenses;
    }
    public static List <Expense> getAll(){
        String SQL = "SELECT * FROM expense";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Expense> expenses = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(SQL);
            result = statement.executeQuery();

            while (result.next()){
                Expense expense = new Expense();
                expense.setId(result.getInt("id"));
                expense.setIdPayment(result.getInt("idpayment"));
                expense.setValue(result.getDouble("value"));
                expense.setUsedProducts(result.getString("usedproducts"));
                expense.setMonth(result.getInt("month"));
                expense.setYear(result.getInt("year"));

                expenses.add(expense);
            }
        }catch (SQLException ex){
            throw new RuntimeException("Error to get all expenses.");
        }finally {
            ConnectionFactory.closeConnection(connection, statement, result);
        }
        return expenses;
    }
}
