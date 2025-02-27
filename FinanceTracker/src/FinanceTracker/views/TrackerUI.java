package FinanceTracker.views;

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
        builder.append("\n6. Exit\n");
        System.out.println(builder.toString());

        try {
            input = br.readLine();
        } catch (IOException e) {
            System.out.println("ENTER SOMETHING");
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

        return input;
    }





}
