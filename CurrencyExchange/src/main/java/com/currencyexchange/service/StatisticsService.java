package com.currencyexchange.service;

import com.currencyexchange.dto.Response;

public interface StatisticsService {

    Response getStatistics(String mode, String currency);
}
