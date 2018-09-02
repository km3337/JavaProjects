/*
 * Kristian Mentor
 * HW7: Bank Accounts
 * CISC1115
 * */
import java.io.*;
import java.util.Scanner;
public class BankSystem {
	public static void main(String[] args) throws java.lang.Exception
	{
		//Creation of variables needed for program.
		PrintWriter outFile= new PrintWriter("D:\\EclipseWorkspace\\BankAccounts\\src\\output.txt");
		boolean loop=true;
		char operation;
		Scanner keyboard = new Scanner(System.in);
		//Creation of Pre existing database.
		//Allows for a maximum of 100 users.
		int accNums[]= new int[100] ;
		double accBalances[]= new double[100];
		int amtUsers=readAccts(accNums,accBalances);
		printAccts(accNums,accBalances, amtUsers, outFile);

		System.out.println("\t Bank Data Base ");
		System.out.println("=======================================");
		while(loop)
		{
			menu();
			System.out.println("\nPlease enter an operation to carry out: ");
			operation=keyboard.next().charAt(0); //returns the char at string's O

			switch(operation)
			{
			//Withdrawal from account
			case 'W':
			case 'w':
				System.out.println("Withdrawal Selected.");
				withdrawal( accNums, accBalances, keyboard, amtUsers,outFile);
				System.out.println("Withdrawal Successful");
				break;
				//Deposit into account
			case 'D':
			case 'd':
				System.out.println("Deposit Selected.");

				deposit(accNums, accBalances, keyboard, amtUsers,outFile);
				System.out.println("Deposit Successful");
				break;
				//Create new Account
			case 'N':
			case 'n':
				System.out.println("Creating new Account.");
				amtUsers=newAcct( accNums, accBalances, keyboard,amtUsers,outFile);

				System.out.println("Account creation successful.");
				break;
				//Check Account Balance
			case 'B':
			case 'b':
				System.out.println("Checking Account Balance");
				balance( accNums, accBalances, amtUsers, keyboard,outFile);
				break;
				//Quit from Program
			case 'Q':
			case 'q':
				System.out.println("Quitting Database.");
				loop=false;
				printAccts(accNums,accBalances,amtUsers,outFile);
				break;
				//Delete Account from Program
			case 'X':
			case 'x':
				System.out.println("Account Deletion selected.");
				amtUsers=delete( accNums, accBalances, keyboard, amtUsers, outFile);
				System.out.println("Deletion Successful");
				break;
			default:
				System.out.println("Error 404: Wrong input detected.");
				System.out.println(operation+ " is Invalid Input.");
				break;
			}
			outFile.flush();
		}
		keyboard.close();
		outFile.close();
	}
	public static void menu()
	//This method displays the UI for the Banking
	//System.
	{
		System.out.println("Select one of the Following Functions:");
		System.out.println("\n W - Withdrawal \n D - Deposit ");
		System.out.println(" N - New Account \n B - Balance ");
		System.out.println(" Q - Quit \n X - Delete Account ");
	}

	public static void addAcct(int[] accNums, double[] accBalances, int location, int
			acc, double balance)
	//This method adds one account's information to the
	//parallel arrays accNum and accBalance
	//it is also passed in the location of where the data is going
	//and the information to be placed into the new account
	//primarily used in the initial readAccts function.
	{
		accNums[location]= acc;
		accBalances[location]=balance;
	}
	
	public static int readAccts(int[] accNums, double[] accBalances) throws
	FileNotFoundException
	//This method is responsible for initially adding
	//all the pre-existing users to the database.
	//it reads in information from a data file and
	//uses the addAcct() function to add that information to
	//the database.
	{
		Scanner inputFile = new Scanner(new File("D:\\\\EclipseWorkspace\\\\BankAccounts\\\\src\\input.txt"));
		int location=0, amtUsers=0;
		int acc;
		double balance;
		System.out.println("Entering in previously existing information...");
		while(inputFile.hasNextLine())
		{
			acc=inputFile.nextInt();
			balance=inputFile.nextDouble();
			BankSystem.addAcct(accNums,accBalances,location, acc, balance);
			System.out.println("success!\n");
			location++;
			amtUsers++;
		}
		inputFile.close();
		return amtUsers;
	}
	
