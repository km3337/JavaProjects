import java.util.Scanner;

public class ColoredWindow extends Window {

	char backgroundColor;
	public ColoredWindow(int width, int height,char color) {
		super(width,height);
		this.backgroundColor=color;
	}
	
	public ColoredWindow(int width, int height) {
		super(width,height);
		this.backgroundColor='.';
	}
	
	public String toString() {
		return "a "+getWidth()+"x"+getHeight()+" window with background color "+getColor();
	}
	
	public char getColor() {
		return this.backgroundColor;
	}

	public void setColor(char newColor) 
	{
		this.backgroundColor=newColor;
	}
	
	public void displayNormal() {
		for(int i=0; i<getHeight();i++) {
			for(int k=0; k<getWidth();k++) {
				System.out.print(getColor());
			}
			System.out.println();
		}
	}
	
	public static ColoredWindow read(Scanner scanner) 
	{
		int width, height;
		char color;
		width=scanner.nextInt();
		height=scanner.nextInt();
		color=scanner.next().charAt(0);

		return new ColoredWindow(width,height,color);
	}
}
