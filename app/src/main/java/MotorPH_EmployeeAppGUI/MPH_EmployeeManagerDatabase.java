/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class MPH_EmployeeManagerDatabase {

    private static MPH_EmployeeManagerDatabase instance;

    // The ArrayList holding all employee records.
    private List<MPH_EmployeeClassList> employees;

    public boolean updateEmployee(String empID,
            String lastName, String firstName,
            String sss, String philHealth, String tin,
            String pagIbig, String dob,
            String department, String hourlyRate) {
        System.out.println("Trying to update Employee ID: " + empID);

        for (MPH_EmployeeClassList emp : employees) {
            System.out.println("Checking Employee ID: " + emp.getEmployeeNumber());
            if (emp.getEmployeeNumber().equals(empID)) {
                System.out.println("Employee found! Updating...");
                emp.setLastName(lastName);
                emp.setFirstName(firstName);
                emp.setSssNumber(sss);
                emp.setPhilHealth(philHealth);
                emp.setTin(tin);
                emp.setPagIbig(pagIbig);
                emp.setDateOfBirth(dob);
                emp.setDepartment(department);
                emp.setHourlyRate(hourlyRate);
                System.out.println("After update, first name = " + emp.getFirstName());
                return true; // Update succeeded.
            }
        }
        return false; // Employee not found.
    }

    // Constructor automatically initializes and loads data.
    public MPH_EmployeeManagerDatabase() {
        employees = new ArrayList<>();
        loadEmployeesFromCSV();
    }

    public static MPH_EmployeeManagerDatabase getInstance() {
        if (instance == null) {
            instance = new MPH_EmployeeManagerDatabase();
        }
        return instance;
    }
    // Adds a new employee to the list

    public void addEmployee(MPH_EmployeeClassList emp) {
        employees.add(emp);
    }

    // Returns the complete list of employees.
    public List<MPH_EmployeeClassList> getEmployees() {
        return employees;
    }

    // Loads all employee data into the list.
    private void loadEmployeeData() {
        addEmployee(new MPH_EmployeeClassList("10001", "Garcia", "Manuel III",
                "44-4506057-3", "820126853951", "442-605-657-000",
                "691295330870", "1983-10-11", "CEO", "535.71"));
        addEmployee(new MPH_EmployeeClassList("10002", "Lim", "Antonio",
                "52-2061274-9", "331735646338", "683-102-776-000",
                "663904995411", "1988-06-19", "COO", "357.14"));
        addEmployee(new MPH_EmployeeClassList("10003", "Aquino", "Bianca Sofia",
                "30-8870406-2", "177451189665", "971-711-280-000",
                "171519773969", "1989-08-04", "CFO", "357.14"));
        addEmployee(new MPH_EmployeeClassList("10004", "Reyes", "Isabella",
                "40-2511815-0", "341911411254", "876-809-437-000",
                "416946776041", "1994-06-16", "CMO", "357.14"));
        addEmployee(new MPH_EmployeeClassList("10005", "Hernandez", "Eduard",
                "50-5577638-1", "957436191812", "031-702-374-000",
                "952347222457", "1989-09-23", "IT Ops", "313.51"));
        addEmployee(new MPH_EmployeeClassList("10006", "Villanueva", "Andrea Mae",
                "49-1632020-8", "382189453145", "317-674-022-000",
                "441093369646", "1988-02-14", "HR Manager", "313.51"));
        addEmployee(new MPH_EmployeeClassList("10007", "San Jose", "Brad",
                "40-2400714-1", "239192926939", "672-474-690-000",
                "210850209964", "1996-03-15", "HR Team Leader", "255.80"));
        addEmployee(new MPH_EmployeeClassList("10008", "Romualdez", "Alice",
                "55-4476527-2", "545652640232", "888-572-294-000",
                "211385556888", "1992-05-14", "HR Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10009", "Atienza", "Rosie",
                "41-0644692-3", "708988234853", "604-997-793-000",
                "260107732354", "1948-09-24", "HR Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10010", "Alvaro", "Roderick",
                "64-7605054-4", "578114853194", "525-420-419-000",
                "799254095212", "1988-03-30", "Accounting Head", "313.51"));
        addEmployee(new MPH_EmployeeClassList("10011", "Salcedo", "Anthony",
                "26-9647608-3", "126445315651", "210-805-911-000",
                "218002473454", "1993-09-14", "Payroll Manager", "302.53"));
        addEmployee(new MPH_EmployeeClassList("10012", "Lopez", "Josie",
                "44-8563448-3", "431709011012", "218-489-737-000",
                "113071293354", "1987-01-14", "Payroll Team Leader", "229.02"));
        addEmployee(new MPH_EmployeeClassList("10013", "Farala", "Martha",
                "45-5656375-0", "233693897247", "210-835-851-000",
                "631130283546", "1942-01-11", "Payroll Rank and File", "142.86"));
        addEmployee(new MPH_EmployeeClassList("10014", "Martinez", "Leila",
                "27-2090996-4", "515741057496", "275-792-513-000",
                "101205445886", "1970-07-11", "Payroll Rank and File", "142.86"));
        addEmployee(new MPH_EmployeeClassList("10015", "Romualdez", "Fredrick",
                "26-8768374-1", "308366860059", "598-065-761-000",
                "22305770785", "1985-03-10", "Account Manager", "318.45"));
        addEmployee(new MPH_EmployeeClassList("10016", "Mata", "Christian",
                "49-2959312-6", "824187961962", "103-100-522-000",
                "631052853464", "1987-10-21", "Account Team Leader", "255.80"));
        addEmployee(new MPH_EmployeeClassList("10017", "De Leon", "Selena",
                "27-2090208-8", "587272469938", "482-259-498-000",
                "719007608464", "1975-02-20", "Account Team Leader", "249.11"));
        addEmployee(new MPH_EmployeeClassList("10018", "San Jose", "Allison",
                "45-3251383-0", "745148459521", "121-203-336-000",
                "114901859343", "1986-06-24", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10019", "Rosario", "Cydney",
                "49-1629900-2", "579253435499", "122-244-511-000",
                "265104358643", "1996-10-06", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10020", "Bautista", "Mark",
                "49-1647342-5", "399665157135", "273-970-941-000",
                "260054585575", "1991-02-12", "Account Rank and File", "138.39"));
        addEmployee(new MPH_EmployeeClassList("10021", "Lazaro", "Darlene",
                "45-5617168-2", "606386917510", "354-650-951-000",
                "104907708845", "1985-11-25", "Account Rank and File", "138.39"));
        addEmployee(new MPH_EmployeeClassList("10022", "Delos Santos", "Kolby",
                "52-0109570-6", "357451271274", "187-500-345-000",
                "113017988667", "1980-02-26", "Account Rank and File", "142.86"));
        addEmployee(new MPH_EmployeeClassList("10023", "Santos", "Vella",
                "52-9883524-3", "548670482885", "101-558-994-000",
                "360028104576", "1983-12-31", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10024", "Del Rosario", "Tomas",
                "45-5866331-6", "953901539995", "560-735-732-000",
                "913108649964", "1978-12-18", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10025", "Tolentino", "Jacklyn",
                "47-1692793-0", "753800654114", "841-177-857-000",
                "210546661243", "1984-05-19", "Account Rank and File", "142.86"));
        addEmployee(new MPH_EmployeeClassList("10026", "Gutierrez", "Percival",
                "40-9504657-8", "797639382265", "502-995-671-000",
                "210897095686", "1970-12-18", "Account Rank and File", "147.32"));
        addEmployee(new MPH_EmployeeClassList("10027", "Manalaysay", "Garfield",
                "45-3298166-4", "810909286264", "336-676-445-000",
                "211274476563", "1989-08-28", "Account Rank and File", "147.32"));
        addEmployee(new MPH_EmployeeClassList("10028", "Villegas", "Lizeth",
                "40-2400719-4", "934389652994", "210-395-397-000",
                "122238077997", "1981-12-12", "Account Rank and File", "142.86"));
        addEmployee(new MPH_EmployeeClassList("10029", "Ramos", "Carol",
                "60-1152206-4", "351830469744", "395-032-717-000",
                "212141893454", "1978-08-20", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10030", "Maceda", "Emelia",
                "54-1331005-0", "465087894112", "215-973-013-000",
                "515012579765", "1973-04-14", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10031", "Aguilar", "Delia",
                "52-1859253-1", "136451303068", "599-312-588-000",
                "110018813465", "1989-01-27", "Account Rank and File", "133.93"));
        addEmployee(new MPH_EmployeeClassList("10032", "Castro", "John Rafael",
                "26-7145133-4", "601644902402", "404-768-309-000",
                "697764069311", "1992-02-09", "Sales & Marketing", "313.51"));
        addEmployee(new MPH_EmployeeClassList("10033", "Martinez", "Carlos Ian",
                "11-5062972-7", "380685387212", "256-436-296-000",
                "993372963726", "1990-11-16", "Supply Chain and Logistics", "313.51"));
        addEmployee(new MPH_EmployeeClassList("10034", "Santos", "Beatriz",
                "20-2987501-5", "918460050077", "911-529-713-000",
                "874042259378", "1990-08-07", "Customer Service and Relations", "313.51"));
    }

    /**
     * Loads employee records from the CSV file "employees.csv" into the
     * in-memory list. Expects the first line of the CSV to be a header row.
     */
    private void loadEmployeesFromCSV() {
        String filePath = "employees.csv";  // Adjust the path if necessary.
        File csvFile = new File(filePath);
        if (!csvFile.exists()) {
            System.out.println("CSV file not found: " + csvFile.getAbsolutePath());
            return; // No file, so nothing to load.
        }
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean isFirstLine = true;  // Used to skip the header row.
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;  // Skip the header row.
                }
                // Skip empty lines.
                if (line.trim().isEmpty()) {
                    System.out.println("Skipping empty line at " + lineNumber);
                    continue;
                }
                // Split the line into fields.
                String[] data = line.split(",");
                if (data.length != 10) {
                    System.out.println("Skipping line " + lineNumber
                            + " (unexpected number of columns): " + line);
                    continue;
                }
                // Trim fields to remove any extra white space.
                for (int i = 0; i < data.length; i++) {
                    data[i] = data[i].trim();
                }
                // Create a new employee instance using the CSV data.
                MPH_EmployeeClassList employee = new MPH_EmployeeClassList(
                        data[0], // EmployeeID
                        data[1], // LastName
                        data[2], // FirstName
                        data[3], // SSS
                        data[4], // PhilHealth
                        data[5], // TIN
                        data[6], // PagIbig
                        data[7], // DOB
                        data[8], // Department
                        data[9] // HourlyRate
                );
                employees.add(employee);
                System.out.println("Loaded employee (line " + lineNumber + "): "
                        + data[2] + " " + data[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends a new employee record to the CSV file. This method creates the
     * CSV file with a header if it doesn't already exist.
     *
     * @param newEmployee the employee object to append.
     */
    public void writeEmployeeToCSV(MPH_EmployeeClassList newEmployee) {
        String filePath = "employees.csv";
        File csvFile = new File(filePath);

        // If the CSV file doesn't exist, create it and write the header.
        if (!csvFile.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
                writer.println("EmployeeID,LastName,FirstName,SSS,PhilHealth,TIN,PagIbig,DOB,Department,HourlyRate");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean needsNewline = false;
        if (csvFile.exists() && csvFile.length() > 0) {
            try (RandomAccessFile raf = new RandomAccessFile(csvFile, "r")) {
                raf.seek(csvFile.length() - 1);
                byte lastByte = raf.readByte();
                if (lastByte != '\n' && lastByte != '\r') {
                    needsNewline = true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Append the new employee record using try-with-resources.
        try (FileWriter fw = new FileWriter(filePath, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {
            if (needsNewline) {
                out.println();
            }
            out.println(newEmployee.getEmployeeNumber() + ","
                    + newEmployee.getLastName() + ","
                    + newEmployee.getFirstName() + ","
                    + newEmployee.getSssNumber() + ","
                    + newEmployee.getPhilHealth() + ","
                    + newEmployee.getTin() + ","
                    + newEmployee.getPagIbig() + ","
                    + newEmployee.getDateOfBirth() + ","
                    + newEmployee.getDepartment() + ","
                    + newEmployee.getHourlyRate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Method to "refresh" the CSV - for updating and deleting:

    public void writeAllEmployeesToCSV() {
        String filePath = "employees.csv";
        File csvFile = new File(filePath);

        try (FileWriter fw = new FileWriter(csvFile); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            // Write the header line.
            out.println("EmployeeID,LastName,FirstName,SSS,PhilHealth,TIN,PagIbig,DOB,Department,HourlyRate");

            // Loop through the entire employee list.
            for (MPH_EmployeeClassList emp : employees) {
                out.println(emp.getEmployeeNumber() + ","
                        + emp.getLastName() + ","
                        + emp.getFirstName() + ","
                        + emp.getSssNumber() + ","
                        + emp.getPhilHealth() + ","
                        + emp.getTin() + ","
                        + emp.getPagIbig() + ","
                        + emp.getDateOfBirth() + ","
                        + emp.getDepartment() + ","
                        + emp.getHourlyRate());
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Consider handling the error by logging or alerting the user.
        }
    }

    // Helper method to print employee details (for debugging/testing).
    public void printAllEmployees() {
        for (MPH_EmployeeClassList emp : employees) {
            System.out.println("Employee Number: " + emp.getEmployeeNumber());
            System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("SSS Number: " + emp.getSssNumber());
            System.out.println("PhilHealth Number: " + emp.getPhilHealth());
            System.out.println("TIN: " + emp.getTin());
            System.out.println("Pag-IBIG Number: " + emp.getPagIbig());
            System.out.println("Date of Birth: " + emp.getDateOfBirth());
            System.out.println("Department: " + emp.getDepartment());
            System.out.println("Hourly Rate: " + emp.getHourlyRate());
            System.out.println("------------------------");
        }
    }

    // Main method for standalone testing
    public static void main(String[] args) {
        System.out.println("CSV absolute path: " + new File("employees.csv").getAbsolutePath());
        MPH_EmployeeManagerDatabase manager = new MPH_EmployeeManagerDatabase();
        manager.printAllEmployees();
    }
}
