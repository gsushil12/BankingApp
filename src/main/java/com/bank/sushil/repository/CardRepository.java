package com.bank.sushil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sushil.entity.Account;
import com.bank.sushil.entity.Card;

public interface CardRepository extends JpaRepository<Card, String>{

}
