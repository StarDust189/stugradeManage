package com.shixun.entity;

import java.io.Serializable;

public class Achievement implements Serializable {
    private String courseNo;
    private String courseName;
    private int grade;
    private String code;

    public Achievement() {
    }

    public Achievement(String courseNo, String courseName, int grade, String code) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.grade = grade;
        this.code = code;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", grade=" + grade +
                ", code='" + code + '\'' +
                '}';
    }
}
