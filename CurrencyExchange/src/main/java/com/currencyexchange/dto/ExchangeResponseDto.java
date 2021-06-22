package com.currencyexchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeResponseDto implements Response {

    @JsonProperty("exchange_id")
    private Integer exchangeId;
    private String result;
}
