package FinanceTracker.controllers;

import FinanceTracker.models.IncomeExpenseTracker;
import FinanceTracker.models.User;
import FinanceTracker.views.GoalUI;
import FinanceTracker.views.TrackerUI;

public class TrackerController {
    TrackerUI input = new TrackerUI();
    GoalUI goal = new GoalUI();
    IncomeExpenseTracker manager = new IncomeExpenseTracker();
    User test = new User("XPenguinGodX", "1234", 0.0f);


    public void financeTracker() {
        boolean running = true;
        while (running) {
            String choice = input.displayMenu();

            switch (choice) {
                case "1":
                    break;
                case "2":
                    String depositing = input.depositMenu();
                    manager.addIncome(depositing, test);
                    input.displayUser(test);
                    break;
                case "3":
                    String withdrawing = input.withdrawMenu();
                    manager.withdrawMoney(withdrawing, test);
                    input.displayUser(test);
                    break;
                case "4":
                    goal.run();
                    break;
                case "5":
                    manager.trackExpense(input.spendMoney(), test);
                    System.out.println(test);
                    break;
                case "6":
                    input.displayTransactionHistory(test.getMoney(),test.getTotalIncome(), test.getTotalExpense());
                    break;
                case "7":
                    running = false;
                    input.goodBye();
                    break;
            }

        }

    }
}
