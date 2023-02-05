   import java.io.*;
public class Question3SphereCalculator {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will calculate the volume and surface area of a sphere given the radius.");
		System.out.println("Enter a negative number to stop the program");
		double rad = 0, volume, surfaceArea;
		final double PI = 3.14159;
		System.out.print("Enter a radius: ");
		rad = Double.parseDouble(br.readLine());
		
		while(rad>=0){
			volume = 4*PI*(rad*rad*rad)/3;
			surfaceArea = 4*PI*rad*rad;
			System.out.println("The volume of a sphere with radius "+rad+" is "+(double)Math.round(volume*100)/100);
			System.out.println("The surface area of a sphere with radius "+rad+" is "+(double)Math.round(surfaceArea*100)/100);
			System.out.print("Enter a radius: ");
			rad = Double.parseDouble(br.readLine());
			
		}
		
		System.out.println("Negative number entered");
		System.out.println("Thanks for using this program!");
		
	}
}
