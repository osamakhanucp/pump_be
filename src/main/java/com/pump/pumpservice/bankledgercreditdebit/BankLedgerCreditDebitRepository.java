package com.pump.pumpservice.bankledgercreditdebit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankLedgerCreditDebitRepository  extends JpaRepository<BankLedgerCreditDebit, Long> {
    public List<BankLedgerCreditDebit> findAllByBankLedgerId(Long bankLedgerId);
    public List<BankLedgerCreditDebit> findAllByCustomerLedgerId(Long customerLedgerId);

}
