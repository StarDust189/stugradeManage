package com.shixun.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnect() throws ClassNotFoundException, SQLException, IOException {
        String driver = mysqlKeyUtil.getProperValue("driver");
        //加载驱动
        Class.forName(driver);
        //通过驱动获取连接

        String url = mysqlKeyUtil.getProperValue("url");
        String user = mysqlKeyUtil.getProperValue("user");
        String password = mysqlKeyUtil.getProperValue("password");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static void closeConnect(Connection connection) throws SQLException {
        connection.close();
    }
}
