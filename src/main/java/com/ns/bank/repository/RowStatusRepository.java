package com.ns.bank.repository;

import com.ns.bank.entity.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowStatusRepository extends JpaRepository<RowStatus, Integer> {
}