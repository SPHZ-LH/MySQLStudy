package com.sphz.lesson03;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();

            String sql = "insert into student(id,name) values(?,?)";
            statement = connection.prepareStatement(sql);

            statement.setInt(1, 1);
            statement.setString(2, "sphz");

            int i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("插入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
}
