package com.pump.pumpservice.api;

import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.supplierledger.SupplierLedger;
import com.pump.pumpservice.supplierledger.SupplierLedgerItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/supplierLedger")
@CrossOrigin
public class SupplierLedgerController {

    @Autowired
    private SupplierLedgerService supplierLedgerService;

    @RequestMapping(method = RequestMethod.POST,value="")
    public @ResponseBody
    DefaultResponse addSupplierLedger(@RequestBody SupplierLedger supplierLedger) {
        return supplierLedgerService.addSupplierLedger(supplierLedger);
    }

    @RequestMapping(method = RequestMethod.PUT,value="")
    public @ResponseBody
    DefaultResponse editSupplierLedger(@RequestBody SupplierLedger supplierLedger) {

        return supplierLedgerService.editSupplierLedger(supplierLedger);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/{id}")
    public @ResponseBody
    DefaultResponse deleteSupplierLedger(@PathVariable("id") Long id) {

        return supplierLedgerService.deleteSupplierLedger(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/{id}/ledgerItems")
    public @ResponseBody
    DefaultResponse addSupplierLedgerItems(@PathVariable("id") Long supplierLedgerId, @RequestBody List<SupplierLedgerItem> supplierLedgerItems) {
        return supplierLedgerService.addSupplierLedgerItems(supplierLedgerId, supplierLedgerItems);
    }

    @RequestMapping(method = RequestMethod.POST,value="/{supplierLedgerId}/ledgerItems/{ledgerItemId}")
    public @ResponseBody
    DefaultResponse deleteSupplierLedgerItem(@PathVariable("supplierLedgerId") Long supplierLedgerId, @PathVariable("ledgerItemId") Long ledgerItemId) {
        return supplierLedgerService.deleteSupplierLedgerItem(ledgerItemId);
    }
}
