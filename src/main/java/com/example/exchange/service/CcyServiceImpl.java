package com.example.exchange.service;

import com.example.exchange.model.CurrencyType;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CcyServiceImpl implements CcyService{

    @Override
    public CurrencyTypeResponse saveAll(List<CurrencyTypeRequest> currencyTypeRequests) {
        log.info("CurrencyTypeService saveAll");
        return null;
    }

    @Override
    public CurrencyTypeResponse deleteAll() {
        log.info("CurrencyTypeService deleteAll");
        return null;
    }

    @Override
    public List<CurrencyType> findAll() {
        log.info("CurrencyTypeService findAll");
        return null;
    }

    @Override
    public Optional<CurrencyType> getCurrencyType(String ccy) {
        log.info("CurrencyTypeService getCurrencyType");
        return Optional.empty();
    }

    @Override
    public CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests) {
        log.info("CurrencyTypeService updateAll");
        return null;
    }
}
