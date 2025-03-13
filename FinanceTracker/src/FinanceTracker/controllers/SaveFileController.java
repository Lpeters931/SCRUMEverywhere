package FinanceTracker.controllers;

import FinanceTracker.models.User;
import FinanceTracker.userDatabase.fileManagers.UserFileManager;

public class SaveFileController {
    private final UserFileManager manager;

    public SaveFileController() {
        manager = new UserFileManager();
    }

    public void createUserFile(User user){
        manager.createUserFile(user.getUserName(), user.getPassword(), user.getBalance());
        manager.updateUserInfo(user.getUserName(), "income", String.valueOf(user.getTransactionHistory().getTotalIncome()));
        manager.updateUserInfo(user.getUserName(), "expense", String.valueOf(user.getTransactionHistory().getTotalExpense()));
    }

    public User pullUserFile(String username, String password){
        User user;
        String username
    }
}
