package com.example.exchange.model.dao;

public record CurrencyTypeRequest(
        String ccy,
        String ccyNmLT,
        String ccyNmEN,
        String ccyNbr,
        String ccyMnrUnts
) {}
