import java.util.*;
import java.io.*;

class PhonebookEntry {
	private PhoneNumber phoneNumber;
	private Name name;
	
	public PhonebookEntry(Name name,PhoneNumber number) 
	{
		this.phoneNumber= number;
		this.name=name;
	}
	
	public String toString() 
	{
		return name+": "+phoneNumber;
	}
	
	public boolean equals(PhonebookEntry otherEntry) 
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
	
	public static PhonebookEntry read(Scanner scanner) {
		if (!scanner.hasNext()) return null;
		Name newName = Name.read(scanner);
		PhoneNumber newphoneNumber = PhoneNumber.read(scanner);
		return new PhonebookEntry(newName, newphoneNumber);
	}
	
	public void call() 
	{
		System.out.println("phone book entry: "+name+": "+phoneNumber);
		if(phoneNumber.isTollFree()) 
		{
			System.out.println("Dialing (toll-free) "+name+": "+phoneNumber);
			System.out.println();
		}
		else
		{
		System.out.println("Dialing "+name+": "+phoneNumber);
		System.out.println("");
		}
	}
	
	public static void main(String[] args) throws Exception
	{	
		String tempFirst="temp", tempLast="temp", tempNumber="temp";
		PhoneNumber oldNumber= new PhoneNumber(tempNumber);
		Name oldName= new Name(tempLast,tempFirst);
		PhonebookEntry temp= new PhonebookEntry(oldName, oldNumber);
		int count=0;
		Scanner scanner = new Scanner(new File("phonebook.text"));
		PhonebookEntry entry=read(scanner);
		while(entry!=null) 
		{
			if(entry.equals(temp)) 
			{
				entry.call();
				count++;
			}
			else 
			{
				count++;	
			}
			oldName=entry.name;
			oldNumber=entry.phoneNumber;
			temp= new PhonebookEntry(oldName,oldNumber);
			entry=read(scanner);
		}
		System.out.println("---");
		System.out.println(count+" phonebook entries processed.");
		
	}

}
