package com.currencyexchange.service.impl;

import com.currencyexchange.dto.ExchangeRequestDto;
import com.currencyexchange.dto.Response;
import com.currencyexchange.dto.ResponseFactory;
import com.currencyexchange.exception.IncorrectCurrencyException;
import com.currencyexchange.exception.UserNotFoundException;
import com.currencyexchange.model.Currency;
import com.currencyexchange.model.Exchange;
import com.currencyexchange.model.User;
import com.currencyexchange.repository.CurrencyRepository;
import com.currencyexchange.repository.ExchangeRepository;
import com.currencyexchange.repository.UserRepository;
import com.currencyexchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    @Value("${currency.api}")
    private String currencyApi;

    private final UserRepository userRepository;
    private final ExchangeRepository exchangeRepository;
    private final CurrencyRepository currencyRepository;

    @Autowired
    public ExchangeServiceImpl(UserRepository userRepository,
                               ExchangeRepository exchangeRepository,
                               CurrencyRepository currencyRepository) {
        this.userRepository = userRepository;
        this.exchangeRepository = exchangeRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Response exchange(ExchangeRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUser())
                .orElseThrow(() -> new UserNotFoundException("Пользователь с id " + requestDto.getUser() + " не найден"));

        String pair = requestDto.getBaseCurrency().toUpperCase() + "_" + requestDto.getTargetCurrency().toUpperCase();
        String ratesResponse = getRates(pair);

        if (ratesResponse.equals("")) {
            throw new IncorrectCurrencyException("Не верная валюта");
        }

        Exchange exchange = new Exchange();
        exchange.setUser(user);
        exchange.setAmount(new BigDecimal(requestDto.getAmount()));
        exchange.setBaseCurrency(getCurrency(requestDto.getBaseCurrency().toUpperCase()));
        exchange.setTargetCurrency(getCurrency(requestDto.getTargetCurrency().toUpperCase()));
        exchangeRepository.save(exchange);

        String[] rate = ratesResponse.split(":");

        BigDecimal result = new BigDecimal(rate[1]);
        result = result.multiply(new BigDecimal(requestDto.getAmount())).setScale(2, RoundingMode.HALF_EVEN);

        return ResponseFactory.getExchangeResponse(exchange.getId(), result.toString());
    }

    private String getRates(String pair) {
        String ratesResponse = "";
        try {
            URL url = new URL("https://free.currconv.com/api/v7/convert?q=" + pair + "&compact=ultra&apiKey=" + currencyApi);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            ratesResponse = br.readLine().replaceAll("[{}]", "");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratesResponse;
    }

    private Currency getCurrency(String name){
        Currency currency = currencyRepository.findByName(name).orElse(null);
        if (currency == null) {
            currency = new Currency();
            currency.setName(name);
            currencyRepository.save(currency);
        }

        return currency;
    }
}
