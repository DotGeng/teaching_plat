package cn.cqupt.teachsso.model;

public class Teacher {
    private Integer teacherId;

    private String teacherName;

    private String teacherPswd;

    private String teacherRole;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherPswd() {
        return teacherPswd;
    }

    public void setTeacherPswd(String teacherPswd) {
        this.teacherPswd = teacherPswd == null ? null : teacherPswd.trim();
    }

    public String getTeacherRole() {
        return teacherRole;
    }

    public void setTeacherRole(String teacherRole) {
        this.teacherRole = teacherRole == null ? null : teacherRole.trim();
    }
}