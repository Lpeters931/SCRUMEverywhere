package FinanceTracker.userDatabase;

public class TransactionHistory {
    private float balance;
    private float totalIncome;
    private float totalExpense;

    private float updateUserHistory(float moneyGained, float moneySpent, float balance){
        balance += moneyGained;
        balance -= moneySpent;
        return balance;
    }

    private void showPreviousIncomeHistory(float balance, float moneyGained){
        System.out.println("Your current balance is $" + balance);
        System.out.println("Your current income is $" + totalIncome);
    }

    private void showPreviousExpensesHistory(float balance, float moneySpent){
        System.out.println("Your current balance is $" + balance);
        System.out.println("Your current expenses are $" + totalExpense);
    }

    public void gainMoney(float moneyGained){
        balance += moneyGained;
        updateUserHistory(moneyGained, 0, balance);
        totalIncome += moneyGained;
    }

    public void spendMoney(float moneySpent){
        balance -= moneySpent;
        updateUserHistory(0, moneySpent, balance);
        totalIncome += moneySpent;
    }
}
