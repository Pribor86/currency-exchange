package com.example.exchange.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@JacksonXmlRootElement(localName = "FxRates")
public class FxRates {
    @JacksonXmlProperty(localName = "FxRate")
    private List<FxRate> fxRates;

    // getters and setters
    public List<FxRate> getFxRates() {
        return fxRates;
    }

    public void setFxRates(List<FxRate> fxRates) {
        this.fxRates = fxRates;
    }
}
