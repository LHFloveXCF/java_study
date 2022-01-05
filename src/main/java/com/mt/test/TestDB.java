package com.mt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * java_study
 */
public class TestDB {
    private static final String url = "jdbc:mysql://127.0.0.1/study?useSSL=false&useUnicode=true&characterEncoding=utf-8";
    private static final String user = "root";
    private static final String password = "123456";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "insert into s1 values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i=1; i<10; i++) {
                preparedStatement.setString(1, i + "");
                preparedStatement.setString(2, i + "");
                preparedStatement.setString(3, i + "");
                preparedStatement.setInt(4, i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
