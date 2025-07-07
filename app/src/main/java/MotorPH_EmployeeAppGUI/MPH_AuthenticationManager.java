/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author ASPIRE 7
 */
public class MPH_AuthenticationManager {
            //  can be loaded from file

    private static final Map<String, String> credentials = new HashMap<>();

    static {
              try {
            loadFromCSV("accounts.csv");
        } catch (IOException ex) {
            // If the CSV can’t be read, fail fast:
            JOptionPane.showMessageDialog(null,
                "Failed to load credentials file: " + ex.getMessage(),
                "Startup Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    /** Read accounts.csv (in working dir) and populate credentials map. */
    private static void loadFromCSV(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String user = parts[0].trim();
                    String pass = parts[1].trim();
                    if (!user.isEmpty() && !pass.isEmpty()) {
                        credentials.put(user, pass);
                    }
                }
            }
        }
    }

    /** Returns true if username/password match an entry in the CSV. */
    public static boolean authenticate(String username, String password) {
        String stored = credentials.get(username);
        return stored != null && stored.equals(password);
    }
}