package com.currencyexchange.repository;

import com.currencyexchange.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Optional<Currency> findByName(String name);

    boolean existsCurrencyByNameIgnoreCase(String name);
}
