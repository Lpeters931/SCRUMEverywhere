package FinanceTracker.controllers;

import FinanceTracker.models.FinancialGoal;
import java.util.ArrayList;

public class GoalManager {
    private ArrayList<FinancialGoal> goals;

    public GoalManager() {
        goals = new ArrayList<>();
    }

    public void addGoal(FinancialGoal goal) {
        goals.add(goal);
        System.out.println("Added new goal: " + goal.getName());
    }

    public void updateGoalProgress(String goalName, float amount) {
        for (FinancialGoal goal : goals) {
            if (goal.getName().equalsIgnoreCase(goalName)) {
                goal.addProgress(amount);
                return;
            }
        }
        System.out.println("❌ Goal not found.");
    }

    public void adjustGoal(String goalName, float newTarget) {
        for (FinancialGoal goal : goals) {
            if (goal.getName().equalsIgnoreCase(goalName)) {
                goal.adjustGoal(newTarget);
                return;
            }
        }
        System.out.println("❌ Goal not found.");
    }

    public void pauseGoal(String goalName) {
        for (FinancialGoal goal : goals) {
            if (goal.getName().equalsIgnoreCase(goalName)) {
                goal.pauseGoal();
                return;
            }
        }
        System.out.println("❌ Goal not found.");
    }

    public void listGoals() {
        if (goals.isEmpty()) {
            System.out.println("No financial goals set.");
        } else {
            for (FinancialGoal goal : goals) {
                System.out.println(goal);
            }
        }
    }

    public void generateReport() {
        System.out.println("\n📊 Financial Goal Report:");
        double totalSavings = 0, totalInvestments = 0, totalSpending = 0, totalDebt = 0, totalEmergency = 0;

        for (FinancialGoal goal : goals) {
            switch (goal.getCategory().toLowerCase()) {
                case "savings": totalSavings += goal.getCurrentAmount(); break;
                case "investment": totalInvestments += goal.getCurrentAmount(); break;
                case "spending": totalSpending += goal.getCurrentAmount(); break;
                case "debt repayment": totalDebt += goal.getCurrentAmount(); break;
                case "emergency fund": totalEmergency += goal.getCurrentAmount(); break;
            }
        }

        System.out.println("💰 Savings: $" + totalSavings);
        System.out.println("📈 Investments: $" + totalInvestments);
        System.out.println("💸 Spending: $" + totalSpending);
        System.out.println("🏦 Debt Repayment: $" + totalDebt);
        System.out.println("🚨 Emergency Fund: $" + totalEmergency);
    }
}
