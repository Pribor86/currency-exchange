package com.example.exchange.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CcyAmt")
@Getter
public class CcyAmt {
    @XmlElement(name = "Ccy")
    private String currency;

    @XmlElement(name = "Amt")
    private BigDecimal amount;
}
