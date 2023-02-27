package com.example.exchange.repository;

import com.example.exchange.model.CcyName;
import com.example.exchange.model.FxData;
import com.example.exchange.model.dao.CurrencyTypeRequest;
import com.example.exchange.model.dao.CurrencyTypeResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CcyRepositoryImpl implements CcyRepository {

//    private final NamedParameterJdbcOperations jdbcOperations;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void saveAll(List<FxData> fxData) {
//hibernate.cfg.xm


        for (FxData fx : fxData) {
            jdbcTemplate.update(
                    "INSERT INTO CURRENCY (id, type_name, curr_date, currency, amount) VALUES (:id, :type_name, :curr_date, :currency, :amount)",
                    Map.of(
                            "id", fx.getId(),
                            "type_name", fx.getType_name(),
                            "curr_date", fx.getCurr_date(),
                            "currency", fx.getCurrency(),
                            "amount", fx.getAmount()
                    )
            );
        }

//        String sql = "INSERT INTO CURRENCY (id, type_name, curr_date, currency, amount) VALUES (?, ?, ?, ?, ?)";
//        String sql = "INSERT INTO CURRENCY (id, type_name, curr_date, currency, amount) VALUES (?, ?, ?, ?, ?)";
//        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps, int i) throws SQLException {
//                ps.setString(1, fxData.get(i).getId());
//                ps.setString(2, fxData.get(i).getType_name());
//                ps.setString(3, fxData.get(i).getCurr_date());
//                ps.setString(4, fxData.get(i).getCurrency());
//                ps.setFloat(5, fxData.get(i).getAmount());
//            }
//
//            @Override
//            public int getBatchSize() {
//                return fxData.size();
//            }
//        });
        System.out.println("Currencies: " + fxData.toString());
        log.info("Saving all currencies");
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all currencies");
    }

    @Override
    public List<FxData> findAll(String ccy) {
        log.info("Finding all currencies");
       return jdbcTemplate.query(
                    "SELECT * FROM CURRENCY WHERE currency LIKE :currency",
                    Map.of(
                            "currency",
                            '%' + ccy + '%'
                    ), (rs, rowNum) -> new FxData(
                            rs.getInt("id"),
                            rs.getString("type_name"),
                            rs.getString("curr_date"),
                            rs.getString("currency"),
                            rs.getBigDecimal("amount")
                    )
            );
    }

    @Override
    public List<FxData> getCurrencyType(String ccy) {
        log.info("Finding currency by ccy: {}", ccy);
//        Date currentDate = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String formattedDate = dateFormat.format(currentDate);
//        System.out.println("Formatted date: " + formattedDate + " " + ccy);
        String formattedDate = "2023-02-23";


        return jdbcTemplate.query(
                       "SELECT * FROM CURRENCY WHERE CURR_DATE = :date and currency LIKE :currency",
                          Map.of(
                                    "date",
                                    formattedDate,
                                    "currency",
                                    '%' + ccy + '%'

                          ), (rs, rowNum) -> new FxData(
                                  rs.getInt("id"),
                                 rs.getString("type_name"),
                                 rs.getString("curr_date"),
                                 rs.getString("currency"),
                                 rs.getBigDecimal("amount")
                          )
                    );
    }

    @Override
    public List<CcyName> getCurrencies() {
        log.info("Finding all currencies");
        return jdbcTemplate.query(
                "SELECT DISTINCT currency FROM CURRENCY",
                (rs, rowNum) -> new CcyName(
                        rs.getString("currency")
                )
        );
    }

    @Override
    public CurrencyTypeResponse updateAll(List<CurrencyTypeRequest> currencyTypeRequests) {
        log.info("Updating all currencies");
        return null;
    }
}
