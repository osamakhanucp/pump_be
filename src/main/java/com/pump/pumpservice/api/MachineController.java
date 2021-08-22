package com.pump.pumpservice.api;

import com.pump.pumpservice.nozzles.Nozzle;
import com.pump.pumpservice.requestmappers.DateMapper;
import com.pump.pumpservice.responses.MeterReadingTemplate;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/pumpservice")
@CrossOrigin
public class MachineController {

    @Autowired
    private MachineService machineService;
    @Autowired
    private DailySailService dailySailService;

    @RequestMapping(method = RequestMethod.POST,value="/addNozzle")
    public @ResponseBody
    DefaultResponse addNozzle(@RequestBody Nozzle nozzle) {
        return machineService.addNozzle(nozzle);
    }

    @RequestMapping(method = RequestMethod.GET,value="/nozzles")
    public @ResponseBody
    List<Nozzle> getNozzles() {
        return machineService.getNozzles();
    }

    @RequestMapping(method = RequestMethod.POST,value="/meterReadingTemplate")
    public @ResponseBody
    MeterReadingTemplate getDailySaleTemplate(@RequestBody DateMapper dateMapper) throws ParseException {
        return dailySailService.getMeterReadingTemplate(dateMapper);
    }

    @RequestMapping(method = RequestMethod.POST,value="/addMeterReading")
    public @ResponseBody
    DefaultResponse addDailySale(@RequestBody MeterReadingTemplate meterReadingTemplate) {
        return dailySailService.setMeterReading(meterReadingTemplate.getDailySaleNozzles(), meterReadingTemplate.getEntryDate());
    }

}
