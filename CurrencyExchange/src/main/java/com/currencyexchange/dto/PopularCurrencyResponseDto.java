package com.currencyexchange.dto;

import com.currencyexchange.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PopularCurrencyResponseDto implements Dto {

    @JsonProperty("base_Currency")
    private String baseCurrency;
    @JsonProperty("target_currency")
    private String targetCurrency;
}
