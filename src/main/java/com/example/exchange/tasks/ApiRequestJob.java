package com.example.exchange.tasks;


import com.example.exchange.model.CcyAmt;
import com.example.exchange.model.FxData;
import com.example.exchange.model.FxRate;
import com.example.exchange.model.FxRates;
import com.example.exchange.repository.CcyRepository;
import com.example.exchange.repository.CcyRepositoryImpl;
import com.example.exchange.repository.FxDataRepository;
import com.example.exchange.repository.FxDataRepositoryImpl;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class ApiRequestJob implements Job {
    private final RestTemplate restTemplate = new RestTemplate();

    private final FxDataRepository fxDataRepository = new FxDataRepositoryImpl();

//    private final CcyRepository ccyRepository = new CcyRepositoryImpl(
//            new NamedParameterJdbcTemplate(new JdbcTemplate())
//    );

    @Override
    public void execute(JobExecutionContext context) {
        String res = restTemplate.getForObject("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=AUD&dtFrom=2022-01-01&dtTo=2023-01-01", String.class);
//        String result = restTemplate.getForObject("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU", String.class);

         FxRates fxRates = removeXMLNamespace(res);

         List<FxRate> fxRates1 = fxRates.getFxRates();

         List<FxData> test1 = fxRates1.stream().map(it -> {

//                        String id = UUID.randomUUID().toString();

                        FxData fx = new FxData();
                        fx.setType_name(it.getTp());
                        fx.setCurr_date(it.getDate());
                        fx.setCurrency(it.getCcyAmts().get(1).getCurrency());
                        fx.setAmount(it.getCcyAmts().get(1).getAmount());
                        return fx;
                    }

        ).toList();


//        final List<FxData> test = fxRates1.stream().map(it -> {
//
//                    FxRate fx = new FxRate();
//                    fx.setTp(it.getTp());
//                    fx.setDate(it.getDate());
//                    fx.setCcyAmts(listOf(it.getCcyAmts().remove(1)));
//                    return fx;
//                }
//        ).toList();

//        try {
//            CcyRepositoryImpl ccyRepository = new CcyRepositoryImpl(
//                    new NamedParameterJdbcTemplate(new JdbcTemplate())
//            );
//            ccyRepository.saveAll(test1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        try {
//            for (FxData fxData : test1) {
//                System.out.println(fxData);
//                fxDataRepository.save(fxData);
//            }

            fxDataRepository.saveAll(test1);


//            fxDataRepository.saveAll(test1);
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void xmlToObject(String xml) {
        //parse xml to java object
        XmlMapper xmlMapper = new XmlMapper();
        try {
            FxRates fxRates = xmlMapper.readValue(xml, FxRates.class);
            List<FxRate> fxRateList = fxRates.getFxRates();

            for (FxRate fxRate : fxRateList) {
                System.out.println("Tp: " + fxRate.getTp());
                System.out.println("Dt: " + fxRate.getDate());

                List<CcyAmt> ccyAmtList = fxRate.getCcyAmts();
                for (CcyAmt ccyAmt : ccyAmtList) {
                    System.out.println("Ccy: " + ccyAmt.getCurrency());
                    System.out.println("Amt: " + ccyAmt.getAmount());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Method to remove xml namespace
    @SneakyThrows
    private FxRates removeXMLNamespace(final String xml) {
        String removable = " xmlns=\"http://www.lb.lt/WebServices/FxRates\"";
        JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (FxRates) jaxbUnmarshaller.unmarshal(new StringReader(xml.replaceAll(removable, "")));
    }
}
