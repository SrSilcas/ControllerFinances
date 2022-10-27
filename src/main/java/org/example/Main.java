package org.example;

import util.ConnectionFactory;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
        if (connection != null){
            System.out.println("Connection stabilize"+connection);
        }
        ConnectionFactory.closeConnection(connection);
    }
}