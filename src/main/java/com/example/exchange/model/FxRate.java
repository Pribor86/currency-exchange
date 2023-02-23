package com.example.exchange.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
public class FxRate {
    @JacksonXmlProperty(localName = "Tp")
    private String tp;

    @JacksonXmlProperty(localName = "Dt")
    private String dt;

    @JacksonXmlProperty(localName = "CcyAmt")
    private List<CcyAmt> ccyAmts;

    public FxRate() {
    }

    public FxRate(String tp, String dt, List<CcyAmt> ccyAmts) {
        this.tp = tp;
        this.dt = dt;
        this.ccyAmts = ccyAmts;
    }

    // getters and setters
    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public List<CcyAmt> getCcyAmts() {
        return ccyAmts;
    }

    public void setCcyAmts(List<CcyAmt> ccyAmts) {
        this.ccyAmts = ccyAmts;
    }

}
