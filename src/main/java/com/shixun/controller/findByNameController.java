package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.shixun.response.ResultResponse;
import com.shixun.service.UserService;
import com.shixun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class findByNameController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public ResultResponse FindByName(String name) {
        ResultResponse resultResponse = userService.findByNameServices(name);

        return resultResponse;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserServiceImpl();
        String name = req.getParameter("name");

        ResultResponse resultResponse = FindByName(name);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
        System.out.println(jsonStr);
    }
}
