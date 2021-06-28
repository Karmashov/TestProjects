package com.currencyexchange.service.impl;

import com.currencyexchange.dto.Response;
import com.currencyexchange.dto.StatisticResponseFactory;
import com.currencyexchange.exception.IncorrectCurrencyException;
import com.currencyexchange.model.Exchange;
import com.currencyexchange.repository.CurrencyRepository;
import com.currencyexchange.repository.ExchangeRepository;
import com.currencyexchange.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final ExchangeRepository exchangeRepository;
    private final CurrencyRepository currencyRepository;

    public StatisticsServiceImpl(ExchangeRepository exchangeRepository,
                                 CurrencyRepository currencyRepository) {
        this.exchangeRepository = exchangeRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Response getStatistics(String mode, String currency) {
        Response response = null;
        switch (mode) {
            case "onetime":
                response = StatisticResponseFactory.getUserResponse(
                        exchangeRepository.getOnetimeQuery(
                                currencyRepository.findByName(currency)
                                .orElseThrow(IncorrectCurrencyException::create))
                );
                break;
            case "total":
                response = StatisticResponseFactory.getUserResponse(
                        exchangeRepository.getSumQuery(
                                currencyRepository.findByName(currency)
                                .orElseThrow(IncorrectCurrencyException::create))
                );
                break;
            case "popularity":
                response = StatisticResponseFactory.getPopularCurrency(exchangeRepository.sortByPopularity());
                break;
        }

        return response;
    }
}
