package com.pump.pumpservice.bankledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankLedgerRepository extends JpaRepository<BankLedger, Long> {
}
