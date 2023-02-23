package com.example.exchange.service;

import com.example.exchange.model.CurrencyType;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;

import java.util.List;
import java.util.Optional;

public interface CcyService {
    CurrencyTypeResponse saveAll(List<CurrencyTypeRequest> currencyTypeRequests);
    CurrencyTypeResponse deleteAll();
    List<CurrencyType> findAll();
    Optional<CurrencyType> getCurrencyType(String ccy);
    CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests);

}
