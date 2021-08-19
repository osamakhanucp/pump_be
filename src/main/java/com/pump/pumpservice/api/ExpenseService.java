package com.pump.pumpservice.api;

import com.pump.pumpservice.expense.Expense;
import com.pump.pumpservice.expense.ExpenseRepository;
import com.pump.pumpservice.expensetype.ExpenseType;
import com.pump.pumpservice.expensetype.ExpenseTypeRepository;
import com.pump.pumpservice.responses.DefaultResponse;
import com.pump.pumpservice.stockrate.StockRate;
import com.pump.pumpservice.stocktype.StockType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {

    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseTypeRepository expenseTypeRepository;

    public DefaultResponse addExpenseType(ExpenseType expenseType) {
        LOGGER.info("Adding Expense type");
        expenseTypeRepository.save(expenseType);
        return new DefaultResponse("S001","success");
    }

    public List<ExpenseType> getExpenseTypes() {
        LOGGER.info("Returning all expense types");
        return expenseTypeRepository.findAll();
    }

    public DefaultResponse addExpense(Expense expense) {
        LOGGER.info("Adding expense");
        expenseRepository.save(expense);
        return new DefaultResponse("S001","success");
    }

    public Page<Expense> getExpenses(int page, int size) {

        LOGGER.info("Get Expenses");
        Pageable paging = PageRequest.of(page, size);
        Page<Expense> expenses = expenseRepository.findAll(paging);
        return expenses;

    }

}
