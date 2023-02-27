package com.example.exchange.service;

import com.example.exchange.model.CcyName;
import com.example.exchange.model.FxData;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;

import com.example.exchange.repository.CcyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CcyServiceImpl implements CcyService {

    private final CcyRepository ccyRepository;

    @Override
    public CurrencyTypeResponse deleteAll() {
        log.info("CurrencyTypeService deleteAll");
        return null;
    }

    @Override
    public List<FxData> findAll(String ccy) {
        log.info("CurrencyTypeService findAll");
        try {
            return ccyRepository.findAll(ccy);
        } catch (Exception e) {
            log.error("CurrencyTypeService findAll error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<FxData> getCurrencyType(String ccy) {
        log.info("CurrencyTypeService getCurrencyType" + ccy);
        try {
            return ccyRepository.getCurrencyType(ccy);
        } catch (Exception e) {
            log.error("CurrencyTypeService getCurrencyType error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<CcyName> getCurrencies() {
        log.info("CurrencyTypeService getCurrencies");
        try {
            return ccyRepository.getCurrencies();
        } catch (Exception e) {
            log.error("CurrencyTypeService getCurrencies error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests) {
        log.info("CurrencyTypeService updateAll");
        return null;
    }
}
