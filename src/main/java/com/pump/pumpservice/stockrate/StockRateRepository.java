package com.pump.pumpservice.stockrate;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StockRateRepository extends JpaRepository<StockRate, Long> {

    @Query("Select stockRate from StockRate as stockRate where stockRate.stockTypeId = :stockTypeId and stockRate.entryDate <= :dateParam order by stockRate.entryDate desc ")
    public List<StockRate> findByEntryDate(@Param("stockTypeId") Long stockTypeId, @Param("dateParam") Date date, Pageable pageable);

    @Query(value ="Select * from t_stock_rate as stockRate where stockRate.stock_type_id = :stockTypeId and stockRate.entry_date <= :dateParam order by stockRate.entry_date desc LIMIT 1", nativeQuery = true)
    public StockRate findStockByEntryDate(@Param("stockTypeId") Long stockTypeId, @Param("dateParam") Date date);

    @Query("Select stockRate from StockRate as stockRate where stockRate.stockTypeId = :stockTypeId and stockRate.activeDate <= :dateParam order by stockRate.activeDate desc")
    public List<StockRate> findByActiveDate(@Param("stockTypeId") Long stockTypeId, @Param("dateParam") Date date, Pageable pageable);

    @Query(value ="Select * from t_stock_rate as stockRate where stockRate.stock_type_id = :stockTypeId and stockRate.active_date <= :dateParam order by stockRate.active_date desc LIMIT 1", nativeQuery = true)
    public StockRate findStockByActiveDate(@Param("stockTypeId") Long stockTypeId, @Param("dateParam") Date date);

    @Query(value ="Select * from t_stock_rate as stockRate where stockRate.stock_type_id = :stockTypeId and stockRate.active_date < :currentDate order by stockRate.active_date desc", nativeQuery = true)
    public List<StockRate> getStockRateHistory(@Param("stockTypeId") Long stockTypeId, @Param("currentDate") Date currentDate);

    @Query(value ="Select * from t_stock_rate as stockRate where stockRate.stock_type_id = :stockTypeId and stockRate.active_date >= :currentDate order by stockRate.active_date asc", nativeQuery = true)
    public List<StockRate> getStockRateUpcoming(@Param("stockTypeId") Long stockTypeId, @Param("currentDate") Date currentDate);
}
