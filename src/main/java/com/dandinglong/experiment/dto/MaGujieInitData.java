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

    private double a12;
    private double cc;
    private double lambda;
    private double k;

    private double pce;
    private double pcyasuoxishu;
    private double pcyasuomoliang;
    private double pca12;
    private double pccc;
    private double pclambda;
    private double pck;

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

    public double getA12() {
        return a12;
    }

    public void setA12(double a12) {
        this.a12 = a12;
    }

    public double getCc() {
        return cc;
    }

    public void setCc(double cc) {
        this.cc = cc;
    }

    public double getLambda() {
        return lambda;
    }

    public void setLambda(double lambda) {
        this.lambda = lambda;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double getPce() {
        return pce;
    }

    public void setPce(double pce) {
        this.pce = pce;
    }

    public double getPcyasuoxishu() {
        return pcyasuoxishu;
    }

    public void setPcyasuoxishu(double pcyasuoxishu) {
        this.pcyasuoxishu = pcyasuoxishu;
    }

    public double getPcyasuomoliang() {
        return pcyasuomoliang;
    }

    public void setPcyasuomoliang(double pcyasuomoliang) {
        this.pcyasuomoliang = pcyasuomoliang;
    }

    public double getPca12() {
        return pca12;
    }

    public void setPca12(double pca12) {
        this.pca12 = pca12;
    }

    public double getPccc() {
        return pccc;
    }

    public void setPccc(double pccc) {
        this.pccc = pccc;
    }

    public double getPclambda() {
        return pclambda;
    }

    public void setPclambda(double pclambda) {
        this.pclambda = pclambda;
    }

    public double getPck() {
        return pck;
    }

    public void setPck(double pck) {
        this.pck = pck;
    }
}
