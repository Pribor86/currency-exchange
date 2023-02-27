package com.example.exchange.repository;

import com.example.exchange.model.FxData;

import java.util.List;

public interface FxDataRepository {
    List<FxData> saveAll(List<FxData> fxDataList);
}