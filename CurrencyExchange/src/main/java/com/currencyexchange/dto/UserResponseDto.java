package com.currencyexchange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto implements Dto {

    @JsonProperty("user_id")
    private Integer id;
    private String name;
}
