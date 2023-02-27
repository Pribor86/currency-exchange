package com.example.exchange.controllers;

import com.example.exchange.model.CcyName;
import com.example.exchange.model.FxData;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.service.CcyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class CurrencyExchangeController {

    private final CcyService ccyService;

    @PostMapping("/delete-all")
    public void deleteAll() {
        ccyService.deleteAll();
    }

    @GetMapping("/get-all/{ccy}")
    List<FxData> getAll(@PathVariable String ccy) {
        List<FxData> ccyList = ccyService.findAll(ccy);
        return ccyList;
    }

    @GetMapping("/get/{ccy}")
    List<FxData> getCurrencyType(@PathVariable String ccy) {
     List<FxData> ccyList = ccyService.getCurrencyType(ccy);
     return ccyList;
    }

    @GetMapping("/get-currencies")
    List<CcyName> getCurrencies() {
        List<CcyName> ccyList = ccyService.getCurrencies();
        return ccyList;
    }

    @PostMapping("/update-all")
    public void updateAll(@RequestBody List<CurrencyTypeRequest> currencyTypeRequests) {
        ccyService.updateAll(currencyTypeRequests);
    }
}
