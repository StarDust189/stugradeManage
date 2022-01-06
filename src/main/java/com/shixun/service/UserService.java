package com.shixun.service;

import com.shixun.entity.Achievement;
import com.shixun.entity.User;
import com.shixun.response.ResultResponse;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public ResultResponse loginService(User user);

    public List<User> getUserList() throws SQLException;

    public ResultResponse saveUserService(User user);

    public ResultResponse deleteUserService(String code);

    public ResultResponse updateUserServiceS(String code, String password);

    public ResultResponse findByNameServices(String name);

    public List<Achievement> getGrades(String code) throws SQLException;

    public ResultResponse findByCourseNameServices(String courseName);

    public ResultResponse saveGradeService(Achievement achievement);

    public ResultResponse deleteGradeService(String courseName, String code);

    public ResultResponse updateGradeService(Achievement achievement);
}
