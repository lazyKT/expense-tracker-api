package com.lwin.expense_tracker.dto;

import com.lwin.expense_tracker.entity.budget.BudgetPlanType;
import com.lwin.expense_tracker.validation.BudgetPlanTypeSubset;
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

    @NotNull(message = "Budget monthly income must not be null")
    @Min(0)
    private Double budgetPlanMonthlyIncome; // monthly income to this plan

    @NotNull(message = "Budget monthly target must not be null")
    @Min(0)
    private Double budgetPlanMonthlyTarget; // target usage monthly

    @NotNull(message = "Budget balance must not be null")
    @Min(0)
    private Double budgetPlanBalance;

    @NotNull(message = "Budget plan type must not be null")
    @BudgetPlanTypeSubset(anyOf = {BudgetPlanType.PERSONAL, BudgetPlanType.JOINT})
    private BudgetPlanType budgetPlanType;
}
