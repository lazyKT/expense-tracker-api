package com.lwin.expense_tracker.service.budget;


import com.lwin.expense_tracker.dto.BudgetTransactionDto;
import com.lwin.expense_tracker.entity.budget.BudgetTransaction;
import com.lwin.expense_tracker.exceptions.BudgetPlanNotFoundException;
import com.lwin.expense_tracker.exceptions.TransactionNotFoundException;
import com.lwin.expense_tracker.repository.budgetPlan.BudgetTransactionRepository;
import com.lwin.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BudgetTransactionService {

    private final BudgetTransactionRepository transactionRepository;
    private final BudgetPlanService budgetPlanService;
    private final UserService userService;

    @Autowired
    public BudgetTransactionService (BudgetTransactionRepository repository, BudgetPlanService service, UserService userService) {
        this.transactionRepository = repository;
        this.budgetPlanService = service;
        this.userService= userService;
    }


    public BudgetTransaction saveTransaction (BudgetTransactionDto dto, String userEmail) throws BudgetPlanNotFoundException {
        int userId = this.userService.getUserIdByEmail(userEmail);
        this.budgetPlanService.getBudgetPlanById(dto.getBudgetPlanId());
        BudgetTransaction transaction = this.fromDto(dto, userId);
        return this.transactionRepository.save(transaction);
    }

    public BudgetTransaction getBudgetTransaction (int transactionId) throws TransactionNotFoundException {
        return this.transactionRepository.findByTransactionId(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction not found with id " + transactionId));
    }


    public List<BudgetTransaction> getBudgetTransactionsByPlanId (int planId) {
        return this.transactionRepository.findAllByBudgetPlanId (planId);
    }


    public List<BudgetTransaction> getUserTransaction (String userEmail) {
        int userId = this.userService.getUserIdByEmail(userEmail);
        return this.transactionRepository.findAllByUserId(userId);
    }

    private BudgetTransaction fromDto (BudgetTransactionDto dto, int userId) {
        return new BudgetTransaction(
            dto.getBudgetPlanId(),
            userId,
            dto.getTransactionDetails(),
            dto.getTransactionAmount(),
            dto.getTransactionType(),
            dto.getTransactionDateTime() == null ? new Date() : dto.getTransactionDateTime()
        );
    }

}
