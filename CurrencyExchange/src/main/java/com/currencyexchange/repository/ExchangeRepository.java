package com.currencyexchange.repository;

import com.currencyexchange.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

    @Query(value = "SELECT e, COUNT(e.id) AS amount " +
            "FROM Exchange e GROUP BY e.baseCurrency, e.targetCurrency " +
            "ORDER BY amount DESC")
    List<Exchange> sortByPopularity();
}
