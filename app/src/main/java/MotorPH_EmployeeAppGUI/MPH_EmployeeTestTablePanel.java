/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MPH_EmployeeTestTablePanel extends JPanel {
    public MPH_EmployeeTestTablePanel() {
        setLayout(new BorderLayout());
        
        // Create an instance of your database manager.
        MPH_EmployeeManagerDatabase db = new MPH_EmployeeManagerDatabase();
        
        // Retrieve the List of employees.
        List<MPH_EmployeeClassList> employeeList = db.getEmployees();
        System.out.println("Test Panel: Employee list size = " + employeeList.size());
        
        // Create the list-based table model.
        MPH_EmployeeTableModel_ArrayList model = new MPH_EmployeeTableModel_ArrayList(employeeList);
        
        // Create and set up the JTable with the model.
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Test Table Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new MPH_EmployeeTestTablePanel());
            frame.setSize(800, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
