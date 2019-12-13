package com.liliapps.zion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liliapps.zion.model.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

}
