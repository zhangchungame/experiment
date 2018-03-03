package com.dandinglong.experiment.dao;

import java.math.BigDecimal;

public class KpaAndMm {
    private BigDecimal kPa;
    private BigDecimal weiyimm;
    private BigDecimal mm;

    public BigDecimal getkPa() {
        return kPa;
    }

    public void setkPa(BigDecimal kPa) {
        this.kPa = kPa;
    }

    public BigDecimal getMm() {
        return mm;
    }

    public void setMm(BigDecimal mm) {
        this.mm = mm;
    }

    public BigDecimal getWeiyimm() {
        return weiyimm;
    }

    public void setWeiyimm(BigDecimal weiyimm) {
        this.weiyimm = weiyimm;
    }
}
