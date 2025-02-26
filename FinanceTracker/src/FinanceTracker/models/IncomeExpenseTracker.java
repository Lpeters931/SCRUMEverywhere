package FinanceTracker.models;

public class IncomeExpenseTracker {


    public void addIncome(String amount,User user){

        if(amount.isEmpty() || user == null){
            System.out.println("This cant be done");
        }else {
            float income = Float.parseFloat(amount);
            user.setMoney(income);
        }

    }
    










}