	public static void printAccts(int[] accNums, double[] accBalances, int totalAccts,
			PrintWriter outFile)
	//This method loops through the database
	//printing out the database in a nice way.
	//stopping at the total # of Accs
	{
		outFile.println("\n\t\t    Bank Data Base ");
		outFile.println("=======================================");
		outFile.println("||=||=||=||=||=||=||=||=||=||=||=||=||");
		outFile.println("=======================================");
		outFile.println("Acc ID \t\t\t Balance\n");
		for(int i=0;i<totalAccts;i++)
		{
			outFile.printf("%7d \t\t $%, 7.2f\n",accNums[i], accBalances[i]);
			outFile.println("======================================");
		}
		outFile.println("Total # of Accounts:"+ totalAccts);
		outFile.println(" ");
		outFile.flush();
	}

	public static int findAcct(int[] accNums,int amtUsers, int toFindID )
	//Searches for a given ID, if that ID is found in the array of Accs
	//this function will return that accs location within the array
	//if not found, -1 is returned instead.
	{
		for(int i=0;i<=amtUsers;i++)
		{
			if(accNums[i]==toFindID) {System.out.println("found! ID: "+accNums[i]);return
					i;}
		}
		return -1;
	}
	
	public static void withdrawal(int[] accNums, double[] accBalances, Scanner
			keyboard, int amtUsers, PrintWriter outFile)
	//using the findAcct() method, the withdrawal method removes money from that
	//accounts balance.
	{
		int ID, location;
		System.out.println("Please enter an Account #: ");
		ID=keyboard.nextInt();
		outFile.println("\nWithdrawal for Account#:"+ID);
		outFile.println("===============================");
		if((location=findAcct(accNums, amtUsers, ID))==-1)
		{
			System.out.println("Error 230: Account not found");
			outFile.println("Error 230: Account not Found");
			outFile.println("===============================");
			outFile.flush();
			return;
		}
		System.out.println("Please enter an Amount to Withdraw: $");
		double withdrawalAmt=keyboard.nextDouble();
		if(withdrawalAmt<0 | withdrawalAmt>accBalances[location])
		{
			outFile.printf("Exception found with input: $%,7.2f", withdrawalAmt);
			outFile.println("Error 243: Invalid Withdrawal Amount ");
			outFile.println("===============================");
			outFile.flush();
			return;
		}
		outFile.println("Withdrawal Succesful");
		outFile.printf("Prev. Balance: $%,7.2f",accBalances[location]);
		accBalances[location]= accBalances[location] - withdrawalAmt;
		outFile.printf("\nCurrent Balance: $%,7.2f\n",accBalances[location]);
		outFile.println("===============================");
		outFile.flush();
		return;
	}
	
