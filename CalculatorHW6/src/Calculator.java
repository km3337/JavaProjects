import java.io.PrintWriter;
import java.util.*;
public class Calculator {

	public static void main(String[] args) throws java.lang.Exception {
		PrintWriter outFile= new PrintWriter("D:/EclipseWorkspace/CalculatorHW6/src/output.txt");
		char operator; 
		boolean loop=true;
		outFile.println(
				"    __ __    __  ___          ______            __                   __           __                \r\n" + 
				"   / //_/   /  |/  /         / ____/  ____ _   / /  _____  __  __   / /  ____ _  / /_  ____    _____\r\n" + 
				"  / ,<     / /|_/ /         / /      / __ `/  / /  / ___/ / / / /  / /  / __ `/ / __/ / __ \\  / ___/\r\n" + 
				" / /| |   / /  / /         / /___   / /_/ /  / /  / /__  / /_/ /  / /  / /_/ / / /_  / /_/ / / /    \r\n" + 
				"/_/ |_|  /_/  /_/          \\____/   \\__,_/  /_/   \\___/  \\__,_/  /_/   \\__,_/  \\__/  \\____/ /_/     \r\n" + 
				"                                                                                                    ");
		outFile.println("\t===============================================================================");
		
		Scanner keyboard = new Scanner(System.in);
		while(loop) 
		{
			
			System.out.println("\nPlease enter an operation to carry out: ");
			outFile.print("\nPlease enter an operation to carry out: ");
			operator=keyboard.next().charAt(0); //returns the char at string's O location.
			switch(operator) 
			{
			case '+':
				outFile.println("+");
				add(keyboard, outFile);
				break;
			case '-':
				outFile.println("-");
				subtract(keyboard, outFile);
				break;
			case '*':
				outFile.println("*");
				multiply(keyboard, outFile);
				break;
			case '/':
				outFile.println("/");
				divide(keyboard, outFile);
				break;
			case '%':
				outFile.println("%");
				remainder(keyboard, outFile);
				break;
			case 'A':
			case 'a':
				outFile.println("A");
				average(keyboard, outFile);
				break;
			case 'X':
			case 'x':
				outFile.println("X");
				maximum(keyboard, outFile);
				break;
			case 'M':
			case 'm':
				outFile.println("M");
				minimum(keyboard, outFile);
				break;
			case 'S':
			case 's':
				outFile.println("S");
				square(keyboard, outFile);
				break;
				
			case 'Q': 
			case 'q':
				outFile.println("Q");
				System.out.println("Exiting Calculator.");
				outFile.println("\n");
				outFile.println("Exiting Calculator.");
				loop=false;
				outFile.flush();
				break;
			default: 
				System.out.println("\nError 404:"+ operator+ " is Invalid Input.");
				outFile.println("\nError 404: "+operator+" is Invalid Input.");
				outFile.flush();
				break;
			}//end of switch
			
		}//end of infinite loop
		keyboard.close();	
	}//end main

	public static void add(Scanner keyboard, PrintWriter outFile)
	//Addition
	{
		System.out.println("Enter two integers to be added: ");
		outFile.println("Enter two integers to be added: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		outFile.println(x+" + "+y+" = "+(x+y));	
		outFile.flush();
	}

	public static void subtract(Scanner keyboard,PrintWriter outFile) 
	//Subtraction
	{
		System.out.println("Enter two integers to be subtracted: ");
		outFile.println("Enter two integers to be subtracted: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		outFile.println(x+" - "+y+" = "+(x-y));	
		outFile.flush();
	}

	public static void multiply(Scanner keyboard,PrintWriter outFile)
	//Multiplication
	{
		System.out.println("Enter two integers to be multiplied: ");
		outFile.println("Enter two integers to be multiplied: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		outFile.println(x+" * "+y+" = "+(x*y));	
		outFile.flush();
	}

	public static void divide(Scanner keyboard,PrintWriter outFile)
	//Division
	//does not allow for division by 0.
	{
		System.out.println("Enter two integers to be divided: ");
		outFile.println("Enter two integers to be divided: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		while(y==0) {
			outFile.println("Error 405: cannot divide by zero");
			y= keyboard.nextInt();
		}
		outFile.println(x+" / "+y+" = "+(x/y));	
		outFile.flush();
	}

	public static void remainder(Scanner keyboard,PrintWriter outFile)
	//Find the remainder
	{
		System.out.println("Enter two integers to be divided: ");
		outFile.println("Enter two integers to be divided: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		outFile.println("The remainder of " + x +"/"+ y+" = "+(x%y));
		outFile.flush();
	}

	public static void average(Scanner keyboard,PrintWriter outFile)
	//calculates the average 
	{
		System.out.println("Enter two integers to be averaged: ");
		outFile.println("Enter two integers to be averaged: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		outFile.println("The average of "+x+" & "+y+" = "+((x+y)/2) );	
		outFile.flush();
	}

	public static void maximum(Scanner keyboard,PrintWriter outFile) 
	//Calculate the maximum of two Numbers
	{
		System.out.println("Enter two integers: ");
		outFile.println("Enter two Integers: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		if(x>y) outFile.println(x+" , "+y+" Maximum = "+x);
		else outFile.println(x+" , "+y+" Maximum = " +y);
		outFile.flush();
	}

	public static void minimum(Scanner keyboard,PrintWriter outFile) 
	//Calculate the minimum of two Numbers
	{
		outFile.println("Enter two integers: ");
		System.out.println("Enter two integers: ");
		int x= keyboard.nextInt();
		int y= keyboard.nextInt();
		if(x<y) outFile.println(x+" , "+y+" Minimum = "+x);
		else outFile.println(x+" , "+y+" Minimum = " +y);
		outFile.flush();
	}

	public static void square(Scanner keyboard,PrintWriter outFile) 
	//Calculate the square of a  Number
	{
		System.out.println("Enter one Integer to be Squared:  ");
		outFile.println("Enter one Integer to be Squared:  ");
		int x= keyboard.nextInt();
		outFile.println( x+"^2 ="+(x*x));
		outFile.flush();
	}

}
