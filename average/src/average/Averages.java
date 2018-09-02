package average;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Averages 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		//total amt of runs is kept tallied.
		int runAmt=0;
		Scanner inputFile= new Scanner(new File("D:\\EclipseWorkspace\\average\\src\\average\\numbers.txt"));
		while(inputFile.hasNextLine()) 
		{
			//the length of the array is the first integer read in from the file.
			int length= inputFile.nextInt();
			
			//the sum of the elements in the array is recorded each time the loop continues successfully.
			int tempTotal=0;
			
			int[] temp= new int[length];
			//add the following integers into the array.
			for(int i=0; i<length; i++) 
				{
				 temp[i]=inputFile.nextInt();
				 tempTotal+=temp[i];
				}
			//output of each run.
			System.out.println("The average of the "+length+" integers "+Arrays.toString(temp)+" is: "+((double)tempTotal)/((double)length));
			runAmt++;
		}
		inputFile.close();
		System.out.println(runAmt+" sets of numbers processed");
		
	}
}


