package com.example.exchange.repository;

import com.example.exchange.model.CurrencyType;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;

import java.util.List;
import java.util.Optional;

public interface CcyRepository {
    void saveAll(List<CurrencyTypeRequest> currencyTypeRequests);
    void deleteAll();
    List<CurrencyTypeRequest> findAll();
    Optional<CurrencyType> getCurrencyType(String ccy);
    CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests);

}
