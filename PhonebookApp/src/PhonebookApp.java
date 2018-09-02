// Kristian Mentor - CISC 3115:PhonebookApp.Java
import java.util.*;
import java.io.*;
import java.util.TreeMap;

class PhonebookApp {
	public static void main(String[] args) throws IOException {
		//opening the keyboard for input to make the program interactive.
		String fileName= args[0];
		//String fileName="D:\\EclipseWorkspace\\PhonebookApp\\src\\phonebook.txt";
		Phonebook contacts= new Phonebook(fileName);
		Scanner keyboard= new Scanner(System.in);
		//creation of variables to manage user input
		boolean loop=true;
		char operation;
		String first, last;
		while(loop) 
		{
			System.out.println("lookup, quit? (l/q/)");
			operation=keyboard.next().charAt(0); //returns the char at string's O
			switch(operation)
			{
			case 'L':
			case 'l':
				System.out.println("last name?");
				last=keyboard.next();
				System.out.println("first name?");
				first=keyboard.next();
				contacts.lookup(first, last);
				break;

			case 'Q':
			case 'q':
				System.out.println();
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


class Name implements Comparable<Name> {
	public Name(String last, String first) {
		this.last = last;
		this.first = first;
	}
	public Name(String first) {this("", first);}

	public String getFormal() {return first + " " + last;}
	public String getOfficial() {return last + ", " + first;}
	public String getInitials() {return (Character.toString(first.charAt(0)) +"."+ Character.toString(last.charAt(0))+ ".");}

	public boolean equals(Name other) {return first.equals(other.first) && last .equals(other.last);}

	@Override
	public String toString() {return first + " " + last;}

	public static Name read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		String last = scanner.next();
		String first = scanner.next();
		return new Name(last, first);
	}

	@Override
	public int compareTo(Name other) {
		return this.getFormal().compareTo(other.getFormal());
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

	@Override
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
class ExtendedPhoneNumber extends PhoneNumber{
	private String description;

	public ExtendedPhoneNumber(String description, String number) {
		super(number);
		this.description=description;
	}

	public static ExtendedPhoneNumber read(Scanner scanner) 
	{
		if (!scanner.hasNext()) return null;
		String description= scanner.next();
		String number= scanner.next();
		return new ExtendedPhoneNumber(description,number);
	}

	@Override
	public String toString() {
		return description+": "+getNumber();
	}
}

class PhonebookEntry{
	private Name name;
	private ArrayList<ExtendedPhoneNumber> entries;

	public PhonebookEntry(Name name, ArrayList<ExtendedPhoneNumber> entries) {
		this.name=name;
		this.entries=entries;
	}

	public Name getName() {return this.name;}
	public ArrayList<ExtendedPhoneNumber> getNumbers(){return this.entries;}

	@Override
	public String toString() {
		String result= getName().toString()+"\'s phone numbers: [";
		for(ExtendedPhoneNumber d: this.entries) 
		{
			result+=(d.toString()+",");
		}
		return result.substring(0, result.length()-1) +"]";
	}

	public static PhonebookEntry read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		ArrayList<ExtendedPhoneNumber> newEntries= new ArrayList<ExtendedPhoneNumber>();
		Name newName= Name.read(scanner);
		int loopAmt= scanner.nextInt();	
		while(loopAmt>0) {
			ExtendedPhoneNumber newNumber= ExtendedPhoneNumber.read(scanner);
			loopAmt--;
			newEntries.add(newNumber);
		}
		//all new entries added.
		return new PhonebookEntry(newName,newEntries);
	}
}

class Phonebook{
	public TreeMap<Name,PhonebookEntry> local=new TreeMap<Name,PhonebookEntry>();
	public Phonebook(String fileName) throws IOException {
		Scanner input= new Scanner(new File(fileName));
		Name newName;
		PhonebookEntry newEntry;
		while(input.hasNext()) 
		{
			newEntry=PhonebookEntry.read(input);
			newName=newEntry.getName();
			if(newEntry!= null && newName!=null) {local.put(newName, newEntry);}
		}
	}

	public void lookup(String first, String last) 
	{
		Name toFind= new Name(last,first);
		if(this.local.containsKey(toFind)) 
		{
			System.out.println(local.get(toFind));
			System.out.println();
		}
		else System.out.println("-- Name not found\n");
	}
}





