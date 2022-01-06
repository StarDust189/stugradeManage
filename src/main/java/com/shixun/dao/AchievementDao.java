package com.shixun.dao;

import com.shixun.entity.Achievement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AchievementDao {
    public Achievement findByCourseName(String courseName) throws SQLException, IOException, ClassNotFoundException;

    public int saveGrade(Achievement achievement) throws SQLException, IOException, ClassNotFoundException;

    public int deleteGrade(String courseName, String code) throws SQLException, IOException, ClassNotFoundException;

    public int updateGrade(Achievement achievement) throws SQLException, IOException, ClassNotFoundException;

    public List<Achievement> getGrades(String code) throws SQLException, IOException, ClassNotFoundException;
}
