package com.pump.pumpservice.dailysalenozzles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface DailySaleNozzleRepository extends JpaRepository<DailySaleNozzle, Long> {

    List<DailySaleNozzle> findAllByDailySaleId(Long dailySaleId);
    List<DailySaleNozzle> findAllByEntryDate(Date date);

    @Query(value ="Select count(*) from t_daily_sale_nozzle as ds where ds.nozzleId = :nozzleId ", nativeQuery = true)
    public int getDailySaleNozzleCount(@Param("nozzleId") Long nozzleId);
}
