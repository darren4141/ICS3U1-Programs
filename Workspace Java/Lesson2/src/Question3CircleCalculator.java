import java.io.*;
public class Question3CircleCalculator {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double pi = 3.14159, radius, circumference, area;
		System.out.println("Welcome! This program will calculate the circumference and area of a cirlce using the radius");
		System.out.print("Enter the radius of your circle: ");
		radius = Double.parseDouble(br.readLine());
		circumference = 2*radius*pi;
		area = pi*radius*radius;
		System.out.println("The circumference of the circle with radius: " +radius+ " is: "+ (double)Math.round(circumference*100)/100);
		System.out.println("The area of the circle with radius: " +radius+ " is: "+ (double)Math.round(area*100)/100);
		System.out.println("Thank you for using this program!");
	}
}