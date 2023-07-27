package com.lwin.expense_tracker.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetTransactionDto {

    @NotNull(message = "Budget Plan Id must not be null")
    @Min(0)
    private int budgetPlanId;
    @NotNull(message = "Please provide transaction details")
    private String transactionDetails;
    @NotNull(message = "Transaction amount must not be null")
    @Min(0)
    private Double transactionAmount;
    @NotNull(message = "Transaction Type must not be a null value")
    private String transactionType;

    private Date transactionDateTime;
}
