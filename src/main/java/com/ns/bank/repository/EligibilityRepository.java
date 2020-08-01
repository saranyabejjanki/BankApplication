package com.ns.bank.repository;

import com.ns.bank.entity.Eligibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityRepository extends JpaRepository<Eligibility, Integer> {
}