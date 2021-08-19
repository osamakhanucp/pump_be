package com.pump.pumpservice.customervehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerVehicleRepository extends JpaRepository<CustomerVehicle, Long> {
    public List<CustomerVehicle> findAllByCustomerLedgerId(Long id);
}
