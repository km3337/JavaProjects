import java.util.Scanner;
/*CISC 3115
 * Kristian Mentor
 * HW 1: Info of 3
 * 
 * 
 * */
public class InfoOf3 {

public static void main(String[] arg) 
{
	//System.out.println("Welcome to Info of 3: a boolean evaluation program.");
	int num1,num2,num3; //the three variables for this boolean evaluation HW.
	Scanner keyboard= new Scanner(System.in);
	System.out.print("\nFirst number? :");
	num1=keyboard.nextInt();
	System.out.print("\nSecond number? :");
	num2=keyboard.nextInt();
	System.out.print("\nThird number? :");
	num3=keyboard.nextInt();
	//all numbers have been acquired, keyboard can be closed now.
	keyboard.close();
	
	//running boolean evaluations...
	System.out.println("allAreEqual: "+allAreEqual(num1,num2,num3));
	System.out.println("twoAreEqual: "+twoAreEqual(num1,num2,num3));
	System.out.println("noneAreEqual: "+noneAreEqual(num1,num2,num3));
	System.out.println("areAscending: "+areAscending(num1,num2,num3));
	System.out.println("areDescending: "+areDescending(num1,num2,num3));
	System.out.println("strictlyAscending: "+strictlyAscending(num1,num2,num3));
	System.out.println("strictlyDescending: "+strictlyDescending(num1,num2,num3));
	
}

public static boolean allAreEqual(int a,int b, int c) {
	//evalautes if all of the ints passed in are equal.
	boolean result;
	if(a==b && b==c && a==c) {
		result=true;
	}
	else result=false;
	return result;
	
}

public static boolean twoAreEqual(int a, int b,int c){
	//uses a counter to check if exactly 2 ints are equal.
	boolean result=true;
	int amtEqual=0;
	if(a==b) amtEqual++;
	if(a==c)amtEqual++;
	if (b==c)amtEqual++;
	if(amtEqual==3 || amtEqual<2) {result=false;}
	if(amtEqual==2) {result=true;}
	return result;
}

public static boolean noneAreEqual(int a, int b, int c) {
	//similar to twoAreEqual, uses a counter to make sure the amount of equal ints are 0.
	boolean result=true;
	int amtEqual=0;
	if(a==b) amtEqual++;
	if(a==c)amtEqual++;
	if (b==c)amtEqual++;
	if(amtEqual>0) result=false;
	return result;
}

public static boolean areAscending(int a, int b, int c){
	//tests to see if the integers are in ascending order using boolean logic.
	boolean result=false;
	if(a<=b && b<=c) {result=true;}
	return result;	
}

public static boolean areDescending(int a, int b, int c) {
	//tests to see if the integers are in descending order using boolean logic.
	boolean result=false;
	if((a>=b && b>=c)) {result=true;}
	return result;
}

public static boolean strictlyAscending(int a, int b, int c) {
	//tests to see if the integers are in strictly ascending order using boolean logic.
	//numbers cannot be equal to one another.
	boolean result= false;
	if(a<b && b<c) {result=true;}
	return result;	
}

public static boolean strictlyDescending(int a, int b, int c) {
	//tests to see if the integers are in strictly descending order using boolean logic.
	//numbers cannot be equal to one another.
	boolean result= false;
	if(a>b && b>c) {result=true;}
	return result;
}
}
