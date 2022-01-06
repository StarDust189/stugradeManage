package com.shixun.util;

import junit.framework.TestCase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtilTest extends TestCase {

    public void testGetConnect() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DBUtil.getConnect();
        System.out.println(connection);
        DBUtil.closeConnect(connection);
        System.out.println("关闭数据库成功。");

    }

    public void testCloseConnect() {

    }
}