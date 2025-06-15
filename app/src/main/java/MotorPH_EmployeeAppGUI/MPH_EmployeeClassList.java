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

    private String[] details;
    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String sssNumber;
    private String philHealth;
    private String tin;
    private String pagIbig;
    private String dateOfBirth;
    private String department;
    private String hourlyRate;

    public MPH_EmployeeClassList(String employeeNumber, String lastName, String firstName,
            String sssNumber, String philHealthNumber, String tin,
            String pagIbigNumber, String dateOfBirth, String department, String hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.sssNumber = sssNumber;
        this.philHealth = philHealthNumber;
        this.tin = tin;
        this.pagIbig = pagIbigNumber;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.hourlyRate = hourlyRate;
    }
    //GETTERS
   public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public String getSssNumber() {
        return sssNumber;
    }
    
    public String getPhilHealth() {
        return philHealth;
    }
    
    public String getTin() {
        return tin;
    }
    
    public String getPagIbig() {
        return pagIbig;
    }
    
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public String getHourlyRate() {
        return hourlyRate;
    }
    
    // Setters:
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public void setPhilHealth(String philHealth) {
        this.philHealth = philHealth;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public void setPagIbig(String pagIbig) {
        this.pagIbig = pagIbig;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}