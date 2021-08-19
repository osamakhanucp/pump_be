package com.pump.pumpservice.api;

import com.pump.pumpservice.customerledger.CustomerLedgerRepository;
import com.pump.pumpservice.expense.Expense;
import com.pump.pumpservice.responses.CustomerLedgerDetail;
import com.pump.pumpservice.responses.CustomerLedgerResponse;
import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.sales.Sale;
import com.pump.pumpservice.sales.SaleRepository;
import com.pump.pumpservice.stocktype.StockType;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerLedgerService customerLedgerService;

    @Autowired
    private StockService stockService;

    @Autowired
    private SaleRepository saleRepository;

    DefaultResponse addSale(Sale sale) {
        LOGGER.info("Adding sale");
        saleRepository.save(sale);
        return new DefaultResponse("S001","success");
    }

    public Page<Sale> getSales(int page, int size) {

        LOGGER.info("Get Sales");
        Pageable paging = PageRequest.of(page, size);
        Page<Sale> sales = saleRepository.findAll(paging);
        List<StockType> stockTypes = stockService.getStockTypes();
        for( int index = 0 ; index < sales.getContent().size() ; index++ ) {
            CustomerLedgerResponse customerLedgerResponse = customerLedgerService.getCustomerLedgerDetail(sales.getContent().get(index).getCustomerId());
            if(customerLedgerResponse != null) {
                sales.getContent().get(index).setCustomerName(customerLedgerResponse.getCustomerName());
                for(int indexOfVehicle = 0 ; indexOfVehicle < customerLedgerResponse.getCustomerVehicles().size() ; indexOfVehicle++) {
                    if(sales.getContent().get(index).getVehicleId().longValue() == customerLedgerResponse.getCustomerVehicles().get(indexOfVehicle).getId().longValue()){
                        sales.getContent().get(index).setVehicleName(customerLedgerResponse.getCustomerVehicles().get(indexOfVehicle).getName());
                    }
                }
            }
            for(int indexOfStock = 0 ; indexOfStock < stockTypes.size() ; indexOfStock++ ){

                if(sales.getContent().get(index).getStockTypeId().longValue() == stockTypes.get(indexOfStock).getId().longValue()) {
                    sales.getContent().get(index).setStockTypeName(stockTypes.get(indexOfStock).getName());
                }
            }
        }

        return sales;
    }

}
