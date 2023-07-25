package com.lwin.expense_tracker.service.budget;


import com.lwin.expense_tracker.dto.BudgetPlanDto;
import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.repository.budgetPlan.BudgetPlanRepository;
import com.lwin.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanService {

    private final BudgetPlanRepository budgetPlanRepository;
    private final UserService userService;

    @Autowired
    public BudgetPlanService (BudgetPlanRepository budgetPlanRepository, UserService userService) {
        this.budgetPlanRepository = budgetPlanRepository;
        this.userService = userService;
    }

    public BudgetPlan saveBudgetPlan (BudgetPlanDto dto, String userEmail) {
        User user = userService.getUserByEmail(userEmail);
        BudgetPlan budgetPlan = new BudgetPlan(
            user.getId(),
            dto.getBudgetPlanName(),
            dto.getBudgetPlanMonthlyIncome(),
            dto.getBudgetPlanMonthlyTarget(),
            dto.getBudgetPlanBalance(),
            dto.getBudgetPlanType()
        );
        return this.budgetPlanRepository.save(budgetPlan);
    }

}
