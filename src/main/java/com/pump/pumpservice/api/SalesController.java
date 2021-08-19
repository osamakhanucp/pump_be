package com.pump.pumpservice.api;

import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.sales.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sales")
@CrossOrigin
public class SalesController {
    @Autowired
    SalesService salesService;

    @RequestMapping(method = RequestMethod.POST,value="")
    public @ResponseBody
    DefaultResponse addSale(@RequestBody Sale sale) {
       return salesService.addSale(sale);
    }

    @RequestMapping(method = RequestMethod.GET,value="")
    public @ResponseBody Page<Sale> getSales(@RequestParam("page") int page, @RequestParam("size") int size) {
        return salesService.getSales(page, size);
    }
}
