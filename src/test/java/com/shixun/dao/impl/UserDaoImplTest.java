package com.shixun.dao.impl;

import com.shixun.entity.User;
import junit.framework.TestCase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImplTest extends TestCase {

    public void testFindByCode() throws SQLException, IOException, ClassNotFoundException {
        UserDaoImpl user = new UserDaoImpl();
        User user1 = user.findByName("admin");
        System.out.println(user1);


    }

    public void testSaveUser() throws SQLException, IOException, ClassNotFoundException {

        User user = new User();

        user.setCode("11454");
        user.setName("野兽先辈");
        user.setPassword("1919");
        user.setGrade(2);
//        System.out.println(user);
        UserDaoImpl userDao = new UserDaoImpl();
        int n = userDao.saveUser(user);
        System.out.println(n);
    }

    public void testDeleteUser() {
    }

    public void testUpdateUser() {
    }

    public void testGetUserList() throws SQLException, IOException, ClassNotFoundException {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.getUserList();
        System.out.println(userList);
    }
}