package com.currencyexchange.dto;

import com.currencyexchange.model.Exchange;
import com.currencyexchange.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatisticResponseFactory {
    public static BaseResponseList getPopularCurrency(List<Exchange> data) {
        List<Dto> result = new ArrayList<>();

        for (Exchange exchange : data) {
            result.add(new PopularCurrencyResponseDto(exchange.getBaseCurrency().getName(), exchange.getTargetCurrency().getName()));
        }

        return new BaseResponseList(result);
    }

    public static BaseResponseList getUserResponse(List<Exchange> data) {
        List<Dto> result = new ArrayList<>();
        Set<Integer> resultSet = new HashSet<>();

        for (Exchange exchange : data) {
            Integer userId = exchange.getUser().getId();
            if (!resultSet.contains(userId)) {
                result.add(new UserResponseDto(userId, exchange.getUser().getName()));
                resultSet.add(userId);
            }
        }

        return new BaseResponseList(result);
    }
}
