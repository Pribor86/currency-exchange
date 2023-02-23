package com.example.exchange.model;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Value
@Data
public class CurrencyType {
    String ccy;
    String ccyNmLT;
    String ccyNmEN;
    String ccyNbr;
    String ccyMnrUnts;

}
