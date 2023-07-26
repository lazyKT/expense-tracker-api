package com.lwin.expense_tracker.controller.budget;


import com.lwin.expense_tracker.dto.BudgetTransactionDto;
import com.lwin.expense_tracker.entity.budget.BudgetTransaction;
import com.lwin.expense_tracker.exceptions.BudgetPlanNotFoundException;
import com.lwin.expense_tracker.service.budget.BudgetTransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/budget/transactions")
public class BudgetTransactionController {

    private final BudgetTransactionService transactionService;

    @Autowired
    public BudgetTransactionController (BudgetTransactionService service) {
        this.transactionService = service;
    }

    @PostMapping("/new")
    public BudgetTransaction addTransaction (
        @RequestBody @Valid BudgetTransactionDto dto,
        Principal principal
    ) throws BudgetPlanNotFoundException {
        return this.transactionService.saveTransaction(dto, principal.getName());
    }

    @GetMapping("/{budgetPlanId}")
    public List<BudgetTransaction> getTransactionsByBudgetPlanId (@PathVariable int budgetPlanId) {
        return this.transactionService.getBudgetTransactionsByPlanId(budgetPlanId);
    }

    @GetMapping("")
    public List<BudgetTransaction> getUserTransactions (Principal principal) {
        return this.transactionService.getUserTransaction(principal.getName());
    }

}
