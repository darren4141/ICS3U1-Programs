import java.io.*;
public class DoubleSum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[]args) throws IOException{
		DoubleSum dS = new DoubleSum();
		double num1, num2, sum;
		System.out.println("Welcome! This program will calculate the sum of two numbers!");
		System.out.print("Enter a number: ");
		num1 = dS.readDouble();
		System.out.print("Enter another number: ");
		num2 = dS.readDouble();
		sum = dS.findSum(num1, num2);
		System.out.println(num1 + " + " + num2 + " = " + (double)Math.round(sum*100)/100);
		
	}
	
	public double readDouble() throws IOException{
		return Double.parseDouble(br.readLine());
	}
	
	public double findSum(double num1, double num2){
		return num1 + num2;
	}
	
}
