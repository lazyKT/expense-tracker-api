package com.lwin.expense_tracker.repository.budgetPlan;

import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Integer> {
    List<BudgetPlan> findByBudgetPlanOwner (int owner);

    Optional<BudgetPlan> findByBudgetPlanId(int planId);
}
