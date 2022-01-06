package com.shixun.dao;

import com.shixun.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public User loginUser(String code, String password, int grade) throws SQLException, IOException, ClassNotFoundException;

    public User findByName(String name) throws SQLException, IOException, ClassNotFoundException;

    public int saveUser(User user) throws SQLException, IOException, ClassNotFoundException;

    public int deleteUser(String code) throws SQLException, IOException, ClassNotFoundException;

    /**
     * 修改用户的密码
     *
     * @param code
     * @param password
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int updateUser(String code, String password) throws SQLException, IOException, ClassNotFoundException;

    public List<User> getUserList() throws SQLException, IOException, ClassNotFoundException;
}
