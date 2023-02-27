package com.example.exchange.tasks;

import com.example.exchange.repository.CcyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CcyRatesTaskImpl implements CcyRatesTask{

    @Autowired
    private CcyRepository ccyRepository;

    @Override
    public void getCcyRates() {
    }
}
