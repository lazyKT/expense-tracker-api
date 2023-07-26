package com.lwin.expense_tracker.service.budget;


import com.lwin.expense_tracker.dto.BudgetPlanDto;
import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import com.lwin.expense_tracker.entity.user.User;
import com.lwin.expense_tracker.exceptions.BudgetPlanNotFoundException;
import com.lwin.expense_tracker.exceptions.UnAuthorizedResourceAcessException;
import com.lwin.expense_tracker.repository.budgetPlan.BudgetPlanRepository;
import com.lwin.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<BudgetPlan> getBudgetPlans (String email) {
        User user = this.userService.getUserByEmail(email);
        return this.budgetPlanRepository.findByBudgetPlanOwner(user.getId());
    }

    public BudgetPlan getBudgetPlanById (int planId) throws BudgetPlanNotFoundException {
        return this.budgetPlanRepository.findByBudgetPlanId(planId)
                .orElseThrow(() -> new BudgetPlanNotFoundException("Not plan found with id, " + planId));
    }

    public BudgetPlan updateBudgetPlan (int planId, BudgetPlanDto updatedDto) throws BudgetPlanNotFoundException {
        BudgetPlan plan = this.budgetPlanRepository.findByBudgetPlanId(planId)
                .orElseThrow(() -> new BudgetPlanNotFoundException("Not plan found with id, " + planId));
        this.fromDtoToEntity(updatedDto, plan);
        return this.budgetPlanRepository.save(plan);
    }


    public void deleteBudgetPlan (int planId, String email) throws BudgetPlanNotFoundException, UnAuthorizedResourceAcessException {
        int ownerId = this.userService.getUserIdByEmail(email);
        BudgetPlan plan = this.getBudgetPlanById(planId);
        if (ownerId == plan.getBudgetPlanOwner()) {
            this.budgetPlanRepository.delete(plan);
        } else {
            throw new UnAuthorizedResourceAcessException("Unauthorized access to modify the resource.");
        }
    }

    private void fromDtoToEntity (BudgetPlanDto dto, BudgetPlan budgetPlan) {
        budgetPlan.setBudgetPlanBalance(dto.getBudgetPlanBalance());
        budgetPlan.setBudgetPlanMonthlyIncome(dto.getBudgetPlanMonthlyIncome());
        budgetPlan.setBudgetPlanName(dto.getBudgetPlanName());
        budgetPlan.setBudgetPlanType(dto.getBudgetPlanType());
        budgetPlan.setBudgetPlanMonthlyTarget(dto.getBudgetPlanMonthlyTarget());
    }

}
