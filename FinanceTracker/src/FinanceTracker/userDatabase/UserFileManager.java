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
            out.println("username:" + encryption(username));
            out.println("password:" + encryption(password));
            out.println("money: 0");

            System.out.println("User file created successfully for: " + username);
            return true;

        } catch (IOException e) {
            System.err.println("Error creating user file: " + e.getMessage());
            return false;
        }
    }

    // Add additional information to a user's file
    public boolean updateUserInfo(String username, String key, String value) {
        if (!userExists(username)) {
            System.out.println("User doesn't exist: " + username);
            return false;
        }
        value = encryption(value);

        String filePath = directoryPath + File.separator + username + ".txt";

        try {
            // Read existing content
            List<String> fileContent = Files.readAllLines(Paths.get(filePath));

            // Updates relevant information
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).startsWith(key + ":")) {
                    fileContent.set(i, key + ":" + value);
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error updating user file: " + e.getMessage());
            return false;
        }
        return true;
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
                    return encryption(line.substring(key.length() + 1));
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

    private String encryption(String string){
        char[] chars = string.toCharArray();
        StringBuilder encryptedString = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            encryptedString.append(flipCharacter(chars[i]));
        }
        return encryptedString.toString();
    }

    private char flipCharacter(char letter){
        return switch (letter) {
            case 'a' -> 'z';
            case 'A' -> 'Z';
            case 'b' -> 'y';
            case 'B' -> 'Y';
            case 'c' -> 'x';
            case 'C' -> 'X';
            case 'd' -> 'w';
            case 'D' -> 'W';
            case 'e' -> 'v';
            case 'E' -> 'V';
            case 'f' -> 'u';
            case 'F' -> 'U';
            case 'g' -> 't';
            case 'G' -> 'T';
            case 'h' -> 's';
            case 'H' -> 'S';
            case 'i' -> 'r';
            case 'I' -> 'R';
            case 'j' -> 'q';
            case 'J' -> 'Q';
            case 'k' -> 'p';
            case 'K' -> 'P';
            case 'l' -> 'o';
            case 'L' -> 'O';
            case 'm' -> 'n';
            case 'M' -> 'N';
            case 'n' -> 'm';
            case 'N' -> 'M';
            case 'o' -> 'l';
            case 'O' -> 'L';
            case 'p' -> 'k';
            case 'P' -> 'K';
            case 'q' -> 'j';
            case 'Q' -> 'J';
            case 'r' -> 'i';
            case 'R' -> 'I';
            case 's' -> 'h';
            case 'S' -> 'H';
            case 't' -> 'g';
            case 'T' -> 'G';
            case 'u' -> 'f';
            case 'U' -> 'F';
            case 'v' -> 'e';
            case 'V' -> 'E';
            case 'w' -> 'd';
            case 'W' -> 'D';
            case 'x' -> 'c';
            case 'X' -> 'C';
            case 'y' -> 'b';
            case 'Y' -> 'B';
            case 'z' -> 'a';
            case 'Z' -> 'A';
            default -> letter;
        };
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

}