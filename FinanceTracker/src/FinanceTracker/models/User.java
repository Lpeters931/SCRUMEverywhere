package FinanceTracker.models;

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
}
