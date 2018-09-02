import java.util.Scanner;
import java.io.*;


class User {
	private String username;
	private String password;
	private String passHint;
	
	public User(String username, String password, String passHint) 
	{
		this.username=username;
		this.password=password;
		this.passHint=passHint;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getHint() {
		return this.passHint;
	}
	
	public boolean verifyPassword(String attempt) 
	{
		return password.equals(attempt);
	}
	
	public String toString() 
	{
		return  "User "+this.username;
	}
	
	public static User read(Scanner scanner) 
	{
		if (!scanner.hasNext()) return null;
		String user, pass, hint;
		user=scanner.next();
		pass=scanner.next();
		hint=scanner.next();
		return new User(user,pass,hint);
	
	}
	
}
class Authenticator {
	User[] users= new User[100];
	int size=0;

	
	public Authenticator(String filename) throws IOException{
		Scanner scanner= new Scanner(new File(filename));
		while(scanner.hasNext()) {
			this.users[size]= User.read(scanner);
			size++;
		}
	}
	
	public void authenticate(String username, String passAttempt) 
	{
		boolean userfound=false;
		for(int i=0; i<size;++i) 
		{
			if(username.equals(users[i].getUsername()) && users[i].verifyPassword(passAttempt))
			{
				System.out.println("Welcome to the system");
				userfound=true;
			}
			
			else if(users[i].getUsername().equals(username) && !(users[i].verifyPassword(passAttempt))) 
			{
				System.out.println("*** Invalid password - hint:"+users[i].getHint());
				userfound=true;
			}	
		}
		if(userfound==false) {System.out.println("*** User not found ");}
		
		
	}
	
	public static void main(String[] args) {
		

	}

}
