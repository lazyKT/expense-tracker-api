package com.lwin.expense_tracker.entity.budget;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GeneratedValue
    private int budgetPlanId;
    private int budgetPlanOwner;
    private String budgetPlanName;
    private Double budgetPlanMonthlyIncome; // monthly income to this plan
    private Double budgetPlanMonthlyTarget; // target usage monthly
    private Double budgetPlanBalance;
    private BudgetPlanType budgetPlanType;
    private String createdAt;

}
