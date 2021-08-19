package com.pump.pumpservice.api;

import com.pump.pumpservice.bankledger.BankLedger;
import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebit;
import com.pump.pumpservice.customerledger.CustomerLedger;
import com.pump.pumpservice.requestmappers.CustomerLedgerMapper;
import com.pump.pumpservice.responses.BankLedgerDetail;
import com.pump.pumpservice.responses.CustomerLedgerDetail;
import com.pump.pumpservice.responses.CustomerLedgerResponse;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bank-ledger")
@CrossOrigin
public class BankLedgerController {

    @Autowired
    private BankLedgerService bankLedgerService;

    @RequestMapping(method = RequestMethod.POST,value="")
    public @ResponseBody
    DefaultResponse addBankLedger(@RequestBody BankLedger bankLedger) {
        return bankLedgerService.addBankLedger(bankLedger);
    }

    @RequestMapping(method = RequestMethod.POST,value="/credit-debit")
    public @ResponseBody
    DefaultResponse addBankLedgerCreditDebit(@RequestBody BankLedgerCreditDebit bankLedgerCreditDebit) {
        return bankLedgerService.addBankLedgerCreditDebit(bankLedgerCreditDebit);
    }

    @RequestMapping(method = RequestMethod.GET,value="/{bankLedgerId}")
    public @ResponseBody
    BankLedgerDetail getBankLedgerDetail(@PathVariable("bankLedgerId") Long id) {
        return bankLedgerService.getBankLedgerDetail(id);
    }

    @RequestMapping(method = RequestMethod.GET,value="/list")
    public @ResponseBody
    List<BankLedger> getBankLedgers() {
        return bankLedgerService.getBankLedgers();
    }

}
