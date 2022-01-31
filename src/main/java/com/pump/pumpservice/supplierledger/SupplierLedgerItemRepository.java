package com.pump.pumpservice.supplierledger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SupplierLedgerItemRepository extends JpaRepository<SupplierLedgerItem, Long> {

    @Query(value ="Select count(*) from t_supplier_ledger_item as sli where sli.supplier_ledger_id = :supplierLedgerId ", nativeQuery = true)
    public int getSupplierLedgerItemCount(@Param("supplierLedgerId") Long supplierLedgerId);

}
