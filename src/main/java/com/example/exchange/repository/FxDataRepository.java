package com.example.exchange.repository;

//import com.example.exchange.model.FxData;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface FxDataRepository extends CrudRepository<FxData, Long> {
//}


import com.example.exchange.model.FxData;

import java.util.List;

public interface FxDataRepository {
    List<FxData> saveAll(List<FxData> fxDataList);
}