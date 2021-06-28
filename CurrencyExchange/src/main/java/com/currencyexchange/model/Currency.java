package com.currencyexchange.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "baseCurrency")
    private List<Exchange> baseCurrency;

    @OneToMany(mappedBy = "targetCurrency")
    private List<Exchange> targetCurrency;
}
