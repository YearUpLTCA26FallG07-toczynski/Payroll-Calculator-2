
package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(
                new FileReader("employees.csv"))) {

            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {

                // Skip the header row
                if (line.startsWith("id|")) {
                    continue;
                }

                // Split the employee information
                String[] tokens = line.split("\\|");

                // Store the employee information
                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                // Create an Employee object
                Employee employee = new Employee(
                        employeeId, name, hoursWorked, payRate
                );

                // Display payroll information
                System.out.printf(
                        "Employee ID: %d | Name: %-20s | Gross Pay: $%.2f%n",
                        employee.getEmployeeId(),
                        employee.getName(),
                        employee.getGrossPay()
                );
            }

        } catch (IOException e) {
            System.out.println("Error reading employees.csv: " + e.getMessage());
        }
    }
}
