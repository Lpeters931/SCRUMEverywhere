package FinanceTracker.userDatabase;

import java.io.*;
import java.util.*;
import java.nio.file.*;

public class UserFileManager {
    private final String directoryPath;

    public UserFileManager() {
        this.directoryPath = "FinanceTracker/src/FinanceTracker/userDatabase/users";
        // Create directory if it doesn't exist
        try {
            Files.createDirectories(Paths.get(directoryPath));
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }
    }

    // Creates a new user file with their information
    public boolean createUserFile(String username, String password) {
        // Generate file path for this user
        String filePath = directoryPath + File.separator + username + ".txt";

        // Check if user already exists
        if (userExists(username)) {
            System.out.println("User already exists: " + username);
            return false;
        }

        try (FileWriter fw = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            // Write basic user info to file
            out.println("username:" + username);
            out.println("password:" + password);

            System.out.println("User file created successfully for: " + username);
            return true;

        } catch (IOException e) {
            System.err.println("Error creating user file: " + e.getMessage());
            return false;
        }
    }

    // Add additional information to a user's file
    public boolean addUserInfo(String username, String key, String value) {
        if (!userExists(username)) {
            System.out.println("User doesn't exist: " + username);
            return false;
        }

        String filePath = directoryPath + File.separator + username + ".txt";

        try {
            // Read existing content
            List<String> fileContent = Files.readAllLines(Paths.get(filePath));

            // Check if key already exists
            boolean keyExists = false;
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).startsWith(key + ":")) {
                    fileContent.set(i, key + ":" + value);
                    keyExists = true;
                    break;
                }
            }

            // If key doesn't exist, add it
            if (!keyExists) {
                fileContent.add(key + ":" + value);
            }

            // Write updated content back to file
            Files.write(Paths.get(filePath), fileContent);

            return true;

        } catch (IOException e) {
            System.err.println("Error updating user file: " + e.getMessage());
            return false;
        }
    }


    // Retrieve a specific piece of user information
    public String getUserInfo(String username, String key) {
        if (!userExists(username)) {
            return null;
        }

        String filePath = directoryPath + File.separator + username + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(key + ":")) {
                    return line.substring(key.length() + 1);
                }
            }
            return null;
        } catch (IOException e) {
            System.err.println("Error reading user file: " + e.getMessage());
            return null;
        }
    }

    // Verify user credentials
    public boolean verifyUser(String username, String password) {
        if (!userExists(username)) {
            return false;
        }

        String storedPassword = getUserInfo(username, "password");
        return storedPassword != null && storedPassword.equals(password);
    }

    // Check if a user exists
    public boolean userExists(String username) {
        String filePath = directoryPath + File.separator + username + ".txt";
        return Files.exists(Paths.get(filePath));
    }

    // Get a map of all user information
    public Map<String, String> getAllUserInfo(String username) {
        if (!userExists(username)) {
            return null;
        }

        Map<String, String> userInfo = new HashMap<>();
        String filePath = directoryPath + File.separator + username + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int separatorPos = line.indexOf(':');
                if (separatorPos > 0) {
                    String key = line.substring(0, separatorPos);
                    String value = line.substring(separatorPos + 1);
                    userInfo.put(key, value);
                }
            }
            return userInfo;
        } catch (IOException e) {
            System.err.println("Error reading user file: " + e.getMessage());
            return null;
        }
    }

    // Delete a user
    public boolean deleteUser(String username) {
        if (!userExists(username)) {
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

    public int[] turnStringToArray(String string) {
        // First pass to count the number of integers
        int count = 0;
        boolean inNumber = false;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isDigit(c)) {
                if (!inNumber) {
                    count++;
                    inNumber = true;
                }
            } else {
                inNumber = false;
            }
        }

        // Create array with the correct size
        int[] array = new int[count];
        int index = 0;
        inNumber = false;
        int currentNumber = 0;

        // Second pass to extract the integers
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
                inNumber = true;
            } else if (inNumber) {
                // We've finished reading a number
                array[index++] = currentNumber;
                currentNumber = 0;
                inNumber = false;
            }
        }

        // Check if we need to add the last number
        if (inNumber) {
            array[index] = currentNumber;
        }

        return array;
    }

}