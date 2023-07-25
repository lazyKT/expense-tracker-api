package com.lwin.expense_tracker.entity.budget;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BUDGET_PLAN_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int budgetPlanId;
    private int budgetPlanOwner;
    private String budgetPlanName;
    private Double budgetPlanMonthlyIncome; // monthly income to this plan
    private Double budgetPlanMonthlyTarget; // target usage monthly
    private Double budgetPlanBalance;
    private BudgetPlanType budgetPlanType;

    public BudgetPlan (int owner, String name, Double monthlyIncome, Double monthlyTarget, Double balance, BudgetPlanType type) {
        this.budgetPlanOwner = owner;
        this.budgetPlanName = name;
        this.budgetPlanMonthlyTarget = monthlyTarget;
        this.budgetPlanMonthlyIncome = monthlyIncome;
        this.budgetPlanBalance = balance;
        this.budgetPlanType = type;
    }
}
