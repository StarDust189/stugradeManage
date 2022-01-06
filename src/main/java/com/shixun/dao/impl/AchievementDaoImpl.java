package com.shixun.dao.impl;

import com.shixun.dao.AchievementDao;
import com.shixun.entity.Achievement;
import com.shixun.entity.User;
import com.shixun.util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AchievementDaoImpl implements AchievementDao {

    @Override
    public Achievement findByCourseName(String courseName) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "select * from achievement where courseName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, courseName);
        ResultSet resultSet = preparedStatement.executeQuery();
        Achievement achievement = null;
        if (resultSet.next()) {
            String courseNo = resultSet.getString("courseNo");
            String courseName1 = resultSet.getString("courseName");
            int grade = resultSet.getInt("grade");
            String code = resultSet.getString("code");
            achievement = new Achievement(courseNo, courseName1, grade, code);
        }
        DBUtil.closeConnect(connection);
        return achievement;
    }

    @Override
    public int saveGrade(Achievement achievement) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "insert into "
                + "achievement "
                + "(courseNo,courseName,grade,code) "
                + "values"
                + "(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, achievement.getCourseNo());
        preparedStatement.setString(2, achievement.getCourseName());
        preparedStatement.setInt(3, achievement.getGrade());
        preparedStatement.setString(4, achievement.getCode());
        int n = preparedStatement.executeUpdate();
        DBUtil.closeConnect(connection);
        return n;
    }

    @Override
    public int deleteGrade(String courseName, String code) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "delete from achievement where code = ? and courseName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, code);
        preparedStatement.setString(2, courseName);
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public int updateGrade(Achievement achievement) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "update achievement set grade = ? where code = ? and courseNo = ? and courseName = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, achievement.getGrade());
        preparedStatement.setString(2, achievement.getCode());
        preparedStatement.setString(3, achievement.getCourseNo());
        preparedStatement.setString(4, achievement.getCourseName());
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public List<Achievement> getGrades(String code) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        ResultSet resultSet = null;
        List<Achievement> achievementList = new ArrayList<Achievement>();
        String sql = "select courseNo, courseName, grade, code from achievement where code = ?";
        List<Object> objectList = new ArrayList<Object>();
        Object[] params = objectList.toArray();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, code);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Achievement achievement = new Achievement();
            achievement.setCourseNo(resultSet.getString("courseNo"));
            achievement.setCourseName(resultSet.getString("courseName"));
            achievement.setGrade(resultSet.getInt("grade"));
            achievement.setCode(resultSet.getString("code"));
            achievementList.add(achievement);
        }
        DBUtil.closeConnect(connection);
        return achievementList;
    }
}
