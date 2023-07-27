package com.lwin.expense_tracker.entity.budget;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;

    private int budgetPlanId;
    private int userId;
    private String transactionDetails;
    private Double transactionAmount;
    private String transactionType;
    private Date transactionDateTime;

    public BudgetTransaction (int budgetPlanId, int userId, String transactionDetails, Double transactionAmount, String transactionType, Date transactionDateTime) {
        this.budgetPlanId = budgetPlanId;
        this.userId = userId;
        this.transactionDetails = transactionDetails;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.transactionDateTime = transactionDateTime;
    }
}
