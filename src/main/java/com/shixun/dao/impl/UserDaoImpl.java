package com.shixun.dao.impl;

import com.shixun.dao.UserDao;
import com.shixun.entity.User;
import com.shixun.util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User loginUser(String code, String password, int grade) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "select * from user where code = ? and password = ? and grade = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, code);
        preparedStatement.setString(2, password);
        preparedStatement.setInt(3, grade);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String code1 = resultSet.getString("code");
            String name = resultSet.getString("name");
            String password1 = resultSet.getString("password");
            int grade1 = resultSet.getInt("grade");
            user = new User(id, code1, name, password1, grade);
        }
        DBUtil.closeConnect(connection);
        return user;
    }

    @Override
    public User findByName(String name) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "select * from user where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String user_code = resultSet.getString("code");
            String name1 = resultSet.getString("name");
            String password = resultSet.getString("password");
            int grade = resultSet.getInt("grade");
            user = new User(id, user_code, name1, password, grade);
        }
        DBUtil.closeConnect(connection);
        return user;
    }

    @Override
    public int saveUser(User user) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "insert into "
                + "user "
                + "(id,code,name,password,grade) "
                + "values"
                + "(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, user.getId());
        preparedStatement.setString(2, user.getCode());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setInt(5, user.getGrade());
        int n = preparedStatement.executeUpdate();
        DBUtil.closeConnect(connection);
        return n;
    }

    @Override
    public int deleteUser(String code) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "delete from user where code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, code);
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public int updateUser(String code, String password) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        String sql = "update user set password = ? where code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, code);
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException {
        Connection connection = DBUtil.getConnect();
        ResultSet resultSet = null;
        List<User> userList = new ArrayList<User>();
        String sql = "select * from user";
        List<Object> list = new ArrayList<Object>();
        Object[] params = list.toArray();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setCode(resultSet.getString("code"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setGrade(resultSet.getInt("grade"));
            userList.add(user);
        }
        DBUtil.closeConnect(connection);
        return userList;
    }
}
