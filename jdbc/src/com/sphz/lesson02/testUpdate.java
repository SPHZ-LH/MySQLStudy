package com.sphz.lesson02;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "update t_user set name = 'jack',birth = '2000-10-11' where id = 2;";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("修改成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
}
