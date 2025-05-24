/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 *
 * @author ASPIRE 7
 */
public class MPH_PayrollCalculator_Logic {

    private static final double OVERTIME_MULTIPLIER = 1.5;
    private static final double SSS_RATE = 0.045;
    private static final double PHILHEALTH_RATE = 0.03;
    private static final double PAGIBIG_DEDUCTION = 100.00;
    private static final double TAX_RATE = 0.10;
    private static final LocalTime GRACE_PERIOD = LocalTime.of(8, 10);

    // Reference to the data
    private MPH_DataGathering data;

    // Constructor accepts a PayrollData instance
    public MPH_PayrollCalculator_Logic(MPH_DataGathering data) {
        this.data = data;
    }

    // Private helper method: calculates late deduction.
    private double calculateLateDeduction() {
        LocalTime loginTime = data.getLoginTime();
        if (loginTime.isAfter(GRACE_PERIOD)) {
            long minutesLate = Duration.between(GRACE_PERIOD, loginTime).toMinutes();
            double perMinuteRate = data.getHourlyRate() / 60.0;
            return minutesLate * perMinuteRate * OVERTIME_MULTIPLIER;
        }
        return 0.0;
    }

    // Private helper method: calculates effective hours worked as a double (fractional hours).
    private double calculateEffectiveHoursWorked() {
        long totalMinutes = Duration.between(data.getLoginTime(), data.getLogoutTime()).toMinutes();
        if (totalMinutes < 0) {
            throw new ArithmeticException("Invalid pay coverage: logout time is before login time.");
        }
        // Deduct 60 minutes for lunch if worked more than an hour
        if (totalMinutes > 60) {
            totalMinutes -= 60;
        }
        return totalMinutes / 60.0;
    }

    // Public method: gets regular working hours (capped at 8 hours).
    public double getRegularHours() {
        double effectiveHours = calculateEffectiveHoursWorked();
        return Math.min(effectiveHours, 8.0);
    }

    // Public method: calculates overtime hours beyond 8 hours.
    public double getOvertimeHours() {
        double effectiveHours = calculateEffectiveHoursWorked();
        return effectiveHours > 8.0 ? effectiveHours - 8.0 : 0.0;
    }

    // Calculates the gross salary from regular and overtime hours.
    public double getGrossSalary() {
        double regularPay = getRegularHours() * data.getHourlyRate();
        double overtimePay = getOvertimeHours() * data.getHourlyRate() * OVERTIME_MULTIPLIER;
        return regularPay + overtimePay;
    }

    // Calculates total deductions including SSS, PhilHealth, Pag-IBIG, Tax, and Late Deduction.
    public double getTotalDeductions() {
        double grossSalary = getGrossSalary();
        double lateDeduction = calculateLateDeduction();
        double sss = grossSalary * SSS_RATE;
        double philhealth = grossSalary * PHILHEALTH_RATE;
        double tax = grossSalary * TAX_RATE;
        return sss + philhealth + PAGIBIG_DEDUCTION + tax + lateDeduction;
    }

    // Calculates net pay by subtracting total deductions from gross salary.
    public double getNetPay() {
        return getGrossSalary() - getTotalDeductions();
    }

    // Formats all payroll data for display
    public String formatPayrollSummary() {
        double effectiveHours = calculateEffectiveHoursWorked();
        double regularHours = getRegularHours();
        double overtimeHours = getOvertimeHours();
        double grossSalary = getGrossSalary();
        double regularPay = regularHours * data.getHourlyRate();
        double overtimePay = overtimeHours * data.getHourlyRate() * OVERTIME_MULTIPLIER;
        double lateDeduction = calculateLateDeduction();
        double sss = grossSalary * SSS_RATE;
        double philhealth = grossSalary * PHILHEALTH_RATE;
        double tax = grossSalary * TAX_RATE;
        double netPay = getNetPay();
        int age = Period.between(data.getBirthDate(), LocalDate.now()).getYears();

        return String.format("""
                Employee Name: %s
                Employee ID: %d
                Birth Date: %s
                Age: %d
                Effective Hours Worked (after lunch): %.2f
                Regular Hours: %.2f
                Overtime Hours: %.2f
                Hourly Rate: PHP %.2f
                ----------------------------
                Gross Salary: PHP %.2f
                     (Regular Pay: PHP %.2f, Overtime Pay: PHP %.2f)
                
                Deductions:
                  SSS:           PHP %.2f
                  PhilHealth:    PHP %.2f
                  Pag-IBIG:      PHP %.2f
                  Tax:           PHP %.2f
                  Late Deduction: PHP %.2f
                ----------------------------
                Net Pay: PHP %.2f
                """,
                data.getEmployeeName(),
                data.getEmployeeId(),
                data.getBirthDate(),
                age,
                effectiveHours,
                regularHours,
                overtimeHours,
                data.getHourlyRate(),
                grossSalary,
                regularPay,
                overtimePay,
                sss,
                philhealth,
                PAGIBIG_DEDUCTION,
                tax,
                lateDeduction,
                netPay
        );
    }
}
