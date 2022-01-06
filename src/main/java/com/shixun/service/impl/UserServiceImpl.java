package com.shixun.service.impl;

import com.shixun.dao.AchievementDao;
import com.shixun.dao.UserDao;
import com.shixun.dao.impl.AchievementDaoImpl;
import com.shixun.dao.impl.UserDaoImpl;
import com.shixun.entity.Achievement;
import com.shixun.entity.User;
import com.shixun.response.ResultResponse;
import com.shixun.service.UserService;
import com.shixun.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private AchievementDao achievementDao = new AchievementDaoImpl();

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
        achievementDao = new AchievementDaoImpl();
    }

    @Override
    public ResultResponse loginService(User user) {
        ResultResponse resultResponse = new ResultResponse();
        try {
            User user1 = userDao.loginUser(user.getCode(), user.getPassword(), user.getGrade());
            if (user1 != null) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("登陆成功");
                resultResponse.setObj(user);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("用户名或密码错误");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }

    }

    @Override
    public List<User> getUserList() throws SQLException {
        List<User> userList = null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnect();
            userList = userDao.getUserList();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBUtil.closeConnect(connection);
            return userList;
        }


    }

    @Override
    public ResultResponse saveUserService(User user) {
        ResultResponse resultResponse = new ResultResponse();
        try {
            int n = userDao.saveUser(user);
            if (n >= 1) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(user);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("失败");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }

    }

    @Override
    public ResultResponse deleteUserService(String code) {
        ResultResponse resultResponse = new ResultResponse();
        try {
            int n = userDao.deleteUser(code);
            if (n >= 1) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(code);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("失败");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }
    }

    @Override
    public ResultResponse updateUserServiceS(String code, String password) {

        ResultResponse resultResponse = new ResultResponse();
        try {
            int n = userDao.updateUser(code, password);
            if (n >= 1) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(n);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("失败");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }
    }

    @Override
    public ResultResponse findByNameServices(String name) {

        ResultResponse resultResponse = new ResultResponse();
        try {
            User n = userDao.findByName(name);
            if (n != null) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(n);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("不存在");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }
    }

    @Override
    public List<Achievement> getGrades(String code) throws SQLException {
        List<Achievement> achievementList = null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnect();
            achievementList = achievementDao.getGrades(code);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            DBUtil.closeConnect(connection);
            return achievementList;
        }


    }

    @Override
    public ResultResponse findByCourseNameServices(String courseName) {

        ResultResponse resultResponse = new ResultResponse();
        try {
            Achievement n = achievementDao.findByCourseName(courseName);
            if (n != null) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(n);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("不存在");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }
    }

    @Override
    public ResultResponse saveGradeService(Achievement achievement) {
        ResultResponse resultResponse = new ResultResponse();
        try {
            int n = achievementDao.saveGrade(achievement);
            if (n >= 1) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(achievement);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("失败");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }

    }

    @Override
    public ResultResponse deleteGradeService(String courseName, String code) {
        System.out.println(courseName);
        System.out.println(code);
        ResultResponse resultResponse = new ResultResponse();
        try {
            int n = achievementDao.deleteGrade(courseName, code);
            if (n >= 1) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(code);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("失败");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }
    }

    @Override
    public ResultResponse updateGradeService(Achievement achievement) {
        ResultResponse resultResponse = new ResultResponse();
        try {
            int n = achievementDao.updateGrade(achievement);
            if (n >= 1) {
                resultResponse.setStatusCode("200");
                resultResponse.setMsg("成功");
                resultResponse.setObj(n);
            } else {
                resultResponse.setStatusCode("300");
                resultResponse.setMsg("失败");
                resultResponse.setObj(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultResponse.setStatusCode("500");
            resultResponse.setMsg("系统错误");
            resultResponse.setObj(e);

        } finally {
            return resultResponse;

        }
    }
}
