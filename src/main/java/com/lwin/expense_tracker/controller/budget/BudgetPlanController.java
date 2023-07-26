package com.lwin.expense_tracker.controller.budget;

import com.lwin.expense_tracker.dto.BudgetPlanDto;
import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import com.lwin.expense_tracker.exceptions.BudgetPlanNotFoundException;
import com.lwin.expense_tracker.exceptions.UnAuthorizedResourceAcessException;
import com.lwin.expense_tracker.service.budget.BudgetPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

    @GetMapping("")
    public List<BudgetPlan> getBudgetPlans (Principal principal) {
        return this.service.getBudgetPlans(principal.getName());
    }

    @GetMapping("/{planId}")
    public BudgetPlan getBudgetPlanById (@PathVariable int planId) throws BudgetPlanNotFoundException {
        return this.service.getBudgetPlanById(planId);
    }

    @PatchMapping("/{planId}")
    public BudgetPlan updateBudgetPlanByPlanId (
        @RequestBody @Valid BudgetPlanDto dto,
        @PathVariable int planId
    ) throws BudgetPlanNotFoundException {
        return this.service.updateBudgetPlan(planId, dto);
    }


    @DeleteMapping("/{planId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBudgetPlan (@PathVariable int planId, Principal principal)
            throws BudgetPlanNotFoundException, UnAuthorizedResourceAcessException {
        this.service.deleteBudgetPlan(planId, principal.getName());
    }
}
