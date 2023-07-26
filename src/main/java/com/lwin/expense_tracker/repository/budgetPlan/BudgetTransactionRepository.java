package com.lwin.expense_tracker.repository.budgetPlan;

import com.lwin.expense_tracker.entity.budget.BudgetTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetTransactionRepository extends JpaRepository<BudgetTransaction, Integer> {
    List<BudgetTransaction> findAllByBudgetPlanId(int planId);

    Optional<BudgetTransaction> findByTransactionId(int transactionId);

    List<BudgetTransaction> findAllByUserId(int userId);
}
