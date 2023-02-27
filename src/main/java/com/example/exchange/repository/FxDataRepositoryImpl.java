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
        }

        return fxDataList;
    }
}





//import com.example.exchange.model.FxData;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Slf4j
//@RequiredArgsConstructor
//public class FxDataRepositoryImpl implements FxDataRepository{
//
//    @Override
//    public <S extends FxData> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends FxData> Iterable<S> saveAll(Iterable<S> entities) {
//        log.info("saveAll" + entities);
//        //push everything to db
//
//        return null;
//    }
//
//    @Override
//    public Optional<FxData> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public Iterable<FxData> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<FxData> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(FxData entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends FxData> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//}
