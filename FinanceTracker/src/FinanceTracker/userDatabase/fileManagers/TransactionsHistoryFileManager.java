package FinanceTracker.userDatabase.fileManagers;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class TransactionsHistoryFileManager {
    private final String directoryPath;
    private final UserFileManager userFileManager;

    public TransactionsHistoryFileManager() {
        this.directoryPath = "FinanceTracker/src/FinanceTracker/userDatabase/transactionsHistory";
        this.userFileManager = new UserFileManager();
        // Create directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get(directoryPath));
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }
    }

    // Creates a new user file with their information
    public void createUserFile(String username) {
        // Generate file path for this user
        username = encryption(username);
        String filePath = directoryPath + File.separator + username + ".txt";

        // Check if user already exists
        if (historyExists(username)) {
            System.out.println("User already exists: " + username);
        }

        try (FileWriter fw = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            String balance = userFileManager.getUserInfo(encryption(username), "money");
            // Write Transaction History info to file
            out.println(encryption("username: ") + username);
            out.println(encryption("balance: ") + balance);


        } catch (IOException e) {
            System.err.println("Error creating user file: " + e.getMessage());
        }
    }

    // Add additional information to a user's file
    public boolean updateUserInfo(String username, String key, String value) {
        username = encryption(username);
        key = encryption(key);
        value = encryption(value);

        if (!historyExists(username)) {
            System.out.println("User doesn't exist: " + username);
            return false;
        }

        String filePath = directoryPath + File.separator + username + ".txt";

        try {
            // Read existing content
            Path path = Paths.get(filePath);
            List<String> fileContent = Files.readAllLines(path);
            boolean keyFound = false;

            // Updates relevant information
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).startsWith(key + ": ")) {
                    fileContent.set(i, key + ": " + value);
                    keyFound = true;
                }
            }

            // If key was found and updated, write back to file
            if (keyFound) {
                Files.write(path, fileContent);
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            System.err.println("Error updating user file: " + e.getMessage());
            return false;
        }
    }


    // Retrieve a specific piece of user information
    public String getUserInfo(String username, String key) {
        username = encryption(username);
        key = encryption(key);

        if (!historyExists(username)) {
            return null;
        }

        String filePath = directoryPath + File.separator + username + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(key + ":")) {
                    return encryption(line.substring(key.length() + 2));
                }
            }
            return null;
        } catch (IOException e) {
            System.err.println("Error reading user file: " + e.getMessage());
            return null;
        }
    }

    // Check if a user exists
    public boolean historyExists(String username) {
        String filePath = directoryPath + File.separator + username + ".txt";
        return Files.exists(Paths.get(filePath));
    }

    private String encryption(String string){
        char[] chars = string.toCharArray();
        StringBuilder encryptedString = new StringBuilder();
        return encryptedString.toString();
    }


    // Delete a user
    public boolean deleteUser(String username) {
        username = encryption(username);
        if (!historyExists(username)) {
            return false;
        }

        String filePath = directoryPath + File.separator + username + ".txt";
        try {
            return Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            System.err.println("Error deleting user file: " + e.getMessage());
            return false;
        }
    }

}