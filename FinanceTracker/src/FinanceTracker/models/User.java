package FinanceTracker.models;

import java.util.ArrayList;

public class User {
    private String userName;
    private String password;
    private float money = 0.0f;
    private float totalIncome = 0.0f;
    private float totalSpent = 0.0f;


    public float getTotalIncome() {
        return totalIncome;
    }

    public float getTotalSpent() {
        return totalSpent;
    }

    public User(String userName, String password, float money) {
        setUserName(userName);
        setPassword(password);
        setMoney(money);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money += money;
        this.totalIncome += money;
    }

    public void withdraw(float amount) {
        money -= amount;
        totalSpent += amount;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserName:");
        builder.append(userName);
        builder.append("\nTotal Balance:");
        builder.append(money);
        builder.append("\nTotal Income:");
        builder.append(totalIncome);
        builder.append("\nTotal Spent:");
        builder.append(totalSpent);
        return builder.toString();
    }

}
