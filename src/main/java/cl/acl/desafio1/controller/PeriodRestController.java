package cl.acl.desafio1.controller;

import cl.acl.desafio1.model.PeriodModel;
import cl.acl.desafio1.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Period;

@RequestMapping(value = "/api")
@RestController


public class PeriodRestController {

    //url del servicio definida en properties
    @Value("${consumer.url.service}")
    private String urlService;

    @Autowired
    private PeriodService periodService;

    @RequestMapping(value = "periodos", method = RequestMethod.POST, produces = "application/json")


    public PeriodModel index(@RequestBody PeriodModel model){
        return periodService.findDates(model);
    }
}

