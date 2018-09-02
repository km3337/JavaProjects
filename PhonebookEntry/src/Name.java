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

	public static void main(String [] args) throws Exception {
		String oldFirst="temp", oldLast="temp";
		Scanner scanner = new Scanner(new File("names.text"));

		int count = 0;

		Name name = read(scanner);
		while(name != null) {
			if(name.first.equals(oldFirst) && name.last.equals(oldLast))
				{
				System.out.println("\nDuplicate name \""+oldFirst+" "+oldLast+"\" discovered");
				}
			else {
			System.out.println("name: "+name);
			System.out.println("formal: " + name.getFormal());
			System.out.println("official: " + name.getOfficial());
			System.out.println("initials: "+name.getInitials());
			count++;
			}
			
			
			oldFirst=name.first;
			oldLast=name.last;
			name = read(scanner);
		}
		System.out.println("---");
		System.out.println(count + " names processed.");
	}
}
