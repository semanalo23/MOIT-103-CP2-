/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author ASPIRE 7
 */
public class MPH_EmployeeManagerDatabase {

    // The ArrayList holding your employees.
    private List<MPH_EmployeeClassList> employees;

    public MPH_EmployeeManagerDatabase() {
        employees = new ArrayList<>();
    }

    // Adds a new employee to the list.
    public void addEmployee(MPH_EmployeeClassList emp) {
        employees.add(emp);
    }

    // Returns the list of employees.
    public List<MPH_EmployeeClassList> getEmployees() {
        return employees;
    }

    // Helper method to print details of all employees (for debugging/testing).
    public void printAllEmployees() {
        for (MPH_EmployeeClassList emp : employees) {
            System.out.println("Employee Number: " + emp.getEmployeeNumber());
            System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("SSS Number: " + emp.getSssNumber());
            System.out.println("PhilHealth Number: " + emp.getPhilHealth());
            System.out.println("TIN: " + emp.getTin());
            System.out.println("Pag-IBIG Number: " + emp.getPagIbig());
            System.out.println("------------------------");
        }
    }

    // A simple main method to test out the ArrayList functionality.
    public static void main(String[] args) {
        MPH_EmployeeManagerDatabase manager = new MPH_EmployeeManagerDatabase();

        // Create some employee instances.
        MPH_EmployeeClassList emp1 = new MPH_EmployeeClassList("10001", "Garcia", "Manuel III", "44-4506057-3", "820126853951", "442-605-657-000", "691295330870");
        MPH_EmployeeClassList emp2 = new MPH_EmployeeClassList("10002", "Lim", "Antonio", "52-2061274-9", "331735646338", "683-102-776-000", "663904995411");

        // Add them to the manager.
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);

        // Print out the employees to verify everything is working.
        manager.printAllEmployees();
    }
}

