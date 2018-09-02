import java.util.*;
import java.io.*;

class Name {
	public Name(String last, String first) {
		this.last = last;
		this.first = first;
	}
	public Name(String first) {this("", first);}

	public String getFormal() {return first + " " + last;}
	public String getOfficial() {return last + ", " + first;}
	public String getInitials() {return (Character.toString(first.charAt(0)) +"."+ Character.toString(last.charAt(0))+ ".");}

	public boolean equals(Name other) {return first.equals(other.first) && last .equals(other.last);}

	public String toString() {return first + " " + last;}

	public static Name read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		String last = scanner.next();
		String first = scanner.next();
		return new Name(last, first);
	}

	private String first, last;
	}

class PhoneNumber {
	//Constructor
	public PhoneNumber(String number) 
	{
		this.number=number;
	}
	//getter for this Phone number's number.
	public String getNumber() 
	{
		return this.number;
	}
	
	//returns the area code, using the getNumber() and a substring method.
	public String getAreaCode() 
	{
		return getNumber().substring(1,4);
	}
	
	//returns the middle three digits, using the getNumber() and a substring method.
	public String getExchange() 
	{
		return getNumber().substring(5,8);
	}
	
	//returns the last 4 digits, using the getNumber() and a substring method.
	public String getLineNumber() 
	{
		return getNumber().substring(9,13);
	}
	
	//returns the boolean value of the expression:
	//if first digit in the area code is equal to 8.
	public boolean isTollFree() 
	{
		return getNumber().charAt(1)=='8';
	}
	
	public String toString() 
	{
		return number;
	}
	
	public boolean equals(PhoneNumber other) 
	{
		return getNumber().equals(other.getNumber());
	}
	
	public static PhoneNumber read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		String number  = scanner.next();
		return new PhoneNumber (number);
	}

	private String number;
	
}

class Phonebook {
	private PhoneNumber phoneNumber;
	private Name name;
	
	public Phonebook(Name name,PhoneNumber number) 
	{
		this.phoneNumber= number;
		this.name=name;
	}
	
	public String toString() 
	{
		return name+": "+phoneNumber;
	}
	
	public Name getName() {return name;}
	public PhoneNumber getPhone() {return phoneNumber;}
	
	public boolean equals(Phonebook otherEntry) 
	{
		if(name.equals(otherEntry.name) && !(phoneNumber.equals(otherEntry.phoneNumber)) )
			{ System.out.println("Warning duplicate name encountered \""+ name+": "+phoneNumber+"\" discovered");
			return true;
			}
		else if(phoneNumber.equals(otherEntry.phoneNumber) && name.equals(otherEntry.name)) 
		{
			System.out.println("Duplicate phone book entry \""+otherEntry+"\" discovered");
			return false;
		}
		return true;
		
	}
	
	public static Phonebook read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		Name newName = Name.read(scanner);
		PhoneNumber newphoneNumber = PhoneNumber.read(scanner);
		return new Phonebook(newName, newphoneNumber);
	}
	
	public static int open(Phonebook[] phonebook) throws Exception{
		int size=0;
		Scanner input=new Scanner(new File("D:\\EclipseWorkspace\\Phonebook2\\src\\phonebook.txt"));
		while(input.hasNext()) 
			{
			//if the amount of data read in exceeds the allocated space in the array, the program will exit with an error message.
				if(size>100) 
				{
					throw new Exception("*** Exception *** Phonebook capacity exceeded - increase size of underlying array");
				}
				//data is stored in this order
				phonebook[size]=read(input);
				size++;
			
			}
		input.close();
		return size;
	}
	
	public static int lookup(String first, String last,Phonebook[] phonebook,int size) 
	{
		//iterates through the phonebook, checking if the full name matches, returns the position if a match is found.
		//if a match is not found, -1 is returned.
		//input is handled by the main program.
		//display is handled by the main program.
		int position= -1;
		Name temp= new Name(last,first);
		for(int i=0; i<size;i++) 
		{
			if(phonebook[i].getName().equals(temp)) 
			{
				position=i;
			}
		}
		return position;
	}
	
	public static int reverseLookup(String phone, Phonebook[] phonebook,int size) 
	{
		//iterates through the phonebookEntry array, checking if the phone number passed in matches the stored phone numbers.
		//if a match is not found, -1 is returned.
		//input is handled by the main program.
		//display is handled by main program.
		int position=-1;
		PhoneNumber temp= new PhoneNumber(phone);
	
		for(int i=0; i<size;i++) 
		{
			if(phonebook[i].getPhone().equals(temp)) 
			{
			 position=i;	
			}
		}
		return position;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		//opening the keyboard for input to make the program interactive.
		Scanner keyboard= new Scanner(System.in);
		
		//creation of variables to manage user input
		boolean loop=true;
		char operation;
		String first, last, phone;
		int position, amtLookups=0, amtReverseLookups=0;
		Phonebook[] phonebook= new Phonebook[100];
		int size = 0;
		try {
			size = open(phonebook);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				position=lookup(first,last,phonebook,size);
				if(position!=-1) {
					System.out.println(phonebook[position].getName()+"\'s phone number is "+phonebook[position].getPhone());
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
				position=reverseLookup(phone,phonebook,size);
				if(position!=-1) {
					System.out.println(phonebook[position].getPhone()+" belongs to "+phonebook[position].getName());
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
	
}

	