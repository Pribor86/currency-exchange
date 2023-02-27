package com.example.exchange.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@XmlRootElement(name = "FxRate")
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class FxRate {

    @XmlElement(name = "Tp")
    private String tp;

    @XmlElement(name = "Dt")
    private String date;

    @XmlElement(name = "CcyAmt")
    private List<CcyAmt> ccyAmts;
}
