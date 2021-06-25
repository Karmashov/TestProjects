package com.currencyexchange.controller;

import com.currencyexchange.dto.ExchangeRequestDto;
import com.currencyexchange.service.ExchangeService;
import com.currencyexchange.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DefaultController {

    private final ExchangeService exchangeService;
    private final StatisticsService statisticsService;

    @Autowired
    public DefaultController(ExchangeService exchangeService,
                             StatisticsService statisticsService) {
        this.exchangeService = exchangeService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/exchange")
    public ResponseEntity<?> exchange(@RequestBody ExchangeRequestDto requestDto) {
        return ResponseEntity.ok(exchangeService.exchange(requestDto));
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStatistics(@RequestParam String mode) {
        return ResponseEntity.ok(statisticsService.getStatistics(mode));
    }
}
