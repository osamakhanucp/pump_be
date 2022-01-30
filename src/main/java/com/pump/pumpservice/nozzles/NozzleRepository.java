package com.pump.pumpservice.nozzles;

import com.pump.pumpservice.stockrate.StockRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NozzleRepository extends JpaRepository<Nozzle,Long> {

}
