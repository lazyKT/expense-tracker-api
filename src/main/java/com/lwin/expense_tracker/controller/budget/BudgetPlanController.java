package com.lwin.expense_tracker.controller.budget;

import com.lwin.expense_tracker.dto.BudgetPlanDto;
import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import com.lwin.expense_tracker.service.budget.BudgetPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {

    private final BudgetPlanService service;

    @Autowired
    public BudgetPlanController (BudgetPlanService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public BudgetPlan createNewBudgetPlan (
        @RequestBody @Valid BudgetPlanDto dto,
        Principal principal
    ) {
        return this.service.saveBudgetPlan(dto, principal.getName());
    }
}
