import java.io.*;
public class Question1RectangleCalculator {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double length, width, perimeter, area;
		
		System.out.println("Welcome to the rectangle area and perimeter calculator!");
		System.out.print("Enter your length: ");
		length = Double.parseDouble(br.readLine());
		System.out.print("Enter your width: ");
		width = Double.parseDouble(br.readLine());
		
		perimeter = (2*length)+(2*width);
		area = length*width;
		System.out.println("The perimeter of the rectange with length " +length+" and width "+width+" is "+perimeter);
		System.out.println("The area of the rectange with length " +length+" and width "+width+" is "+area);
		System.out.println("Thanks for using this program!");
		
	}
}