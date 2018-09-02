import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * Kristian Mentor
 * Cisc 1115
 * HW2:Function Calculator
 */
public class FunctionCalc {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(" Now running Function Calculator...");
		PrintWriter outputFile = new PrintWriter("D:/EclipseWorkspace/FunctionCalc/output.txt");
		//Title of my Table
		outputFile.println("\tKristian Mentor's  Function Table");
		outputFile.println("X/Input \t  Y/Result \t  Positive/Negative");
		outputFile.println("====================================================");
		//create variables to count the different types of results received.
		int amtPos=0,amtNeg=0,amtZero=0;
		
		//create variables to store the distances of the output numbers from 10.
		//1000 was just a safe enough starting number to initialize with.
		
		double closest10Y=0, closest10X=0, distanceFrom10=1000, newDistance;
		//create input and output variables
		double input,output;
		
		//create numerator and denominator variables to hold the top and bottom functions
		double numerator, denominator;
		for(input=-3;input<=4;input+=0.5) {
			//Recreate the function specified.
			numerator= 9*(input*input*input) - 27*(input*input) -(4*input)+12;
			denominator= Math.sqrt((3*(input*input) +1 )) + Math.abs(5-(input*input*input*input));
			output=numerator/denominator;
			
			//Formatting the output.
			outputFile.print(input);
			outputFile.print("\t\t");
			outputFile.printf("%10.4f",output);
			if(output>0) {outputFile.printf("\t   Y IS POSITIVE");amtPos++;}
			if(output==0) {outputFile.print("\t   Y IS ZERO"); amtZero++;}
			if(output<0) {outputFile.print("\t   Y IS NEGATIVE"); amtNeg++;}
			
			//Testing for Distance from the number 10. 
			if(output>10) { //if the output is larger than 10
				newDistance=output-10;
				if(newDistance<distanceFrom10) {
				closest10Y=output; closest10X=input; distanceFrom10=newDistance;}	
			}
			else
			if(output<10) { //if the output is smaller than 10
				newDistance=10-output;
				if(newDistance<distanceFrom10) {
				closest10Y=output; closest10X=input; distanceFrom10=newDistance;}	
			}
			outputFile.println(); //Make sure the cursor goes to the next line.
		}
		//Once the loop is finished.
		outputFile.println();
		outputFile.println("The closest number to 10 was yielded by X= "+closest10X);
		outputFile.println("The output, Y="+closest10Y+", was "+distanceFrom10+" digits away from 10.");
		outputFile.println("Amount of Positive results: "+amtPos);
		outputFile.println("Amount of Negative Results: "+amtNeg);
		outputFile.println("Amount of Zero Results: "+amtZero);
		outputFile.flush();
		outputFile.close();
		System.out.println("This program has finished.");
		}
	}
