import java.io.*;
public class circleArea {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	final static double PI = 3.14159265;
	public static void main (String[]args) throws IOException{
		circleArea cA = new circleArea();
		double radius, area;
		System.out.println("Welcome! This program will calculate the area of a circle!");
		System.out.print("Enter a radius: ");
		radius = cA.readDouble();
		area = cA.calculateArea(radius);
		System.out.println("The area of a circle with radius " + radius + " is: " + (double)Math.round(area*100)/100);
		
		
	}
	
	public double readDouble() throws IOException{
		return Double.parseDouble(br.readLine());
	}
	
	public double calculateArea(double rad){
		double area = rad*rad*PI;
		return area;
	}
	
}
