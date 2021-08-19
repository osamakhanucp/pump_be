package com.pump.pumpservice.dailysales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface DailySaleRepository extends JpaRepository<DailySale, Long> {

    DailySale findByEntryDate(Date date);

    DailySale findByEntryDateAfterOrEntryDate(Date date, Date zeroTimeDate);

//    @Query("Select ds from DailySale as ds where ds.entryDate > :date and ds.entryDate < :endDay")
//    DailySale findByEntryDateGreaterThanAndEntryDateLessThan(@Param("date") Date date, @Param("endDay") Date endDay);

}
