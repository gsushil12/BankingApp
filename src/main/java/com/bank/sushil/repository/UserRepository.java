package com.bank.sushil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.sushil.entity.Account;
import com.bank.sushil.entity.Userz;

public interface UserRepository extends JpaRepository<Userz, String>{

	Userz findByUserNameIgnoreCase(String username);
}
