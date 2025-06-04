/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;
/**
 *
 * @author ASPIRE 7
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MPH_EmployeeTableModel_ArrayList extends AbstractTableModel {
    private final String[] columnNames = {
        "Employee Number",
        "Last Name",
        "First Name",
        "DOB",
        "Department",
        "Hourly Rate",
        "SSS Number",
        "PhilHealth Number",
        "TIN",
        "Pag-IBIG Number"
    };
    
    // The List of employees returned by your database manager.
    private final List<MPH_EmployeeClassList> employees;

    public MPH_EmployeeTableModel_ArrayList(List<MPH_EmployeeClassList> employees) {
        this.employees = employees;
        // Debug: show how many employees we have.
        System.out.println("MPH_EmployeeTableModel_List created with " + employees.size() + " employees.");
    }

    @Override
    public int getRowCount() {
        int rowCount = employees.size();
        System.out.println("getRowCount() called: " + rowCount);
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MPH_EmployeeClassList emp = employees.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0: value = emp.getEmployeeNumber(); break;
            case 1: value = emp.getLastName(); break;
            case 2: value = emp.getFirstName(); break;
            case 3: value = emp.getDateOfBirth(); break;
            case 4: value = emp.getDepartment(); break;
            case 5: value = emp.getHourlyRate(); break;
            case 6: value = emp.getSssNumber(); break;
            case 7: value = emp.getPhilHealth(); break;
            case 8: value = emp.getTin(); break;
            case 9: value = emp.getPagIbig(); break;
            default: value = "";
        }
        System.out.println("getValueAt(row=" + rowIndex + ", col=" + columnIndex + ") = " + value);
        return value;
    }
    public MPH_EmployeeClassList getEmployeeAt (int rowIndex){
        return employees.get(rowIndex);
    }
}
