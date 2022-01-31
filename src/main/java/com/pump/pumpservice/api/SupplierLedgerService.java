package com.pump.pumpservice.api;

import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.supplierledger.SupplierLedger;
import com.pump.pumpservice.supplierledger.SupplierLedgerItem;
import com.pump.pumpservice.supplierledger.SupplierLedgerItemRepository;
import com.pump.pumpservice.supplierledger.SupplierLedgerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierLedgerService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SupplierLedgerRepository supplierLedgerRepository;
    @Autowired
    private SupplierLedgerItemRepository supplierLedgerItemRepository;

    public DefaultResponse addSupplierLedger(SupplierLedger supplierLedger) {
        LOGGER.info("Adding Supplier Name : " + supplierLedger.getSupplierName());
        supplierLedgerRepository.save(supplierLedger);
        return  new DefaultResponse("201","success");
    }

    public DefaultResponse editSupplierLedger(SupplierLedger supplierLedger) {
        LOGGER.info("Editing Supplier Id : " + supplierLedger.getId());
        supplierLedgerRepository.save(supplierLedger);
        return new DefaultResponse("200","success");
    }

    public DefaultResponse deleteSupplierLedger(Long id) {
        int count = supplierLedgerItemRepository.getSupplierLedgerItemCount(id);
        if(count <= 0) {
            supplierLedgerRepository.deleteById(id);
            return  new DefaultResponse("200","success");
        }
        return  new DefaultResponse("400","Can not delete, delete all entries of this Supplier Ledger.");
    }

    public DefaultResponse addSupplierLedgerItems(Long supplierLedgerId, List<SupplierLedgerItem> supplierLedgerItems) {
        for(SupplierLedgerItem supplierLedgerItem : supplierLedgerItems) {
            supplierLedgerItem.setSupplierLedgerId(supplierLedgerId);
            supplierLedgerItemRepository.save(supplierLedgerItem);
        }
        return new DefaultResponse("201","success");
    }

    public DefaultResponse deleteSupplierLedgerItem(Long id) {
        supplierLedgerItemRepository.deleteById(id);
        return new DefaultResponse("200","success");
    }


}
