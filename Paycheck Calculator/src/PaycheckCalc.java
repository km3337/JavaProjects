import java.io.*;
import java.util.Scanner;
/*
 * Kristian Mentor
 * Paycheck Calculator
 * 
 */
public class PaycheckCalc {
	double payRate=0.00, hoursWorked=0.00, annualPreTax=0.00, yearlyAmt=0.00;
	Scanner keyboard= new Scanner(System.in);
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void getPaycheckInfo() {
		System.out.println("Please enter your pay rate: ");
		payRate= keyboard.nextDouble();
		if(payRate<=0.00) {
			System.out.println(" Error encountered. Restarting...");
			getPaycheckInfo();
		}
		System.out.println("Please enter amount of hours worked per week: ");
		hoursWorked= keyboard.nextDouble();
		if(hoursWorked<=0.00) {
			System.out.println("Error encountered. Restarting...");
			getPaycheckInfo();
		}
	}
	
	public double calcYearly() {
		
		annualPreTax= payRate*hoursWorked*52;
		return annualPreTax;
	}
	
	public double calcYearlyAmt(double preTaxAmt) {
		if(preTaxAmt>=8400) 
			;
		
		
		
	
	}

}
