package com.example.exchange.repository;

import com.example.exchange.model.FxData;
import com.example.exchange.util.DB;

import java.util.List;

public class FxDataRepositoryImpl implements FxDataRepository {

    @Override
    public List<FxData> saveAll(List<FxData> fxDataList) {
        try (var session = DB.getSessionFactory().openSession()) {
            var tx = session.beginTransaction();

            fxDataList.forEach(session::save);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fxDataList;
    }
}