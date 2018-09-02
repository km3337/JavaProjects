
public class FunctionCalc {

	public static void main(String[] args) 
	{	System.out.println("X/Input \t Y/Result \t Positive/Negative");
		//create input and output variables
		double input,output;
		//create numerator and denominator variables to hold the top and bottom functions
		double numerator, denominator;
		for(input=-3;input!=4;input+=0.5) 
		{
		//Recreate the function specified.
		numerator= 9*(input*input*input) - 27*(input*input) -(4*input)+12;
		denominator= Math.sqrt((3*(input*input) +1 )) + Math.abs(5-(input*input*input*input));
		output=numerator/denominator;
		//Formatting the output.
		System.out.print("X= "+ input);
		System.out.print("\t\t Y= ");
		System.out.printf("%7.4f",output);
		if(output>0) System.out.print("\t Y IS POSITIVE");
		if(output==0) System.out.print("\t Y IS ZERO");
		if(output<0) System.out.print("\t Y IS NEGATIVE");
		System.out.println();
		}
		//Once the loop is finished.
		System.out.println("The program has finished.");
		}
	}
