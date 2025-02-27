package FinanceTracker.views;
import FinanceTracker.controllers.GoalManager;
import FinanceTracker.models.FinancialGoal;
import java.util.Scanner;
public class GoalUI {
    public void run() {
        GoalManager goalManager = new GoalManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📊 Financial Tracker Menu");
            System.out.println("1️⃣ Add Goal");
            System.out.println("2️⃣ Update Goal Progress");
            System.out.println("3️⃣ Adjust Goal");
            System.out.println("4️⃣ Pause/Resume Goal");
            System.out.println("5️⃣ List Goals");
            System.out.println("6️⃣ Generate Report");
            System.out.println("7️⃣ Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter goal name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter target amount: ");
                    float amount = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Enter category (Savings, Spending, Investment, Debt Repayment, Emergency Fund): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter timeframe (Daily, Weekly, Monthly, Yearly): ");
                    String timeframe = scanner.nextLine();

                    goalManager.addGoal(new FinancialGoal(name, amount, category, timeframe));
                    break;

                case 2:
                    System.out.print("Enter goal name to update: ");
                    String goalName = scanner.nextLine();
                    System.out.print("Enter amount to add: ");
                    float addAmount = scanner.nextFloat();
                    goalManager.updateGoalProgress(goalName, addAmount);
                    break;

                case 3:
                    System.out.print("Enter goal name to adjust: ");
                    String adjustName = scanner.nextLine();
                    System.out.print("Enter new target amount: ");
                    float newTarget = scanner.nextFloat();
                    goalManager.adjustGoal(adjustName, newTarget);
                    break;

                case 4:
                    System.out.print("Enter goal name to pause/resume: ");
                    String pauseName = scanner.nextLine();
                    goalManager.pauseGoal(pauseName);
                    break;

                case 5:
                    goalManager.listGoals();
                    break;

                case 6:
                    goalManager.generateReport();
                    break;

                case 7:
                    System.out.println("Exiting... 🚪");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice, try again.");
            }
        }
    }
}