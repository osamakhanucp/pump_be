package com.pump.pumpservice.dailysalenozzles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailySaleNozzleRepository extends JpaRepository<DailySaleNozzle, Long> {

    List<DailySaleNozzle> findAllByDailySaleId(Long dailySaleId);

}
