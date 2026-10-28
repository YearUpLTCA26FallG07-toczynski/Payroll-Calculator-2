
package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class PayrollCalculator {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try {
            System.out.println("Enter the name of the file to process: ");
            String fileToProcessName = in.nextLine()+".csv";
            FileReader fileReader = new FileReader(fileToProcessName);

            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
            Employee[] employee = new Employee[8];
            int couter=0;
            bufReader.readLine();
            while((input = bufReader.readLine()) != null) {
                int id = Integer.parseInt(input.split("\\|")[0]);
                String name =input.split("\\|")[1];
                double hours=Double.parseDouble(input.split("\\|")[2]);
                double payrate=Double.parseDouble(input.split("\\|")[3]);
                employee[couter]=new Employee(id,name,hours,payrate);
                couter++;
            }
            bufReader.close();

            for(Employee e:employee){
                System.out.println("Emplyee Id: "+e.getEmployeeId()+"   ||"+"Name: "+e.getName()+"   ||"+" Gross Pay: $"+e.getGrossPay());
            }


            //Buffer Writer Task

            String [] empGross= new String[9];
            empGross[0]="id|name|gross pay ";
            for (int i=1;i<9;i++){
                int employeeIndex =i-1;
                empGross[i]=(employee[employeeIndex].getEmployeeId()+
                        "|"+employee[employeeIndex].getName()+
                        "|"+employee[employeeIndex].getGrossPay());
            }

            System.out.println("Enter the name of the payroll file to create:");
            String fileToCreate=in.nextLine()+".txt";
            FileWriter fileWriter = new FileWriter(fileToCreate);

            BufferedWriter bufWriter = new BufferedWriter(fileWriter);

            for(int i =0; i <9; i++)
                bufWriter.write(empGross[i]+"\n");

            // close the writer
            bufWriter.close();
        }
        catch(IOException e) {
            // display stack trace if there was an error
            e.printStackTrace();
        }
    }
}
