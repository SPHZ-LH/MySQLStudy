package com.sphz.lesson03;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            String sql = "update student set id = 2 where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 1);
            int i = statement.executeUpdate();
            if (i > 0) {
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection,statement,resultSet);
        }
    }
}
