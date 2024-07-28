package com.sphz.lesson03;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testDelete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            // String sql = "delete from student where id = ?";
            String sql = "delete from student where id = 1";

            statement = connection.prepareStatement(sql);

            // statement.setInt(1, 2);

            int i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
}
