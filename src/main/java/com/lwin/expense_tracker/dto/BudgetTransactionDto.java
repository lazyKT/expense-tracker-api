package com.lwin.expense_tracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetTransactionDto {

    private int budgetPlanId;
    private String transactionDetails;
    private Double transactionAmount;
    private String transactionType;
}
