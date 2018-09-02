import java.io.*;
import java.util.Scanner; 
import java.util.Arrays;
public class ArrayInfo {
	public static void main(String[] args) throws FileNotFoundException {
	Scanner inputFile= new Scanner(new File("D:\\EclipseWorkspace\\ArrayInfo\\src\\numbers.text"));
	int length= inputFile.nextInt();
	double[] array= new double[length];
	for(int i=0; i<length;i++) 
		{
		array[i]=inputFile.nextDouble();
		
		}
	inputFile.close();
	//System.out.print("The array: "+Arrays.toString(array)+" contains "+length+" elements \n");
	displayArray(array,length);
	displayFirst(array);
	displayLast(array,length);
	displayMiddle(array,length);
	displayLargest(array,length);
	displaySmallest(array,length);
	}
	public static void displayArray(double[] array, int length) {
		System.out.print("The array: {");
		for(int i=0; i<length;i++) 
		{
			if(i!=length-1) {
			System.out.print(array[i]+", ");
			}
			else {System.out.print(array[i]); }
		}
		System.out.print("} contains "+length+" elements\n");
		
	}
	public static void displayFirst(double[] array) 
	{
	 System.out.print("The first element of the array is "+array[0]);
	}
	
	public static void displayLast(double[] array, int length) 
	{
	 System.out.print("\nThe last element of the array is "+array[length-1]+" and is at position "+(length-1));
		
	}
	
	public static void displayMiddle(double[] array, int length) 
	{
		int mid;
		if(length%2==0) {
		 mid=length/2-1;
		}
		else { mid=length/2;}
		System.out.print("\nThe middle element of the array is "+array[mid]+" and is at position "+mid);	
	}
	public static void displayLargest(double[] array, int length) 
	{
		double largest=0.0;
		int largestPosition=0;
		for(int i=0; i<length;i++) 
		{
			if(array[i]>largest) {
				largest=array[i];
				largestPosition=i;
				}	
		}
		System.out.print("\nThe largest element of the array is "+largest+" and is at position "+largestPosition);
	}
	
	public static void displaySmallest(double[]array, int length) 
	{
		double smallest=array[0];
		int smallestPosition=0;
		for(int i=0; i<length;i++) 
		{
			if(array[i]<smallest) 
			{
				smallest=array[i];
				smallestPosition=i;	
			}	
		}
		System.out.print("\nThe smallest element of the array is "+smallest+" and is at position "+smallestPosition);
	}
}

