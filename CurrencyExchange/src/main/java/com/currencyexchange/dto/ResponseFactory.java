package com.currencyexchange.dto;

public class ResponseFactory {

    public static Response getExchangeResponse(Integer id, String result) {
        return new ExchangeResponseDto(id, result);
    }
}
