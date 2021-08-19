package com.pump.pumpservice.sales;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByCustomerId(Long id);
}
