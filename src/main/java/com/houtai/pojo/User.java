package com.houtai.pojo;

public class User{

    private Integer id;
    public String username;
    private String password;
    public String vercode;
    public String grade;
    public String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getVercode() {
        return vercode;
    }
    public void setVercode(String vercode) {
        this.vercode = vercode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vercode='" + vercode + '\'' +
                ", grade='" + grade + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
