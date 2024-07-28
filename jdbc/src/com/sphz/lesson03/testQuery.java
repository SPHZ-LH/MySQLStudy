package com.sphz.lesson03;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testQuery {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            String sql = "select * from student where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,1);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
}
