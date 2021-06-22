package com.currencyexchange.service;

import com.currencyexchange.dto.ExchangeRequestDto;
import com.currencyexchange.dto.Response;

public interface ExchangeService {

    Response exchange(ExchangeRequestDto requestDto);
}
