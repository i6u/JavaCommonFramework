package com.witt.jdbc;

import java.sql.*;

public class JDBCConnection {

    /**
     *
     *     (1) 调用Class.forName()方法加载驱动程序。
     *
     * 　　(2) 调用DriverManager对象的getConnection()方法，获得一个Connection对象。
     *
     * 　　(3) 创建一个Statement对象，准备一个SQL语句，这个SQL语句可以是Statement对象（立即执行的的语句）、PreparedStatement语句（预编译的语句）或CallableStatement对象（存储过程调用的语句）。
     *
     * 　　(4) 调用excuteQuery()等方法执行SQL语句，并将结果保存在ResultSet对象；或者调用executeUpdate()等方法执行SQL语句，不返回ResultSet对象的结果。
     *
     * 　　(5)对返回的ResultSet对象进行显示等相当的处理。
     *
     * 　　(6)释放资源。
     *
     * */

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String NEW_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/api_server?useSSL=false&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "root";

    private Connection conn = null;
    private Statement stat = null;
    private ResultSet rs = null;

    public JDBCConnection() {
        getConnection();
    }

    private Connection getConnection() {

        try {
            Class.forName(NEW_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return conn;
    }

    public void update() {

    }

    public void query(String sql) {
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                this.conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
