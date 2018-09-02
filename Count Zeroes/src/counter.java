/*Kristian Mentor
 * CISC 1115
 * HW7.2: Count Zeros
 *
 * */
import java.io.*;
import java.util.Scanner;

public class counter {

	public static void main(String[] args) throws Exception {
		int[] vals= new int[100];
		int size;
		PrintWriter outFile= new PrintWriter("D:\\EclipseWorkspace\\Count Zeroes\\src\\output.txt ");
		size=readData(vals,outFile);
		int amtZeros=0;
		amtZeros=countZeros(vals,size);
		outFile.println("\nAmount of Zeros:"+amtZeros);
		//System.out.println(" HERE");
		size=append(vals,size, outFile);
		amtZeros=countZeros(vals,size);
		outFile.println("\nAmount of Zeros:"+amtZeros);
		outFile.flush();
		//System.out.println(" HERE");

	}
	
	public static int readData(int[] vals, PrintWriter outFile) throws  java.lang.Exception 
	{
		int amtValues=0, currentNum;
		
		Scanner inputFile = new Scanner(new File("D:\\EclipseWorkspace\\Count Zeroes\\src\\input.txt"));
		outFile.println("|||\tCount \t\t \tValue|||");
		outFile.println("============================");
		while(inputFile.hasNextLine()) 
		{
			currentNum=inputFile.nextInt();
			vals[amtValues]=currentNum;
			outFile.printf("|||%-7d \t\t %7d |||\n",amtValues,currentNum);
			outFile.println("============================");
			amtValues++;
			
		}
		outFile.println("Total amount of integers: "+amtValues);
		outFile.flush();
		inputFile.close();
		return amtValues;
		
	}

	public static int countZeros(int[] vals,int length) 
	{
		int amtZeros=0;
		for(int i=0; i<=length-1;i++)
		{
			if (vals[i]==0) 
			{
				amtZeros++;
				System.out.println("yes."+i);
			}
		}
		
		return amtZeros;
	}
	
	public static int append(int[] vals, int length, PrintWriter outFile) throws FileNotFoundException 
	{
		int currentNum;
		//starts adding to the next available space in the 
		//vals array
		int newLength=length;
		Scanner inputFile = new Scanner(new File("D:\\EclipseWorkspace\\Count Zeroes\\src\\append.txt"));
		outFile.println("Post append...");
		outFile.println("|||\tCount \t\t \tValue|||");
		outFile.println("============================");
		while(inputFile.hasNextLine()) 
		{
			currentNum=inputFile.nextInt();
			vals[newLength]=currentNum;
			++newLength;
		}
		for(int i=0;i<=newLength-1;++i) 
		{
			outFile.printf("|||%-7d \t\t %7d |||\n",i,vals[i]);
			outFile.println("============================");
		}
		
		inputFile.close();
		return newLength;
		
	}
}
