package com.sphz.lesson02;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql = "insert into smbms_role ( roleCode, roleName ) values ( 'djaskl', 'djals' )";

            int i = statement.executeUpdate(sql);

            if (i > 0) {
                System.out.println("添加成功");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
}
