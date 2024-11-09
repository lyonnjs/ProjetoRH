package org.example.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBase {
    private static final String URL = "jdbc:mysql://localhost:3306/db_rh";
    private static final String USER = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao conectar ao banco de dados");
            return null;
        }
    }
}

