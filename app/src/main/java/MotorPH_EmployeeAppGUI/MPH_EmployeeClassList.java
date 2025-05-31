/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

/**
 *
 * @author ASPIRE 7
 */
public class MPH_EmployeeClassList {

    public static final int EMPLOYEE_NUMBER_INDEX = 0;
    public static final int LAST_NAME_INDEX = 1;
    public static final int FIRST_NAME_INDEX = 2;
    public static final int SSS_NUMBER_INDEX = 3;
    public static final int PHILHEALTH_INDEX = 4;
    public static final int TIN_INDEX = 5;
    public static final int PAGIBIG_INDEX = 6;
    public static final int DOB_INDEX = 7;
    public static final int DEPARTMENT_INDEX = 8;
    public static final int HOURLY_RATE_INDEX = 9;

    private String[] details;

    public MPH_EmployeeClassList(String employeeNumber, String lastName, String firstName,
            String sssNumber, String philHealthNumber, String tin,
            String pagIbigNumber, String dateOfBirth, String department, String hourlyRate) {
        details = new String[10];
        details[EMPLOYEE_NUMBER_INDEX] = employeeNumber;
        details[LAST_NAME_INDEX] = lastName;
        details[FIRST_NAME_INDEX] = firstName;
        details[SSS_NUMBER_INDEX] = sssNumber;
        details[PHILHEALTH_INDEX] = philHealthNumber;
        details[TIN_INDEX] = tin;
        details[PAGIBIG_INDEX] = pagIbigNumber;
        details[DOB_INDEX] = dateOfBirth;
        details[DEPARTMENT_INDEX] = department;
        details[HOURLY_RATE_INDEX] = hourlyRate;
    }

    // Getters:
    public String getEmployeeNumber() {
        return details[EMPLOYEE_NUMBER_INDEX];
    }

    public String getLastName() {
        return details[LAST_NAME_INDEX];
    }

    public String getFirstName() {
        return details[FIRST_NAME_INDEX];
    }

    public String getSssNumber() {
        return details[SSS_NUMBER_INDEX];
    }

    public String getPhilHealth() {
        return details[PHILHEALTH_INDEX];
    }

    public String getTin() {
        return details[TIN_INDEX];
    }

    public String getPagIbig() {
        return details[PAGIBIG_INDEX];

    }

    public String getDateOfBirth() {
        return details[DOB_INDEX];
    }

    public String getDepartment() {
        return details[DEPARTMENT_INDEX];
    }

    public String getHourlyRate() {
        return details[HOURLY_RATE_INDEX];
    }
}
