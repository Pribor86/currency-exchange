package com.example.exchange.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
public class CcyAmt {
    @JacksonXmlProperty(localName = "Ccy")
    private String ccy;

    @JacksonXmlProperty(localName = "Amt")
    private String amt;

    public CcyAmt() {
    }

    public CcyAmt(String ccy, String amt) {
        this.ccy = ccy;
        this.amt = amt;
    }

    // getters and setters
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }
}
