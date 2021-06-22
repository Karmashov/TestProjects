package com.currencyexchange.service.impl;

import com.currencyexchange.dto.ExchangeRequestDto;
import com.currencyexchange.dto.Response;
import com.currencyexchange.dto.ResponseFactory;
import com.currencyexchange.service.ExchangeService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Override
    public Response exchange(ExchangeRequestDto requestDto) {
        return ResponseFactory.getExchangeResponse(0, null);
    }
}
