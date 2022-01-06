package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.shixun.entity.Achievement;
import com.shixun.response.ResultResponse;
import com.shixun.service.UserService;
import com.shixun.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class updateGradeController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public ResultResponse UpdateUser(Achievement achievement) {
        ResultResponse resultResponse = userService.updateGradeService(achievement);
        return resultResponse;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String courseNo = req.getParameter("courseNo");
        String courseName = req.getParameter("courseName");
        String code = req.getParameter("code");
        int grade = Integer.parseInt(req.getParameter("grade"));
        Achievement achievement = new Achievement(courseNo, courseName, grade, code);
        ResultResponse resultResponse = UpdateUser(achievement);
        System.out.println(resultResponse);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
    }
}
