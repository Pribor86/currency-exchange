package com.example.exchange.repository;

import com.example.exchange.model.CurrencyType;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CcyRepositoryImpl implements CcyRepository {

    @Override
    public void saveAll(List<CurrencyTypeRequest> currencyTypeRequests) {
        log.info("Saving all currencies");
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all currencies");
    }

    @Override
    public List<CurrencyTypeRequest> findAll() {
        log.info("Finding all currencies");
        return null;
    }

    @Override
    public Optional<CurrencyType> getCurrencyType(String ccy) {
        log.info("Finding currency by ccy: {}", ccy);
        return Optional.empty();
    }

    @Override
    public CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests) {
        log.info("Updating all currencies");
        return null;
    }
}
