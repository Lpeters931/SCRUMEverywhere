package FinanceTracker.models;

public class FinancialGoal {
    private String name;
    private double targetAmount;
    private double currentAmount;
    private String category; //like Savings, Spending, Investment, etc.
    private String timeframe; // Daily, Weekly, Monthly, Yearly
    private boolean isPaused;

    public FinancialGoal(String name, double targetAmount, String category, String timeframe) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.category = category;
        this.timeframe = timeframe;
        this.currentAmount = 0; // Start at 0
        this.isPaused = false;
    }

    public void addProgress(double amount) {
        if (isPaused) {
            System.out.println("Goal " + name + " is paused");
            return;
        }
        this.currentAmount += amount;
        if (this.currentAmount >= targetAmount) {
            System.out.println("Congratulations! Goal '" + name + "' reached!");
        } else {
            checkWarnings();
        }
    }

    public void adjustGoal(double newTarget) {
        this.targetAmount += newTarget;
        System.out.println("Goal " + name + " updated  to $" + newTarget);
    }

    public void pauseGoal() {
        this.isPaused = !this.isPaused;
        System.out.println("Goal '" + name + "' is now " + (isPaused ? "paused" : "active") + ".");
    }

    private void checkWarnings() {
        double percentage = getProgressPercentage();
        if (percentage >= 90) {
            System.out.println("⚠️ Warning: You are very close to exceeding your limit!");
        } else if (percentage >= 75) {
            System.out.println("✅ You're at 75% progress! Keep going!");
        } else if (percentage >= 50) {
            System.out.println("🔵 Halfway there! You've reached 50%.");
        }
    }

    public String getProgressBar() {
        int barLength = 20;
        int filledLength = (int) ((getProgressPercentage() / 100) * barLength);
        String bar = "[" + "=".repeat(filledLength) + " ".repeat(barLength - filledLength) + "] "
                + String.format("%.2f", getProgressPercentage()) + "%";
        if (getProgressPercentage() >= 100) {
            return "✅ " + bar;
        } else if (getProgressPercentage() >= 90) {
            return "🔴 " + bar;
        } else if (getProgressPercentage() >= 75) {
            return "🟡 " + bar;
        } else {
            return "🟢 " + bar;
        }
    }


    // Check progress percentage
    public double getProgressPercentage() {
        return (currentAmount / targetAmount) * 100;
    }

    public String getName() {
        return name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public String getCategory() {
        return category;
    }

    public String getTimeframe() {
        return timeframe;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + currentAmount + " / $" + targetAmount + "\n" + getProgressBar();
    }
}
