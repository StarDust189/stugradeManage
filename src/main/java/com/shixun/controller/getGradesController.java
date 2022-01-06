package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.shixun.entity.Achievement;
import com.shixun.service.UserService;
import com.shixun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class getGradesController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserServiceImpl();
        String code = req.getParameter("code");
        try {
            List<Achievement> achievementList = userService.getGrades(code);
            PrintWriter printWriter = resp.getWriter();
            String jsonStr = JSON.toJSONString(achievementList);
            printWriter.println(jsonStr);
            System.out.println(jsonStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
