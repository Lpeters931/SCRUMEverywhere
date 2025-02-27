package FinanceTracker.models;

import FinanceTracker.userDatabase.fileManagers.UserFileManager;

public class User {
    private String userName;
    private String password;
    private float money = 0.0f;

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
    }

    public void withdraw(float amount) {
        money -= amount;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UserName:");
        builder.append(userName);
        builder.append("\nTotal Balance:");
        builder.append(money);
        return builder.toString();
    }

}
