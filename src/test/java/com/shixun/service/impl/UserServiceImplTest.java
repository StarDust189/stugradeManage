package com.shixun.service.impl;

import com.shixun.entity.User;
import com.shixun.response.ResultResponse;
import com.shixun.service.UserService;
import junit.framework.TestCase;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImplTest extends TestCase {

    public void testLoginService() {
        User user = new User();
        user.setCode("admin");
        user.setGrade(1);
        user.setPassword("123456");
        System.out.println(user);
        UserService userService = new UserServiceImpl();
        ResultResponse n = userService.loginService(user);
        System.out.println(n);
    }

    public void testGetUserList() throws SQLException {
        List<User> userList = null;
        UserService userService = new UserServiceImpl();
        userList = userService.getUserList();
        System.out.println(userList);
    }

    public void testFindByCourseName() {
        UserService userService = new UserServiceImpl();
        String courseName = "数学";
        ResultResponse n = userService.findByCourseNameServices(courseName);
        System.out.println(n);
    }
}