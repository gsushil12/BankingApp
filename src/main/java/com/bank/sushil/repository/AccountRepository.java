package com.bank.sushil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sushil.entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
