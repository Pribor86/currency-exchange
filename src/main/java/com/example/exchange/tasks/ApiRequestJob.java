package com.example.exchange.tasks;

import com.example.exchange.model.CcyAmt;
import com.example.exchange.model.FxRate;
import com.example.exchange.model.FxRates;
import com.example.exchange.repository.CcyRepositoryImpl;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ApiRequestJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=RUB&dtFrom=2022-01-01&dtTo=2023-01-01", String.class);
        System.out.println("result = " + result);

        //save the response to the database
        //parse response to a java object
        //save the object to the database
//        xmlToObject(result);


        CcyRepositoryImpl ccyRepository = new CcyRepositoryImpl();
        ccyRepository.saveAll(null);


    }

    private void xmlToObject(String xml) {
        //parse xml to java object
        XmlMapper xmlMapper = new XmlMapper();
        try {
            FxRates fxRates = xmlMapper.readValue(xml, FxRates.class);
            List<FxRate> fxRateList = fxRates.getFxRates();

            for (FxRate fxRate : fxRateList) {
                System.out.println("Tp: " + fxRate.getTp());
                System.out.println("Dt: " + fxRate.getDt());

                List<CcyAmt> ccyAmtList = fxRate.getCcyAmts();
                for (CcyAmt ccyAmt : ccyAmtList) {
                    System.out.println("Ccy: " + ccyAmt.getCcy());
                    System.out.println("Amt: " + ccyAmt.getAmt());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
