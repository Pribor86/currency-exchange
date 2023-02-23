package com.example.exchange.tasks;

import com.example.exchange.repository.CcyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
public class CcyRatesTaskImpl implements CcyRatesTask{

    @Autowired
    private CcyRepository ccyRepository;

    //run every 24 hours by quartz scheduler


    @Override
    public void getCcyRates() {

        //make a call to the external API with scheduled task
        //save the response to the database
        //if the response is not successful, log the error




    }
}
