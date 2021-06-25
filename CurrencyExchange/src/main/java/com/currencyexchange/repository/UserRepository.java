package com.currencyexchange.repository;

import com.currencyexchange.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

//    Optional<User> findById(Integer id);
}
