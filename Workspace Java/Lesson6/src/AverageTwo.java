import java.io.*;
public class AverageTwo {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//declare variables
		double num1Dbl, num2Dbl;
		int average;
		//input
		System.out.print("Please enter the first number: ");
		num1Dbl = Double.parseDouble(br.readLine());
		System.out.print("Please enter the second number: ");
		num2Dbl = Double.parseDouble(br.readLine());
		//calculation
		average = (int)(num1Dbl+num2Dbl)/2;
		//output
		System.out.println("The average of the two numbers is: "+average);
	}
}
