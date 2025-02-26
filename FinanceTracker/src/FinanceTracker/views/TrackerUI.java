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
        builder.append("1. Create Account");
        builder.append("2. Deposit Money");
        builder.append("3. Withdraw Money");
        builder.append("4. Set finance goals");
        builder.append("5. Spend money");
        builder.append("6. Exit");
        System.out.println(builder.toString());

        try {
            input = br.readLine();
        } catch (IOException e) {
            System.out.println("ENTER SOMETHING");
        }

        return input;

    }





}
