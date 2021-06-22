package com.currencyexchange.controller;

import com.currencyexchange.dto.ExchangeRequestDto;
import com.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DefaultController {

    private final ExchangeService exchangeService;

    @Autowired
    public DefaultController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/exhange")
    public ResponseEntity<?> exchange(@RequestBody ExchangeRequestDto requestDto) {
        return ResponseEntity.ok(exchangeService.exchange(requestDto));
    }
}
