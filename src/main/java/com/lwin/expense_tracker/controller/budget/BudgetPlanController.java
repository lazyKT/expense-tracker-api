//package com.lwin.expense_tracker.controller.budget;
//
//
//import com.lwin.expense_tracker.service.budget.BudgetPlanServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/budgets")
//public class BudgetPlanController {
//
//    private final BudgetPlanServiceImpl service;
//
//    @Autowired
//    public BudgetPlanController (BudgetPlanServiceImpl service) {
//        this.service = service;
//    }
//
//    @GetMapping("/greet")
//    public String greet() {
//        return service.callSomeMethod();
//    }
//
//    @GetMapping("/secure")
//    public String secureGreet() {
//        return "Welcome to the secured place";
//    }
//
//    @GetMapping("/admin")
//    public String adminGreet() {
//        return service.adminOnlyService();
//    }
//
//    @GetMapping("/user")
//    @PreAuthorize("hasRole('ROLE_USER')")
//    public String userGreet() {
//        return "Hey user lwin here!";
//    }
//
//}
