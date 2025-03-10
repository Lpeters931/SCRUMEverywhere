package FinanceTracker.controller;

import FinanceTracker.models.User;
import FinanceTracker.userDatabase.fileManagers.UserFileManager;

public class SaveFileController {
    private final UserFileManager manager;

    public SaveFileController() {
        manager = new UserFileManager();
    }

    public void createNewUser(User user) {
        manager.createUserFile(user.getUserName(), user.getPassword(), user.getMoney());
    }

    public void updateUserFile(User user) {
        manager.updateUserInfo(user.getUserName(), "money", String.valueOf(user.getMoney()));
        manager.updateUserInfo(user.getUserName(), "income", String.valueOf(user.getTotalIncome()));
        manager.updateUserInfo(user.getUserName(), "expense", String.valueOf(user.getTotalExpense()));
    }

    public User pullUserFile() {
        User user;
    }
}
