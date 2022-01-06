package com.shixun.controller;

import com.alibaba.fastjson.JSON;
import com.oracle.net.Sdp;
import com.shixun.dao.impl.AchievementDaoImpl;
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

public class deleteGradeController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public ResultResponse DeleteGrade(String courseName, String code) {
        ResultResponse resultResponse = userService.deleteGradeService(courseName, code);
        return resultResponse;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String courseName = req.getParameter("courseName");
        String code = req.getParameter("code");
        ResultResponse resultResponse = DeleteGrade(courseName, code);
        System.out.println(resultResponse);
        PrintWriter printWriter = resp.getWriter();
        String jsonStr = JSON.toJSONString(resultResponse);
        printWriter.println(jsonStr);
    }
}
