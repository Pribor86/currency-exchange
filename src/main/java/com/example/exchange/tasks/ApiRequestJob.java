package com.example.exchange.tasks;


import com.example.exchange.model.*;
import com.example.exchange.repository.FxDataRepository;
import com.example.exchange.repository.FxDataRepositoryImpl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.web.client.RestTemplate;

import java.io.StringReader;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ApiRequestJob implements Job {
    private final RestTemplate restTemplate = new RestTemplate();

    private final FxDataRepository fxDataRepository = new FxDataRepositoryImpl();

    @Override
    public void execute(JobExecutionContext context) {
        //TODO find right solution for getting data from API by each currency and store all history data in DB
        //temporary solution to get everything working
        String ccyNamesList = restTemplate.getForObject("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrencyList?", String.class);

        CcyNameTypes ccyNameTypes = removeXMLNamespaceCcyNameTypes(ccyNamesList);
        List<CcyNameType> ccyNameTypeList = ccyNameTypes.getCcyNameTypes();

        List<CcyName> ccyNameList = ccyNameTypeList.stream().map(it -> {
            CcyName ccyName = new CcyName();
            ccyName.setCcy(it.getCcy());
            return ccyName;
        }).toList();

        ccyNameList.forEach(System.out::println);


        String res = restTemplate.getForObject("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=AUD&dtFrom=2022-01-01&dtTo=2023-01-01", String.class);
//      String result = restTemplate.getForObject("http://www.lb.lt/webservices/FxRates/FxRates.asmx/getCurrentFxRates?tp=EU", String.class);

         FxRates fxRates = removeXMLNamespaceFxRates(res);

         List<FxRate> fxRates1 = fxRates.getFxRates();

         List<FxData> test1 = fxRates1.stream().map(it -> {

                        FxData fx = new FxData();
                        fx.setType_name(it.getTp());
                        fx.setCurr_date(it.getDate());
                        fx.setCurrency(it.getCcyAmts().get(1).getCurrency());
                        fx.setAmount(it.getCcyAmts().get(1).getAmount());
                        return fx;
                    }

        ).toList();
        try {
            fxDataRepository.saveAll(test1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private FxRates removeXMLNamespaceFxRates(final String xml) {
        String removable = " xmlns=\"http://www.lb.lt/WebServices/FxRates\"";
        JAXBContext jaxbContext = JAXBContext.newInstance(FxRates.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (FxRates) jaxbUnmarshaller.unmarshal(new StringReader(xml.replaceAll(removable, "")));
    }

    @SneakyThrows
    private CcyNameTypes removeXMLNamespaceCcyNameTypes(final String xml) {
        String removable = " xmlns=\"http://www.lb.lt/WebServices/FxRates\"";
        JAXBContext jaxbContext = JAXBContext.newInstance(CcyNameTypes.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        return (CcyNameTypes) jaxbUnmarshaller.unmarshal(new StringReader(xml.replaceAll(removable, "")));
    }
}
