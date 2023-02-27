package com.example.exchange.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

import java.util.List;

@XmlRootElement(name = "FxRates")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class FxRates {
    @XmlElement(name = "FxRate")
    private List<FxRate> fxRates;

    @Override
    public String toString() {
        return "FxRates{" +
                "fxRates=" + fxRates +
                '}';
    }
}
