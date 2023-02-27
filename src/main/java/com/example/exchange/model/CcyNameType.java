package com.example.exchange.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

@XmlRootElement(name = "CcyNtry")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
public class CcyNameType {
    @XmlElement(name = "Ccy")
    private String ccy;
    @XmlElement(name = "CcyNbr")
    private String ccyNbr;
    @XmlElement(name = "CcyMnrUnts")
    private String ccyMnrUnts;

}
