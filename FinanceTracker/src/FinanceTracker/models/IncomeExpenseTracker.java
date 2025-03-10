package FinanceTracker.models;

public class IncomeExpenseTracker {


    public void addIncome(String amount,User user){

        if(amount.isEmpty() || user == null){
            System.out.println("This cant be done");
        }else {
            float income = Float.parseFloat(amount);

            user.setMoney(user.getMoney() + income);
        }

    }

    public void withdrawMoney(String amount,User user){
        float income = Float.parseFloat(amount);

        if(amount.isEmpty() || user == null){
            System.out.println("This cant be done");
        }else if(user.getMoney() <= 0.0f ){
            System.out.println("You are broke 0_0");
        }else if(income > user.getMoney()){
            System.out.println("\nYou dont have enough money -_-\n");
        }else{
            user.withdraw(income);
        }
    }


    public void trackExpense(String amount,User user){
        float expense = Float.parseFloat(amount);
        if(amount.isEmpty() || user == null){
            System.out.println("This cant be done");
        }else if(user.getMoney() <= 0.0f ){
            System.out.println("You are broke 0_0");
        }else if(expense > user.getMoney()){
            System.out.println("You dont have enough money -_-\n");
        }else{
            user.withdraw(expense);
        }

    }













}
