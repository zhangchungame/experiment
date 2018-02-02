package com.dandinglong.experiment.dto;

import javax.persistence.Id;

public class MaStudent {
    @Id
    private int id;
    private String studentNo;
    private String name;
    private String password;
    private int banjiId;
    private String graduation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBanjiId() {
        return banjiId;
    }

    public void setBanjiId(int banjiId) {
        this.banjiId = banjiId;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }
}
