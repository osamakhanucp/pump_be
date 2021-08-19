package com.pump.pumpservice.api;


import com.pump.pumpservice.expense.Expense;
import com.pump.pumpservice.expensetype.ExpenseType;
import com.pump.pumpservice.responses.DefaultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/expenses")
@CrossOrigin
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @RequestMapping(method = RequestMethod.POST,value="/types")
    public @ResponseBody
    DefaultResponse addExpenseType(@RequestBody ExpenseType expenseType) {
        return expenseService.addExpenseType(expenseType);
    }

    @RequestMapping(method = RequestMethod.GET,value="/types")
    public @ResponseBody List<ExpenseType> getExpenseTypes() {
       return expenseService.getExpenseTypes();
    }

    @RequestMapping(method = RequestMethod.POST,value="")
    public @ResponseBody DefaultResponse addExpense(@RequestBody Expense expense) {
       return expenseService.addExpense(expense);
    }

    @RequestMapping(method = RequestMethod.GET,value="")
    public @ResponseBody Page<Expense> getExpenses(@RequestParam("page") int page, @RequestParam("size") int size) {
        return expenseService.getExpenses(page,size);
    }

}
