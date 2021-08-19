package com.pump.pumpservice.api;

import com.pump.pumpservice.nozzles.Nozzle;
import com.pump.pumpservice.requestmappers.DateMapper;
import com.pump.pumpservice.requestmappers.MachineMapper;
import com.pump.pumpservice.responses.DailySaleTemplate;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/pumpservice")
@CrossOrigin
public class MachineController {

    @Autowired
    private MachineService machineService;

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

    @RequestMapping(method = RequestMethod.POST,value="/dailySaleTemplate")
    public @ResponseBody
    DailySaleTemplate getDailySaleTemplate(@RequestBody DateMapper dateMapper) throws ParseException {
        return machineService.getDailySaleTemplate(dateMapper);
    }

    @RequestMapping(method = RequestMethod.POST,value="/addDailySale")
    public @ResponseBody
    DefaultResponse addDailySale(@RequestBody DailySaleTemplate dailySaleTemplate) {
        return machineService.addDailySale(dailySaleTemplate);
    }

}
