package com.currencyexchange.dto;

import lombok.Data;

import java.util.List;

@Data
public class BaseResponseList implements Response {

    private List<? extends Dto> data;

    public BaseResponseList(List<? extends Dto> data) {
        this.data = data;
    }
}
