package com.lwin.expense_tracker.service.budget;


import com.lwin.expense_tracker.repository.budgetPlan.BudgetPlanRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanServiceImpl {

    private final BudgetPlanRepositoryImpl repository;

    @Autowired
    public BudgetPlanServiceImpl (BudgetPlanRepositoryImpl repository) {
        this.repository = repository;
    }

    @PreAuthorize("hasRole('ADMIN'")
    public String adminOnlyService () {
        return "Admin only";
    }

    public String callSomeMethod () {
        return repository.poc();
    }
}
