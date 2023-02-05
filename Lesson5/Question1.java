import java.io.*;
import java.text.DecimalFormat;
public class Question1 {
	public static void main(String[] args) throws IOException{
		DecimalFormat oneDecimal = new DecimalFormat(".0");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will take 3 numbers and find the average");
		double num1, num2, num3, average;
		System.out.print("Enter the first number: ");
		num1 = Double.parseDouble(br.readLine());
		System.out.print("Enter the second number: ");
		num2= Double.parseDouble(br.readLine());
		System.out.print("Enter the third number: ");
		num3 = Double.parseDouble(br.readLine());
		average = (num1+num2+num3)/3;
		
		System.out.println("");
		System.out.println("#1:	"+oneDecimal.format(num1));
		System.out.println("#2:	"+oneDecimal.format(num2));
		System.out.println("#3:	"+oneDecimal.format(num3));
		System.out.println("AVG:	"+oneDecimal.format(average));
		
	}
}