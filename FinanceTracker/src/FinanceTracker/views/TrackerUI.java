package FinanceTracker.views;

import FinanceTracker.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrackerUI {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String displayMenu() {
        String input = "";

        StringBuilder builder = new StringBuilder();
        builder.append("\nWelcome to the SCRUM Finance Tracker\n");
        builder.append("\n1. Create Account\n");
        builder.append("\n2. Deposit Money\n");
        builder.append("\n3. Withdraw Money\n");
        builder.append("\n4. Set finance goals\n");
        builder.append("\n5. Spend money\n");
        builder.append("\n6. View Transaction History\n");
        builder.append("\n7. Exit\n");
        System.out.println(builder.toString());

        try {
            input = br.readLine();
        } catch (IOException e) {
            System.out.println("ENTER SOMETHING");
            return displayMenu();
        }

        return input;

    }

    public String depositMenu() {
        String input = "";
        StringBuilder builder = new StringBuilder();
        builder.append("\nPlease Enter the amount you are depositing: \n");
        System.out.println(builder.toString());

        try{
            input = br.readLine();
        }catch(IOException e){
            System.out.println("ENTER SOMETHING");
        }

        try {
            float amount = Float.parseFloat(input);
        }catch(NumberFormatException e){
            System.out.println("THAT WASNT A NUMBER!!!!!!");
            return depositMenu();
        }

        return input;
    }

    public String withdrawMenu() {
        String input = "";
        StringBuilder builder = new StringBuilder();
        builder.append("\nPlease Enter the amount you are withdrawing: \n");
        System.out.println(builder.toString());

        try{
            input = br.readLine();
        }catch(IOException e){
            System.out.println("ENTER SOMETHING");
        }

        try {
            float amount = Float.parseFloat(input);
        }catch(NumberFormatException e){
            System.out.println("THAT WASNT A NUMBER!!!!!!");
            return depositMenu();
        }

        return input;
    }

    public void displayUser(User user){
        System.out.println(user.toString());
    }

    public void goodBye(){
        System.out.println("Goodbye for now");
    }


    public void displayTransactionHistory(float balance,float totalIncome,float expenses){
        StringBuilder builder = new StringBuilder();
        builder.append("\nTRANSACTION HISTORY \n");
        builder.append("\nBALANCE: " + balance + "\n");
        builder.append("\nTOTAL INCOME: " + totalIncome + "\n");
        builder.append("\nEXPENSES: " + expenses + "\n");
        System.out.println(builder.toString());

    }

    public String spendMoney(){
        String input = "";
        StringBuilder builder = new StringBuilder();
        builder.append("\nPlease Enter the amount spent: \n");
        System.out.println(builder.toString());

        try {
         input = br.readLine();
        }catch(IOException e){
            System.out.println("ENTER SOMETHING");
        }

        try{
            float amount = Float.parseFloat(input);
        }catch(NumberFormatException e){
            System.out.println("THAT WASNT A NUMBER!!!!!!");
        }

        return input;

    }







}
