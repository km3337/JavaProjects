import java.util.Scanner;

public class BorderedWindow extends Window {

	public BorderedWindow(int width, int height) {
		super(width+2, height+2);
		// TODO Auto-generated constructor stub
	}
	
	public int getWidth() 
	{
		return super.getWidth()-2;
	}

	public int getHeight() {
		return super.getHeight()-2;
	}
	
	public void resize(int newWidth,int newHeight) 
	{
		super.resize(newWidth+2, newHeight+2);
	}
	
	public void displayNormal() {
		System.out.print("+");
		for(int i=0; i<getWidth(); i++) 
		{
			System.out.print("-");
		}
		System.out.print("+\n");
		
		for(int k=0; k<getHeight();k++) 
		{
			System.out.print("|");
			for(int m=0; m<getWidth();m++) 
			{
				System.out.print(" ");	
			}
			System.out.print("|\n");	
		}
		
		System.out.print("+");
		for(int i=0; i<getWidth(); i++) 
		{
			System.out.print("-");
		}
		System.out.print("+\n");
	}
	
	public static BorderedWindow read(Scanner scanner) {
		int width, height;
		width=scanner.nextInt();
		height=scanner.nextInt();
		return new BorderedWindow(width,height);
	}
	
	public String toString() {
		return "a "+getWidth()+"x"+getHeight()+" window with a border ";
	}
}
