package com.example.exchange.service;

import com.example.exchange.model.CcyName;
import com.example.exchange.model.FxData;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;

import java.util.List;

public interface CcyService {
    CurrencyTypeResponse deleteAll();

    List<FxData> findAll(String ccy);

    List<FxData> getCurrencyType(String ccy);

    List<CcyName> getCurrencies();

    CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests);

}
