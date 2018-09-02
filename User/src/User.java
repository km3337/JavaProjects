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
