import java.io.*;
import java.util.Scanner;
/*Kristian Mentor
 * CISC 3115
 * Phonebooks 1.0
 */

public class Phonebook {

	public static void main(String[] args) throws FileNotFoundException {
	//opening the keyboard for input to make the program interactive.
	Scanner keyboard= new Scanner(System.in);
	
	//creation of variables to manage user input
	boolean loop=true;
	char operation;
	String first, last, phone;
	int position, amtLookups=0, amtReverseLookups=0;
	//creation of  parallel arrays to store phoneNums and Names. Max of 100 allocated spaces in array.	
	String[] phoneNums= new String[100];
	String[] lastNames= new String[100];
	String[] firstNames= new String[100];
	//in order to deal with unused space, the size of the current test phonebook.text will be recorded.
	int size=read(phoneNums,lastNames,firstNames);
	
	//while loop runs in tandem with switch to continuously receive input, until
	//a quit operation is inputted.
	//each switch case keeps track of the total amount of runs it has received.
	//these amounts are printed before the program ends.
	while(loop) 
	{
		System.out.println("lookup, reverse-lookup, quit?(l/r/q/)");
		operation=keyboard.next().charAt(0); //returns the char at string's O
		switch(operation)
		{
		case 'L':
		case 'l':
			System.out.println("last name?");
			last=keyboard.next();
			System.out.println("first name?");
			first=keyboard.next();
			position=lookup(lastNames,firstNames,size,first,last);
			if(position!=-1) {
				System.out.println(firstNames[position]+" "+lastNames[position]+"\'s phone number is "+phoneNums[position]);
			}
			else {
				System.out.println("-- Name not found");
			}
			amtLookups++;
			break;
			
		case 'R':
		case 'r':
			System.out.println("phone number (nnn-nnn-nnnn)?");
			phone=keyboard.next();
			position=reverseLookup(phoneNums,size,phone);
			if(position!=-1) {
				System.out.println(phoneNums[position]+" belongs to "+lastNames[position]+", "+firstNames[position]);
			}
			else {
				System.out.println("-- Phone number not found");
			}
			amtReverseLookups++;
			break;
			
		case 'Q':
		case 'q':
			System.out.println();
			System.out.println(amtLookups+" lookups performed");
			System.out.println(amtReverseLookups+" reverse lookups performed");
			loop=false;// ends the loop, allows program to stop running.
			break;
			
			//catch invalid input
		default:
			System.out.println("Error 404: Wrong input detected.");
			System.out.println(operation+ " is Invalid Input.");
			break;
		}
		
	}
	keyboard.close();
	}
	
	public static int read(String[] phoneNums, String[] lastNames, String[] firstNames) throws FileNotFoundException 
	//read opens the phonebook.text file, scanning in each data token into their respective array.
	//returns the size of the information stored as an integer.
	{
		int size=0;
		Scanner input=new Scanner(new File("phonebook.text"));
		while(input.hasNext()) 
			{
			//if the amount of data read in exceeds the allocated space in the array, the program will exit with an error message.
				if(size==100) 
				{
					System.out.println("Dataset exceeds preallocated size of array. Exiting...");
					System.exit(1);
				}
				//data is stored in this order
				lastNames[size]=input.next();
				firstNames[size]=input.next();
				phoneNums[size]=input.next();
				size++;
			
			}
		input.close();
		return size;
	}

	public static int lookup(String[] lastNames, String[] firstNames, int size, String first, String last) 
	{
		//iterates through both last and first name arrays, checking if the full name matches, returns the position if a match is found.
		//if a match is not found, -1 is returned.
		//input is handled by the main program.
		//display is handled by the main program.
		int position=-1;
		for(int i=0; i<size;i++) 
		{
			if(lastNames[i].equalsIgnoreCase(last) && firstNames[i].equalsIgnoreCase(first)) 
			{
				position=i;
			}
		}
		return position;
	}
	
	public static int reverseLookup(String[] phoneNums,int size, String phone) 
	{
		//iterates through the phoneNums array, checking if the phone number passed in matches the stored phone numbers.
		//if a match is not found, -1 is returned.
		//input is handled by the main program.
		//display is handled by main program.
		int position=-1;
		for(int i=0; i<size;i++) 
		{
			if(phoneNums[i].equals(phone)) 
			{
			 position=i;	
			}
		}
		return position;
	}
}
