package com.dandinglong.experiment.dto;

import javax.persistence.Id;
import java.util.Date;

public class MaGujie {
    @Id
    private int id;
    private String studentNo;
    private int step;
    private int status;
    private String kpaMmJson;
    private Date updateTime;

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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKpaMmJson() {
        return kpaMmJson;
    }

    public void setKpaMmJson(String kpaMmJson) {
        this.kpaMmJson = kpaMmJson;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
