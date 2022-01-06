package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.shixun.response.ResultResponse;
import com.shixun.service.UserService;
import com.shixun.service.impl.UserServiceImpl;

import javax.print.DocFlavor;
import javax.print.attribute.standard.PresentationDirection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Savepoint;

public class updateUserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String code = req.getParameter("code");
        String password = req.getParameter("password");
        ResultResponse resultResponse = UpdateUser(code, password);
        System.out.println(resultResponse);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
    }

    public ResultResponse UpdateUser(String code, String password) {
        ResultResponse resultResponse = userService.updateUserServiceS(code, password);
        return resultResponse;
    }

}
