package com.dandinglong.experiment.dto;

import javax.persistence.Id;

public class MaGujieInitData {
    @Id
    private int id;
    private int classId;
    private double midu;
    private double hanshuiliang;
    private double chushigaodu;
    private double tulibizhong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public double getMidu() {
        return midu;
    }

    public void setMidu(double midu) {
        this.midu = midu;
    }

    public double getHanshuiliang() {
        return hanshuiliang;
    }

    public void setHanshuiliang(double hanshuiliang) {
        this.hanshuiliang = hanshuiliang;
    }

    public double getChushigaodu() {
        return chushigaodu;
    }

    public void setChushigaodu(double chushigaodu) {
        this.chushigaodu = chushigaodu;
    }

    public double getTulibizhong() {
        return tulibizhong;
    }

    public void setTulibizhong(double tulibizhong) {
        this.tulibizhong = tulibizhong;
    }
}
