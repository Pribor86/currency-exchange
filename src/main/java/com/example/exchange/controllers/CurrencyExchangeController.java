package com.example.exchange.controllers;

import com.example.exchange.model.CurrencyType;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;
import com.example.exchange.service.CcyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exchange")
public class CurrencyExchangeController {

    private final CcyService ccyService;

    @PostMapping("/save-all")
    CurrencyTypeResponse saveAll(@RequestBody List<CurrencyTypeRequest> currencyTypeRequests) {
        return ccyService.saveAll(currencyTypeRequests);
    }

    @PostMapping("/delete-all")
    public void deleteAll() {
        ccyService.deleteAll();
    }

    @GetMapping("/get-all")
    List<CurrencyType> getAll() {
        List<CurrencyType> ccyList = ccyService.findAll();
        return ccyList;
    }

    @GetMapping("/get/{ccy}")
    public void getCurrencyType(@PathVariable String ccy) {
        ccyService.getCurrencyType(ccy);
    }

    @PostMapping("/update-all")
    public void updateAll(@RequestBody List<CurrencyTypeRequest> currencyTypeRequests) {
        ccyService.updateAll(currencyTypeRequests);
    }
}
