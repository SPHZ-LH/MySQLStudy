package com.sphz.lesson01;


import java.sql.*;

// 我的第一个JDBC程序
public class JdbcFirstDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 固定写法，加载驱动

        // 2.用户信息与url
        //useUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://localhost:3306/smbms?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "sphz0361";

        // 3.连接成功，数据库对象 connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        // 4.执行SQL的对象 Statement 执行sql的对象
        Statement statement = connection.createStatement();

        // 5.执行SQL的对象,可能存在结果，查看返回结果
        String sql = "select * from smbms_user";

        ResultSet resultSet = statement.executeQuery(sql);// 返回的结果集,结果集中封装了我们全部的查询出来的结果

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

        // 6.释放资源
        resultSet.close();
        statement.close();
        connection.close();

    }
}
