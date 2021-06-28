package com.currencyexchange.repository;

import com.currencyexchange.model.Currency;
import com.currencyexchange.model.Exchange;
import com.currencyexchange.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

    @Query(value = "SELECT e, COUNT(e.id) AS total " +
            "FROM Exchange e GROUP BY e.baseCurrency, e.targetCurrency " +
            "ORDER BY total DESC")
    List<Exchange> sortByPopularity();

    @Query(value = "SELECT e FROM Exchange e " +
            "WHERE e.targetCurrency=?1 AND e.amount >= 10000 " +
            "ORDER BY amount DESC")
    List<Exchange> getOnetimeQuery(Currency currency);

    @Query(value = "SELECT e FROM Exchange e " +
            "WHERE e.targetCurrency=?1 GROUP BY e.user " +
            "HAVING SUM(amount) > 100000 " +
            "ORDER BY SUM(amount) DESC")
    List<Exchange> getSumQuery(Currency currency);
}
