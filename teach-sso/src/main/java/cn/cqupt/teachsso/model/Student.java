package cn.cqupt.teachsso.model;

import java.util.Date;

public class Student {
    private Integer studentId;

    private String studentNo;

    private String studentName;

    private String studentPswd;

    private String major;

    private String colledge;

    private String passed;

    private Double score;

    private Integer examTimes;

    private Date examTime;

    private Integer isCheated;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentPswd() {
        return studentPswd;
    }

    public void setStudentPswd(String studentPswd) {
        this.studentPswd = studentPswd == null ? null : studentPswd.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getColledge() {
        return colledge;
    }

    public void setColledge(String colledge) {
        this.colledge = colledge == null ? null : colledge.trim();
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed == null ? null : passed.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getExamTimes() {
        return examTimes;
    }

    public void setExamTimes(Integer examTimes) {
        this.examTimes = examTimes;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }

    public Integer getIsCheated() {
        return isCheated;
    }

    public void setIsCheated(Integer isCheated) {
        this.isCheated = isCheated;
    }
}