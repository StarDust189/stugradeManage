package com.shixun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class mysqlKeyUtil {
    public static String getProperValue(String key) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = mysqlKeyUtil.class.getClassLoader().getResourceAsStream("db.properties");
        properties.load(inputStream);
        String value = properties.getProperty(key);
        return value;
    }
}
