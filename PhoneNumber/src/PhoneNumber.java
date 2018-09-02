import java.util.*;
import java.io.*;

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
	
	public static void main(String[] args) throws Exception{
		String oldNumber="temp";
		Scanner scanner = new Scanner(new File("numbers.text"));
		int count=0;
		PhoneNumber phone=read(scanner);
		while(phone!=null) {
			if(phone.getNumber().equals(oldNumber)) 
			{
			System.out.println("Duplicate phone number \" "+oldNumber+"\" discovered ");	
			count++;
			}
			else 
			{
				System.out.println("phone number: "+phone);
				System.out.println("area code: "+phone.getAreaCode());
				System.out.println("exchange: "+phone.getExchange());
				System.out.println("line number: "+phone.getLineNumber());
				System.out.println("is toll free: "+phone.isTollFree());
				System.out.println("");
				count++;
			}
			oldNumber=phone.getNumber();
			phone=read(scanner);
		}
		System.out.println("---");
		System.out.println(count+" phone numbers processed.");

	}

}
