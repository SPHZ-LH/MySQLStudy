package com.sphz.lesson02;

import com.sphz.lesson02.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();

            String sql = "select * from smbms_user";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("id=" + resultSet.getObject("id"));
                System.out.println("userCode=" + resultSet.getObject("userCode"));
                System.out.println("userName=" + resultSet.getObject("userName"));
                System.out.println("userPassword=" + resultSet.getObject("userPassword"));
                System.out.println("gender=" + resultSet.getObject("gender"));
                System.out.println("birthday=" + resultSet.getObject("birthday"));
                System.out.println("phone=" + resultSet.getObject("phone"));
                System.out.println("address=" + resultSet.getObject("address"));
                System.out.println("userRole=" + resultSet.getObject("userRole"));
                System.out.println("createdBy=" + resultSet.getObject("createdBy"));
                System.out.println("creationDate=" + resultSet.getObject("creationDate"));
                System.out.println("modifyBy=" + resultSet.getObject("modifyBy"));
                System.out.println("modifyDate=" + resultSet.getObject("modifyDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jdbcUtils.release(connection, statement, resultSet);
        }
    }
}
