package com.lwin.expense_tracker.repository.budget;


import com.lwin.expense_tracker.entity.budget.BudgetPlan;
import com.lwin.expense_tracker.entity.budget.BudgetPlanType;
import com.lwin.expense_tracker.repository.budgetPlan.BudgetPlanRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class BudgetPlanRepositoryTests {

    @Autowired
    BudgetPlanRepository repository;

    @Test
    public void BudgetPlanRepository_AddPlan_ReturnBudgetPlan () {
        BudgetPlan plan = BudgetPlan.builder()
                .budgetPlanOwner(1)
                .budgetPlanName("Test plan")
                .budgetPlanBalance(240.00)
                .budgetPlanMonthlyIncome(500.00)
                .budgetPlanMonthlyTarget(200.00)
                .budgetPlanType(BudgetPlanType.PERSONAL)
                .build();
        BudgetPlan newPlan = repository.save(plan);

        Assertions.assertThat(newPlan).isNotNull();
        Assertions.assertThat(newPlan.getBudgetPlanName()).isEqualTo("Test plan");
    }

    @Test
    public void BudgetPlanRepository_GetPlansByOwner_ReturnBudgetPlanList () {
        BudgetPlan plan1 = BudgetPlan.builder()
                .budgetPlanOwner(1)
                .budgetPlanName("Test plan 1")
                .budgetPlanBalance(240.00)
                .budgetPlanMonthlyIncome(500.00)
                .budgetPlanMonthlyTarget(200.00)
                .budgetPlanType(BudgetPlanType.PERSONAL)
                .build();
        BudgetPlan plan2 = BudgetPlan.builder()
                .budgetPlanOwner(1)
                .budgetPlanName("Test plan 2")
                .budgetPlanBalance(240.00)
                .budgetPlanMonthlyIncome(500.00)
                .budgetPlanMonthlyTarget(200.00)
                .budgetPlanType(BudgetPlanType.PERSONAL)
                .build();
        repository.save(plan1);
        repository.save(plan2);

        List<BudgetPlan> userPlans = repository.findByBudgetPlanOwner(1);

        Assertions.assertThat(userPlans.size()).isEqualTo(2);
        Assertions.assertThat(userPlans.get(0).getBudgetPlanOwner()).isEqualTo(1);
        Assertions.assertThat(userPlans.get(1).getBudgetPlanOwner()).isEqualTo(1);
    }

    @Test
    public void BudgetPlanRepository_GetPlanById_ReturnBudgetPlan () {
        BudgetPlan plan = BudgetPlan.builder()
                .budgetPlanOwner(1)
                .budgetPlanName("Test plan")
                .budgetPlanBalance(240.00)
                .budgetPlanMonthlyIncome(500.00)
                .budgetPlanMonthlyTarget(200.00)
                .budgetPlanType(BudgetPlanType.PERSONAL)
                .build();
        BudgetPlan newPlan = repository.save(plan);

        Optional<BudgetPlan> result = repository.findByBudgetPlanId(newPlan.getBudgetPlanId());

        Assertions.assertThat(result.isPresent()).isTrue();
        Assertions.assertThat(result.get()).isNotNull();
        Assertions.assertThat(result.get().getBudgetPlanId()).isEqualTo(newPlan.getBudgetPlanId());
    }

    @Test
    public void BudgetRepository_UpdateBudgetPlan_ReturnBudgetPlan () {
        BudgetPlan plan = BudgetPlan.builder()
                .budgetPlanOwner(1)
                .budgetPlanName("Test plan")
                .budgetPlanBalance(240.00)
                .budgetPlanMonthlyIncome(500.00)
                .budgetPlanMonthlyTarget(200.00)
                .budgetPlanType(BudgetPlanType.PERSONAL)
                .build();
        BudgetPlan newPlan = repository.save(plan);

        plan.setBudgetPlanBalance(400.00);
        BudgetPlan updatedPlan = repository.save(plan);

        Assertions.assertThat(updatedPlan).isNotNull();
        Assertions.assertThat(updatedPlan.getBudgetPlanId()).isEqualTo(newPlan.getBudgetPlanId());
        Assertions.assertThat(updatedPlan.getBudgetPlanBalance()).isEqualTo(400);
    }
}
