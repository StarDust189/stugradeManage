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

public class UserLoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String code = req.getParameter("code");
//        System.out.println(code);
        String password = req.getParameter("password");
        int grade = Integer.parseInt(req.getParameter("grade"));
//        System.out.println(grade);
        ResultResponse resultResponse = UserLogin(code, password, grade);
        System.out.println(resultResponse);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
//        System.out.println(jsonStr);

    }

    public ResultResponse UserLogin(String code, String password, int grade) {
        User user = new User();
        user.setCode(code);
        user.setPassword(password);
        user.setGrade(grade);
//        System.out.println(user);
        ResultResponse resultResponse = userService.loginService(user);
        return resultResponse;

    }
}
