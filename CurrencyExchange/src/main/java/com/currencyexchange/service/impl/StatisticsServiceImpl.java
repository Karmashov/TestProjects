package com.currencyexchange.service.impl;

import com.currencyexchange.dto.Response;
import com.currencyexchange.repository.ExchangeRepository;
import com.currencyexchange.service.StatisticsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final ExchangeRepository exchangeRepository;

    public StatisticsServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public Response getStatistics(String mode) {
        System.out.println("============");
        List<?> result = exchangeRepository.sortByPopularity();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
        return null;
    }
}
