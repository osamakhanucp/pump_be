package com.pump.pumpservice.api;

import com.pump.pumpservice.customerledger.CustomerLedger;
import com.pump.pumpservice.customervehicle.CustomerVehicle;
import com.pump.pumpservice.expensetype.ExpenseType;
import com.pump.pumpservice.requestmappers.CustomerLedgerMapper;
import com.pump.pumpservice.responses.CustomerLedgerDetail;
import com.pump.pumpservice.responses.CustomerLedgerResponse;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customer-ledger")
@CrossOrigin
public class CustomerLedgerController {

    @Autowired
    private CustomerLedgerService customerLedgerService;

    @RequestMapping(method = RequestMethod.POST,value="")
    public @ResponseBody
    DefaultResponse addExpenseType(@RequestBody CustomerLedgerMapper customerLedgerMapper) {
        return customerLedgerService.addCustomerLedger(customerLedgerMapper);
    }

    @RequestMapping(method = RequestMethod.GET,value="/{customerLedgerId}")
    public @ResponseBody CustomerLedgerResponse getCustomerLedgerDetail(@PathVariable("customerLedgerId") Long id) {
        return customerLedgerService.getCustomerLedgerDetail(id);
    }

    @RequestMapping(method = RequestMethod.GET,value="/list")
    public @ResponseBody List<CustomerLedger> getCustomerLedger() {
        return customerLedgerService.getCustomerLedgers();
    }

    @RequestMapping(method = RequestMethod.GET,value="/{customerLedgerId}/credit-debit-info")
    public @ResponseBody
    CustomerLedgerDetail getCustomerLedgerDetailCreditDebit(@PathVariable("customerLedgerId") Long id) {
        return customerLedgerService.getCustomerLedgerDetailCreditDebit(id);
    }

}
