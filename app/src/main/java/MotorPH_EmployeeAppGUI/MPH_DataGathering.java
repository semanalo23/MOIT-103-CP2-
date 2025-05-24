/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ASPIRE 7
 */
public class MPH_DataGathering {
    private long employeeId;
    private String employeeName;
    private LocalDate birthDate;
    private double hourlyRate;
    private LocalTime loginTime;
    private LocalTime logoutTime;

    // Constructor that takes all necessary data for payroll computations.
    public MPH_DataGathering(long employeeId, String employeeName, LocalDate birthDate,
                       double hourlyRate, LocalTime loginTime, LocalTime logoutTime) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthDate = birthDate;
        this.hourlyRate = hourlyRate;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    // Getting each data field
    public long getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public LocalTime getLoginTime() {
        return loginTime;
    }

    public LocalTime getLogoutTime() {
        return logoutTime;
    }
}
