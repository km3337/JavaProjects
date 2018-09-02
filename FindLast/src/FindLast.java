import java.io.*;
import java.util.Scanner;

public class FindLast {
public static void main(String[] args) throws FileNotFoundException {
	int numWanted;
	Scanner keyboard= new Scanner(System.in);
	do {
	System.out.print("Enter a number:");
	numWanted=keyboard.nextInt();
	int result=findValue(numWanted);
	if(result==-1) {
		System.out.print(""+numWanted+" does not appear in the file\n");
	}
	else {
		System.out.print(""+numWanted+" last appears in the file at position "+result+"\n");
	}
	} while(numWanted!=999);
	keyboard.close();
	
	
}

public static int findValue(int numWanted) throws FileNotFoundException{
	//returns the position of the number wanted.
	int position=1,currentLocation=1, temp;
	boolean found=false;
	//if the number is found, return that numbers postion as an integer.
	//if the number is not found, return -1.
	Scanner inputFile= new Scanner(new File("D:\\EclipseWorkspace\\FindLast\\src\\numbers"));
	while(inputFile.hasNextInt()) {
		temp=inputFile.nextInt();
		if(temp==numWanted) {
			position=currentLocation;
			found=true;
			}
		currentLocation++;
		
	}
	inputFile.close();
	if(found) {
	return position;
	}
	else return -1;
}
}
