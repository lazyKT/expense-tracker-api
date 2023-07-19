package com.lwin.expense_tracker.service.budget;


import com.lwin.expense_tracker.repository.BudgetPlanRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanServiceImpl {

    private final BudgetPlanRepositoryImpl repository;

    @Autowired
    public BudgetPlanServiceImpl (BudgetPlanRepositoryImpl repository) {
        this.repository = repository;
    }

    public String callSomeMethod () {
        return repository.poc();
    }
}
