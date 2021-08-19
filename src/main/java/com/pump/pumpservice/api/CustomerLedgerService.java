package com.pump.pumpservice.api;

import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebit;
import com.pump.pumpservice.bankledgercreditdebit.BankLedgerCreditDebitRepository;
import com.pump.pumpservice.customerledger.CustomerLedger;
import com.pump.pumpservice.customerledger.CustomerLedgerRepository;
import com.pump.pumpservice.customervehicle.CustomerVehicle;
import com.pump.pumpservice.customervehicle.CustomerVehicleRepository;
import com.pump.pumpservice.requestmappers.CustomerLedgerMapper;
import com.pump.pumpservice.responses.CustomerLedgerCreditDebit;
import com.pump.pumpservice.responses.CustomerLedgerDetail;
import com.pump.pumpservice.responses.CustomerLedgerResponse;
import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.sales.Sale;
import com.pump.pumpservice.sales.SaleRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerLedgerService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerLedgerRepository customerLedgerRepository;
    @Autowired
    private CustomerVehicleRepository customerVehicleRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private BankLedgerCreditDebitRepository bankLedgerCreditDebitRepository;

    public DefaultResponse addCustomerLedger(CustomerLedgerMapper customerLedgerMapper) {

        LOGGER.info("Adding customer ledger");
        CustomerLedger customerLedger = new CustomerLedger(customerLedgerMapper);
        customerLedgerRepository.save(customerLedger);

        for(int index = 0 ; index < customerLedgerMapper.getCustomerVehicles().size() ; index++) {
            CustomerVehicle customerVehicle = customerLedgerMapper.getCustomerVehicles().get(index);
            customerVehicle.setCustomerLedgerId(customerLedger.getId());
            customerVehicleRepository.save(customerVehicle);
        }
        return new DefaultResponse("S001","success");
    }

    public CustomerLedgerResponse getCustomerLedgerDetail(Long id) {

        CustomerLedgerResponse customerLedgerResponse = new CustomerLedgerResponse();

        LOGGER.info("Getting customer ledger by ID : " + id);

        Optional<CustomerLedger> customerLedger = customerLedgerRepository.findById(id);
        if(customerLedger.isPresent()){
            List<CustomerVehicle> customerVehicleList = customerVehicleRepository.findAllByCustomerLedgerId(id);

            customerLedgerResponse = new CustomerLedgerResponse(customerLedger.get());
            customerLedgerResponse.setCustomerVehicles(customerVehicleList);
        }

        return customerLedgerResponse;
    }

    public List<CustomerLedger> getCustomerLedgers() {
        return customerLedgerRepository.findAll();
    }

    public CustomerLedgerDetail getCustomerLedgerDetailCreditDebit(Long id) {

        CustomerLedgerDetail customerLedgerDetail = new CustomerLedgerDetail();

        LOGGER.info("Getting customer ledger by ID : " + id);

        Optional<CustomerLedger> customerLedger = customerLedgerRepository.findById(id);
        if(customerLedger.isPresent()){
            List<CustomerVehicle> customerVehicleList = customerVehicleRepository.findAllByCustomerLedgerId(id);

            customerLedgerDetail = new CustomerLedgerDetail(customerLedger.get());
            customerLedgerDetail.setCustomerVehicles(customerVehicleList);
        }

        List<CustomerLedgerCreditDebit> customerLedgerCreditDebits = new ArrayList<>();

        //Getting credit debit info
        List<Sale> sales = saleRepository.findAllByCustomerId(id);
        for(int index = 0 ; index < sales.size(); index++ ) {
            CustomerLedgerCreditDebit customerLedgerCreditDebit = new CustomerLedgerCreditDebit(sales.get(index));
            Optional<CustomerVehicle> customerVehicle = customerVehicleRepository.findById(sales.get(index).getVehicleId());
            if(customerVehicle.isPresent()) {
                customerLedgerCreditDebit.setDescription("Vehicle : " + customerVehicle.get().getName() + " " + customerVehicle.get().getNumber() + " - Quantity : " + sales.get(index).getQuantity());
            }
            customerLedgerCreditDebits.add(customerLedgerCreditDebit);
        }

        //Debit amount which submitted to bank
        List<BankLedgerCreditDebit> bankLedgerCreditDebits = bankLedgerCreditDebitRepository.findAllByCustomerLedgerId(id);
        for(int index = 0 ; index < bankLedgerCreditDebits.size(); index++ ) {
            CustomerLedgerCreditDebit customerLedgerCreditDebit = new CustomerLedgerCreditDebit(bankLedgerCreditDebits.get(index));
            customerLedgerCreditDebits.add(customerLedgerCreditDebit);
        }

        customerLedgerDetail.setCustomerLedgerCreditDebits(customerLedgerCreditDebits);
        return customerLedgerDetail;
    }


}
