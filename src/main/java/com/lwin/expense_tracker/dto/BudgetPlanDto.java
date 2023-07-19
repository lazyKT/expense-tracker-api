package com.lwin.expense_tracker.dto;

import com.lwin.expense_tracker.entity.budget.BudgetPlanType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetPlanDto {

    @NotNull(message = "Budget plan name must not be null")
    private String budgetPlanName;

    @NotNull(message = "Budget owner id must not be null")
    private int budgetPlanOwner;

    @Min(0)
    private Double budgetPlanMonthlyIncome; // monthly income to this plan

    @Min(0)
    private Double budgetPlanMonthlyTarget; // target usage monthly

    @Min(0)
    private Double budgetPlanBalance;
    private BudgetPlanType budgetPlanType;
    private String createdAt;
}
