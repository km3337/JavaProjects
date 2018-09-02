import java.io.File;
import java.io.FileNotFoundException;
import java.math.*;
import java.util.*; 
 /***
  * The Point class represents a two-dimensional point, i.e., a point with an x (horizontal) and a y (vertical) component.
 *
 ***/

 class Point {
         /* Initializes a Point with the specified components
        *
        * @param x the x (horizontal) coordinate of the point
        * @param y the e(vertical) coordinate of the point
       ***/
       public Point(int x, int y) {
                 this.x = x;
                this.y = y;
        }

        /***
         * Initializes a Point to the origin (0, 0)
         ***/
       public Point() {this(0, 0);}

         /***
        * Returns the result of adding two points
       *
          * @return a Point object containng the sum of the two points
       ***/
        public Point add(Point otherPoint) {
               return new Point(x + otherPoint.x, y + otherPoint.y);
        }

        /***
         * Returns the distance between two points
         *
         * @param otherPoint the point whose distance from the receiver is to be calculated
         * @return a Point object containng the distance between the two points
         ***/
        public double distance(Point otherPoint) {
                 return Math.sqrt(Math.pow(x-otherPoint.x, 2) + Math.pow(y - otherPoint.y, 2));
        }

       /***
          * Returns the point obtained by a reflection of this point across the x-axis
        *
        * @return a Point object containng the reflection across the x-axis of this point
      ***/
         public Point xReflection() {return new Point(x, -y);}

         /***
        * Returns the point obtained by a reflection of this point across the y-axis
          *
        * @return a Point object containng the reflection across the y-axis of this point
        ***/
         public Point yReflection() {return new Point(-x, y);}

        /***
        * Returns the point obtained by a reflection of this point through the origin
        *
       * @return a Point object containng the reflection through the origin of this point
         ***/
        public Point originReflection() {return new Point(-x, -y);}

        /***
          * Returns the quadrant (1, 2, 3, 4, or 0) that this point resides in
          *
         * @return the qudrat this point resides in (1, 2, 3, or 4). If the point is the origin, 0 is returned.
         ***/
         public int quadrant() {return x > 0 ? (y > 0 ? 1 : 4) : x < 0 ? (y > 0 ? 2 : 3) : 0;} 
 
         /***
          * Returns the result of checking the equality of two point -- two points are equal if their x and y coordinates are equal
         *
         * @param otherPoint the point to be checked for equality with the reciever
         * @return true if the points are equal; false otherwise
         ***/
        public boolean equals(Point otherPoint) {return x == otherPoint.x && y == otherPoint.y;}

        /***
         * Returns a string representation of the point in the form (x, y)
         *
          * @return the string representation
         ***/
         public String toString() {return "(" + x + ", " + y + ")";}

        /***
         * Returns a newly created Point object initialized with x,y values read from the scanner
          *
         * @param scanner The Scanner used to read the point's initial values
         * @return The newly created Point object
        ***/
        public static Point read(Scanner scanner) {
               if (!scanner.hasNext()) return null;
                 int x = scanner.nextInt();
                 int y = scanner.nextInt();
               return new Point(x, y);
         }

         private int x, y;

        /***
          * A constant Point representing the origin (0, 0)
         ***/
        public final static Point ORIGIN = new Point();
 }
public class PointApp {

	public static void main(String[] args) throws FileNotFoundException {
	Scanner input= new Scanner(new File("D:\\EclipseWorkspace\\PointApp\\src\\points.txt"));
	while(input.hasNextLine()) 
	{
		//create two temp values for the points on the current line
		Point temp1= Point.read(input);
		Point temp2= Point.read(input);
		
		//start testing methods
		System.out.print("p1: "+temp1.toString()+" quadrant "+temp1.quadrant()+") / ");
		System.out.print("p2: "+temp2.toString()+" quadrant "+temp2.quadrant()+")\n");
		
		//p1+p2
		Point tempAdd=temp1.add(temp2);
		System.out.print("p1+p2: "+tempAdd.toString()+"(Quadrant "+tempAdd.quadrant()+")\n");
		
		//x-reflections
		Point reflectX=temp1.xReflection();
		if(reflectX.equals(temp2)) 
		{
			System.out.print("p1 and p2 are reflections across the x-axis\n");
		}
		
		//y-reflections 
		Point reflectY=temp1.yReflection();
		if(reflectY.equals(temp2)) 
		{
			 System.out.print("p1 and p2 are reflections across the y-axis\n");
		}
		
		//origin-reflections
		Point reflectOrigin=temp1.originReflection();
		if(reflectOrigin.equals(temp2)) 
		{
			System.out.print("p1 and p2 are reflections through the origin\n");
		}
		
		//distance from origin check
		if(temp1.distance(Point.ORIGIN)==temp2.distance(Point.ORIGIN)) 
		{
			System.out.print("p1 and p2 are equidistant from the origin\n");
		}
		
		//distance
		System.out.print("The distance between "+temp1.toString()+" and "+temp2.toString()+" is "+temp1.distance(temp2)+"\n\n" );
	}	
	}

}
 
