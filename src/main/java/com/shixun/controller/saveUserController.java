package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.shixun.entity.User;
import com.shixun.response.ResultResponse;
import com.shixun.service.UserService;
import com.shixun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class saveUserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public ResultResponse SaveUser(String code, String name, String password, int grade) {
        User user = new User();
        user.setCode(code);
        user.setName(name);
        user.setPassword(password);
        user.setGrade(grade);

        ResultResponse resultResponse = userService.saveUserService(user);
        return resultResponse;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int grade = Integer.parseInt(req.getParameter("grade"));
        ResultResponse resultResponse = SaveUser(code, name, password, grade);
        System.out.println(resultResponse);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
    }
}
