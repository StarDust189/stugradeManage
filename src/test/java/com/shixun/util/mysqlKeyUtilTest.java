package com.shixun.util;

import junit.framework.TestCase;

import java.io.IOException;
import java.util.Properties;

public class mysqlKeyUtilTest extends TestCase {
    public void test() throws IOException {
        String value = mysqlKeyUtil.getProperValue("driver");
        System.out.println(value);
    }

}