package com.lwin.expense_tracker.validation;

import com.lwin.expense_tracker.entity.budget.BudgetPlanType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class BudgetPlanTypeSubsetValidator implements ConstraintValidator<BudgetPlanTypeSubset, BudgetPlanType> {

    private BudgetPlanType[] subset;

    @Override
    public void initialize (BudgetPlanTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid (BudgetPlanType budgetPlanType, ConstraintValidatorContext context) {
        return Arrays.asList(subset).contains(budgetPlanType);
    }
}
