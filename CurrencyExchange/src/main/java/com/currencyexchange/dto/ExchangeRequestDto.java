package com.currencyexchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ExchangeRequestDto {

    @JsonProperty("user_id")
    private Integer user;
    private String amount;
    @JsonProperty("base_currency")
    private String baseCurrency;
    @JsonProperty("target_currency")
    private String targetCurrency;

}
