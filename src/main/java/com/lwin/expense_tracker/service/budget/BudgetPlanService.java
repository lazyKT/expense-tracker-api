package com.lwin.expense_tracker.service.budget;

import com.lwin.expense_tracker.dto.BudgetPlanDto;
import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface BudgetPlanService {

    BudgetPlan saveBudgetPlan (BudgetPlanDto budgetPlanDto);

    BudgetPlan getBudgetPlan (int budgetPlanId);

    List<BudgetPlan> getBudgetPlans ();

    BudgetPlan updateBudgetPlan (int budgetPlanId);

    void deleteBudgetPlan (int budgetPlanId);

    List<BudgetPlan> getBudgetPlansByOwnerId (int ownerId);
}
