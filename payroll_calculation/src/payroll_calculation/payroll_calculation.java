package payroll_calculation;

import java.util.Scanner;

public class payroll_calculation {
	public static void main(String[] args) {
		
		// Create a Scanner object to read user input
		Scanner scnr = new Scanner(System.in);
		
		// Variables to store employee information
		String lastName;
		String ssn;
		float hourlyPayRate;
		int hoursWorked;
		
		// Ask for the employee's last name
		System.out.println("Enter your last name: ");
		lastName = scnr.nextLine();
		
		// Ask for the employee's SSN (last 4 digits)
		System.out.println("SSN (last 4 digits): ");
		ssn = scnr.nextLine();
		
		// Ask for the employee's hourly rate
		System.out.println("Hourly pay rate: ");
		hourlyPayRate = scnr.nextFloat();
		
		// Ask for the number of hours worked
		System.out.println("Hours worked: ");
		hoursWorked = scnr.nextInt();
		
		// Print a blank line
		System.out.println();
		
		// Print the payroll summary
		System.out.println("Payroll Summary for: " + lastName);
		System.out.println("SSN (last 4 digits): " + ssn); 
		System.out.println("You worked " + hoursWorked + " hours at $" + hourlyPayRate + " per hour.");
		
		// Print a blank line
		System.out.println();
		
		// Calculate the gross pay, federal withholding, state withholding, and net pay. This is for ease of use.
		float grossPay = hourlyPayRate * hoursWorked;
		// The f in the next two lines makes them a single float instead of a double.
		float federalWithholdings = grossPay * .15f;              
		float stateWithholdings = grossPay * .05f;
		float netPay = grossPay - federalWithholdings - stateWithholdings;
		
		/* Print the payroll details using the printf method.
		 * 
		 * The printf method allows me to control the formating of the text, unlike the println method.
		 * 
		 * Break down of usage: 
		 * $ specifies the currency of the following.
		 * %10.2f specifies that its a float with 2 decimal places, and that it has a total width of 10 characters.
		 * \n starts a new line after the current is finished printing.
		 * In combination, this will help satisfy the requirements of having 2 decimal places and good alignment.
		*/
		System.out.printf("Gross pay: $%10.2f\n", grossPay);	
		System.out.printf("Federal witWnahholding: $%10.2f\n", federalWithholdings);	
		System.out.printf("State withholding: $%10.2f\n", stateWithholdings);	
		
		// A line of "-" to seperate the payroll calculations from the net pay. For clarity.
		System.out.println("------------------------------");
		
		// Print the net pay.
		System.out.printf("Net pay: $%10.2f\n", netPay);
	}

}