	public static void deposit(int[] accNums,double[] accBalances, Scanner keyboard,
			int amtUsers, PrintWriter outFile)
	//Using findAcct(), this function searches for the account to be deposited within.
	{
		int ID, location;
		System.out.println("Please enter an Account #: ");
		ID=keyboard.nextInt();
		outFile.println("\nDeposit for Account#:"+ID);
		outFile.println("===============================");
		if(findAcct(accNums, amtUsers, ID)==-1)
		{
			outFile.println("Error 230: Account not found");
			outFile.println("===============================");
			outFile.flush();
			return;
		}
		location=findAcct(accNums,amtUsers,ID);
		System.out.println("Please enter an Amount to Deposit: $");
		double depositAmt=keyboard.nextDouble();
		if(depositAmt<0)
		{
			outFile.printf( "\nException found with input: $%,7.2f\n", depositAmt);
			outFile.println("Error 315: Invalid Deposit Amount.");
			outFile.println("===============================");
			outFile.flush();
			return;
		}
		outFile.println("Deposit Succesful");
		outFile.printf("Prev. Balance: $%,7.2f\n",accBalances[location]);
		accBalances[location]= accBalances[location] + depositAmt;
		outFile.printf("Current Balance: $%,7.2f\n",accBalances[location]);
		outFile.println("===============================");
		outFile.flush();

	}
	public static int newAcct(int[] accNums, double[] accBalances, Scanner keyboard,
			int totalAccts, PrintWriter outFile)
	//allows user to add new Accounts into the database,
	//does not allow user to add more than the max # of accounts.
	//returns the new amount of User accounts.
	{
		if(totalAccts!=100)
		{
			System.out.println("Please enter a new Account #:");
			int ID=keyboard.nextInt();
			outFile.println("\nAccount Creation:"+ ID);
			outFile.println("===============================");
			if(findAcct(accNums, totalAccts, ID)!=-1)
			{
				outFile.println("Error 231: Account already exists");
				outFile.println("===============================");
				outFile.flush();
				return totalAccts;

			}
			accNums[totalAccts]= ID;
			accBalances[totalAccts]=0.0;
			totalAccts++;
			outFile.println("New account created with ID#"+ ID);
			outFile.println("===============================");
			return totalAccts;
		}
		System.out.println("Maximum # of Accounts reached.");
		return totalAccts;
	}

	public static void balance(int[] accNums, double[] accBalances, int totalAccts,
			Scanner keyboard, PrintWriter outFile)
	//using findAcct(), this method finds the account in question, and displays their
	//balance amount.
	{
		int ID, location;
		System.out.println("Please enter an Account #: ");
		ID=keyboard.nextInt();
		outFile.println("\nAccount#:"+ID);
		outFile.println("===============================");
		if((location=findAcct(accNums, totalAccts, ID))==-1)
		{
			System.out.println("Error 230: Account not found");
			outFile.println("Error 230: Account not found");
			outFile.println("===============================");
			outFile.flush();
			return;
		}
		outFile.printf("Account Balance: $%, 7.2f\n",accBalances[location]);
		outFile.println("===============================");
		outFile.flush();
	}

	public static int delete(int[] accNums,double[] accBalances, Scanner keyboard, int
			amtUsers, PrintWriter outFile)
	//This method is Extra Credit version #2
	//delete creates temporary copies of the original arrays
	//editing that temporary copy to exclude the value to be deleted
	//but checks to see if that accID has a balance associated with it.
	//if the balance is not 0, the account cannot be deleted.
	//returns the amount of users.
	{
		int removalID, location;
		System.out.println("Please enter an Account #: ");
		removalID=keyboard.nextInt();
		outFile.println("\n Deletion of Account#:"+removalID);
		outFile.println("===============================");
		if((location=findAcct(accNums, amtUsers, removalID))==-1)
		{

			outFile.println("Error 230: Account not found");
			outFile.println("===============================");
			outFile.flush();
			return amtUsers;
		}

		if (accBalances[location]==0)
		{
			//create two temporary arrays to store the old data values
			int tempAccNums[]= new int[100] ;
			double tempAccBalances[]= new double[100];
			int shift=0;
			for(int i=0; i<amtUsers;i++)
			{
				//populate the temporary arrays with the old data values, except
				//the ID to be removed.
				if(i==location)
				{
					++shift;
					tempAccNums[i]= accNums[i+shift];
					tempAccBalances[i]= accBalances[i+shift];
				}
				else
				{
					tempAccNums[i]= accNums[i+shift];
					tempAccBalances[i]= accBalances[i+shift];
				}
			}

			//copy the temp fixed values back over into the original.
			amtUsers--;
			for(int i=0; i<amtUsers;i++)
			{
				accNums[i]=tempAccNums[i];
				accBalances[i]=tempAccBalances[i];
			}
			outFile.println("Deletion Successful");
			outFile.println("===============================");
			outFile.flush();
			return amtUsers;
		}
		outFile.println("Error 808: Account Balance not =0. \nCannot delete.");
		outFile.println("===============================");
		outFile.flush();
		return amtUsers;
	}
}
