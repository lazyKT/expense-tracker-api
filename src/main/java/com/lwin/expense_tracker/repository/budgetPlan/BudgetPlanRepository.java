package com.lwin.expense_tracker.repository.budgetPlan;

import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Integer> {
}
