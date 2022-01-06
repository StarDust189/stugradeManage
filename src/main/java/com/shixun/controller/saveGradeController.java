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

public class saveGradeController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public ResultResponse SaveGrade(String courseNo, String courseName, int grade, String code) {
        Achievement achievement = new Achievement(courseNo, courseName, grade, code);
        ResultResponse resultResponse = userService.saveGradeService(achievement);
        return resultResponse;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String courseNo = req.getParameter("courseNo");
        String courseName = req.getParameter("courseName");
        int grade = Integer.parseInt(req.getParameter("grade"));
        String code = req.getParameter("code");
        ResultResponse resultResponse = SaveGrade(courseNo, courseName, grade, code);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
    }
}
