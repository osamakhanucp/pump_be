package com.pump.pumpservice.customerledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLedgerRepository extends JpaRepository<CustomerLedger, Long> {
}
