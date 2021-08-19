package com.pump.pumpservice.api;

import com.pump.pumpservice.bankledger.BankLedger;
import com.pump.pumpservice.bankledger.BankLedgerRepository;
import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebit;
import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebitRepository;
import com.pump.pumpservice.customerledger.CustomerLedger;
import com.pump.pumpservice.customervehicle.CustomerVehicle;
import com.pump.pumpservice.requestmappers.CustomerLedgerMapper;
import com.pump.pumpservice.responses.BankLedgerDetail;
import com.pump.pumpservice.responses.CustomerLedgerResponse;
import com.pump.pumpservice.responses.DefaultResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankLedgerService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BankLedgerRepository bankLedgerRepository;
    @Autowired
    private BankLedgerCreditDebitRepository bankLedgerCreditDebitRepository;

    public DefaultResponse addBankLedger(BankLedger bankLedger) {

        LOGGER.info("Adding bank ledger");
        bankLedgerRepository.save(bankLedger);

        return new DefaultResponse("S001","success");
    }

    public DefaultResponse addBankLedgerCreditDebit(BankLedgerCreditDebit bankLedgerCreditDebit) {

        LOGGER.info("Adding bank ledger credit debit : type : " + bankLedgerCreditDebit.getType());
        bankLedgerCreditDebitRepository.save(bankLedgerCreditDebit);

        return new DefaultResponse("S001","success");
    }

    public BankLedgerDetail getBankLedgerDetail(Long id) {

        BankLedgerDetail bankLedgerDetail = new BankLedgerDetail();

        LOGGER.info("Getting bank ledger by ID : " + id);

        Optional<BankLedger> bankLedger = bankLedgerRepository.findById(id);
        if(bankLedger.isPresent()){
            List<BankLedgerCreditDebit> bankLedgerCreditDebits = bankLedgerCreditDebitRepository.findAllByBankLedgerId(id);

            bankLedgerDetail = new BankLedgerDetail(bankLedger.get());
            bankLedgerDetail.setBankLedgerCreditDebits(bankLedgerCreditDebits);
        }

        return bankLedgerDetail;
    }

    public List<BankLedger> getBankLedgers() {
        return bankLedgerRepository.findAll();
    }

}
