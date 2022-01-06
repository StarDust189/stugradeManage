package com.shixun.dao.impl;

import com.shixun.entity.Achievement;
import com.shixun.entity.User;
import junit.framework.TestCase;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Year;
import java.util.List;

public class AchievementDaoImplTest extends TestCase {

    public void testFindByCourseName() {


    }

    public void testSaveGrade() throws SQLException, IOException, ClassNotFoundException {
        Achievement achievement = new Achievement();
        achievement.setCourseNo("2");
        achievement.setCourseName("数学");
        achievement.setGrade(50);
        achievement.setCode("cobra");
        //System.out.println(achievement);
        AchievementDaoImpl achievementDao = new AchievementDaoImpl();
        int n = achievementDao.saveGrade(achievement);
        System.out.println(n);

    }

    public void testDeleteGrade() throws SQLException, IOException, ClassNotFoundException {
        AchievementDaoImpl achievementDao = new AchievementDaoImpl();
        int achievement = achievementDao.deleteGrade("语文", "cobra");
        System.out.println(achievement);

    }

    public void testUpdateGrade() throws SQLException, IOException, ClassNotFoundException {
        Achievement achievement = new Achievement();

        achievement.setGrade(100);
        achievement.setCourseNo("1");
        achievement.setCourseName("数学");
        achievement.setCode("11454");
//        System.out.println(achievement);
        AchievementDaoImpl achievementDao = new AchievementDaoImpl();
        int n = achievementDao.updateGrade(achievement);
        System.out.println(n);


    }

    public void testGetGrades() throws SQLException, IOException, ClassNotFoundException {
        String code = "11454";
        AchievementDaoImpl achievementDao = new AchievementDaoImpl();
        List<Achievement> achievementList = achievementDao.getGrades(code);
        System.out.println(achievementList);
    }
}