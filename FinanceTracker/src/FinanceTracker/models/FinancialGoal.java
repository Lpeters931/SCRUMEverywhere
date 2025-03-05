package FinanceTracker.models;

public class FinancialGoal {
    private String name;
    private float targetAmount;
    private float currentAmount;
    private String category;
    private String timeframe;
    private boolean isPaused; // Allows pausing the goal

    public FinancialGoal(String name, float targetAmount, String category, String timeframe) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.category = category;
        this.timeframe = timeframe;
        this.currentAmount = 0;
        this.isPaused = false;
    }

    public float getCurrentAmount() {
        return currentAmount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void addProgress(float amount) {
        if (isPaused) {
            System.out.println("Goal '" + name + "' is paused.");
            return;
        }

        this.currentAmount += amount;
        System.out.println(getProgressBar());

        if (this.currentAmount >= targetAmount) {
            System.out.println("🎉 Congratulations! Goal '" + name + "' reached!");
        } else {
            checkWarnings();
        }
    }

    public void adjustGoal(float newTarget) {
        this.targetAmount = newTarget;
        System.out.println("Goal '" + name + "' updated to $" + newTarget);
    }

    public void pauseGoal() {
        this.isPaused = !this.isPaused;
        System.out.println("Goal '" + name + "' is now " + (isPaused ? "paused" : "active") + ".");
    }

    public double getProgressPercentage() {
        return (currentAmount / targetAmount) * 100;
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

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + currentAmount + " / $" + targetAmount + "\n" + getProgressBar();
    }
}
