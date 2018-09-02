import java.io.*;
import java.util.Scanner;
public class donate {

	public static void main(String[] arg) throws IOException 
	{
		PrintWriter outFile= new PrintWriter("D:\\EclipseWorkspace\\Donations\\src\\output.txt");
		int[] idNum= new int[50];
		double[]donation= new double[50];
		int donorCount=fillData(idNum,donation);
		display(idNum,donation,donorCount,outFile);
		sortIDNumerical(idNum,donation,donorCount);
		outFile.println("\nSorted IDs Numerically");
		display(idNum,donation,donorCount,outFile);
		sortDonationAmt(idNum,donation,donorCount);
		outFile.println("\nSorted donations Numerically");
		display(idNum,donation,donorCount,outFile);
		outFile.flush();
		System.out.println("Done.");
	}


	public static int fillData(int[]idNum, double[] donation) throws IOException
	{
		int donorCount=0;
		int tempID=0;
		double tempDonat=0;
		Scanner inFile= new Scanner(new File("D:\\EclipseWorkspace\\Donations\\src\\input.txt"));
		while(inFile.hasNextLine()) 
		{
			tempID=inFile.nextInt();
			tempDonat=inFile.nextDouble();
			idNum[donorCount]=tempID;
			donation[donorCount]= tempDonat;
			donorCount++;
		}
		inFile.close();
		return donorCount;
	}
	
	public static void sortIDNumerical(int[] idNum, double[] donation, int length) 
	{
		int tempID=0, i, j;
		double tempDonat=0.0;
		for(i=0; i < length-1;i++) 
		{
			for (j=0; j<length-1-i;j++) 
			{
				if(idNum[j]>idNum[j+1]) 
				{
					tempID= idNum[j];
					tempDonat= donation[j];
					idNum[j]= idNum[j+1];
					donation[j]=donation[j+1];
					idNum[j+1]=tempID;
					donation[j+1]=tempDonat;
				}
			}
		}
	}
	
	public static void display(int[]idNum, double[] donation,int length, PrintWriter outFile) throws IOException 
	//loops through the parallel arrays to print info
	{
		outFile.println("\n\t\t  Donation Database");
		outFile.println("  ==========+++++++++++++==========  ");
		outFile.println("\tID num \t \t \t \tDonation");
		outFile.println("  ==========+++++++++++++==========  ");
		for(int i=0; i<length;i++) 
		{
			outFile.printf("\n||%9d \t\t \t $%, -9.2f||",idNum[i],donation[i]);
		}
		outFile.println();
		outFile.flush();
	}
	
	public static void sortDonationAmt(int[] idNum, double[] donation, int length) 
	{
		int tempID=0, i, j;
		double tempDonat=0.0;
		for(i=0; i <length-1;i++) 
		{
			for (j=0; j<length-1-i;j++) 
			{
				if(donation[j]>donation[j+1]) 
				{
					tempID= idNum[j];
					tempDonat= donation[j];
					idNum[j]= idNum[j+1];
					donation[j]=donation[j+1];
					idNum[j+1]=tempID;
					donation[j+1]=tempDonat;
				}
			}
		}
	}
	
	
}
