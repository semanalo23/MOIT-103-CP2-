/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MotorPH_EmployeeAppGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASPIRE 7
 */
public class MotorPH_EmployeeUpdateForm extends javax.swing.JFrame {

    private MPH_EmployeeClassList employee;

    // Declare text fields for updating employee data.
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtSSS;
    private JTextField txtPhilHealth;
    private JTextField txtTIN;
    private JTextField txtPagIbig;
    private JTextField txtDOB;
    private JTextField txtDepartment;
    private JTextField txtHourlyRate;

    // Update button
    private JButton btnUpdate;

    /**
     * Creates new form MotorPH_EmployeeUpdateForm
     */
    public MotorPH_EmployeeUpdateForm(MPH_EmployeeClassList emp) {
        this.employee = emp;
        initCustomComponents();
        populateFields();
    }

    private void initCustomComponents() {
        setTitle("Update Employee Record");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Create a panel for the input fields.
        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        // First Name
        inputPanel.add(new JLabel("First Name:"));
        txtFirstName = new JTextField(20);
        inputPanel.add(txtFirstName);

        // Last Name
        inputPanel.add(new JLabel("Last Name:"));
        txtLastName = new JTextField(20);
        inputPanel.add(txtLastName);

        // SSS Number
        inputPanel.add(new JLabel("SSS Number:"));
        txtSSS = new JTextField(20);
        inputPanel.add(txtSSS);

        // PhilHealth
        inputPanel.add(new JLabel("PhilHealth:"));
        txtPhilHealth = new JTextField(20);
        inputPanel.add(txtPhilHealth);

        // TIN
        inputPanel.add(new JLabel("TIN:"));
        txtTIN = new JTextField(20);
        inputPanel.add(txtTIN);

        // Pag-IBIG
        inputPanel.add(new JLabel("Pag-IBIG:"));
        txtPagIbig = new JTextField(20);
        inputPanel.add(txtPagIbig);

        // DOB
        inputPanel.add(new JLabel("DOB:"));
        txtDOB = new JTextField(20);
        inputPanel.add(txtDOB);

        // Department
        inputPanel.add(new JLabel("Department:"));
        txtDepartment = new JTextField(20);
        inputPanel.add(txtDepartment);

        // Hourly Rate
        inputPanel.add(new JLabel("Hourly Rate:"));
        txtHourlyRate = new JTextField(20);
        inputPanel.add(txtHourlyRate);

        // Create a panel for the Update button.
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnUpdate = new JButton("Update Record");
        buttonPanel.add(btnUpdate);

        // Set up the frame's layout.
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window

        // Add event handling to the button.
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRecord();
            }
        });
    }

    // Populate the text fields with the current employee data.
    private void populateFields() {
        // Using getter methods from MPH_EmployeeClassList
        txtFirstName.setText(employee.getFirstName());
        txtLastName.setText(employee.getLastName());
        txtSSS.setText(employee.getSssNumber());
        txtPhilHealth.setText(employee.getPhilHealth());
        txtTIN.setText(employee.getTin());
        txtPagIbig.setText(employee.getPagIbig());
        txtDOB.setText(employee.getDateOfBirth());
        txtDepartment.setText(employee.getDepartment());
        txtHourlyRate.setText(employee.getHourlyRate());
    }

    // This method is where you'd implement the update logic.
    private void updateRecord() {
        // For now, simply display the updated data.
        String updatedInfo = "First Name: " + txtFirstName.getText().trim() + "\n"
                + "Last Name: " + txtLastName.getText().trim() + "\n"
                + "SSS Number: " + txtSSS.getText().trim() + "\n"
                + "PhilHealth: " + txtPhilHealth.getText().trim() + "\n"
                + "TIN: " + txtTIN.getText().trim() + "\n"
                + "Pag-IBIG: " + txtPagIbig.getText().trim() + "\n"
                + "DOB: " + txtDOB.getText().trim() + "\n"
                + "Department: " + txtDepartment.getText().trim() + "\n"
                + "Hourly Rate: " + txtHourlyRate.getText().trim();
        JOptionPane.showMessageDialog(this, "Updated Data:\n" + updatedInfo);
        // Later, you can integrate database update logic here.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        // Create a dummy employee for testing.
        MPH_EmployeeClassList dummyEmployee = new MPH_EmployeeClassList(
            "10001", "Doe", "John", "44-4506057-3",
            "820126853951", "442-605-657-000",
            "691295330870", "1980-01-01", "CEO", "50.0"
        );
        SwingUtilities.invokeLater(() -> {
            new MotorPH_EmployeeUpdateForm(dummyEmployee).setVisible(true);
        });
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

