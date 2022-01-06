package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.shixun.entity.User;
import com.shixun.service.UserService;
import com.shixun.service.impl.UserServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getUserListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserServiceImpl();
        try {
            List<User> userList = userService.getUserList();
            PrintWriter out = resp.getWriter();
            String jsonStr = JSON.toJSONString(userList);
            out.println(jsonStr);
            System.out.println(jsonStr);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }


    }
}
