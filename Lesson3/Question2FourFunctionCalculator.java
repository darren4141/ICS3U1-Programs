import java.io.*;
public class Question2FourFunctionCalculator {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will add, subtract, multiply, and divide two numbers");
		double num1, num2, add, subtract, multiply, divide;
		System.out.print("Please enter your first number: ");
		num1 = Double.parseDouble(br.readLine());
		System.out.print("Please enter your second number: ");
		num2 = Double.parseDouble(br.readLine());
		add=num1+num2; subtract = num1-num2; multiply = num1*num2; divide = num1/num2;

		System.out.println(num1+" PLUS "+num2+" EQUALS "+(double)Math.round(add*100)/100);
		System.out.println(num1+" MINUS "+num2+" EQUALS "+(double)Math.round(subtract*100)/100);
		System.out.println(num1+" TIMES "+num2+" EQUALS "+(double)Math.round(multiply*100)/100);
		System.out.println(num1+" DIVIDED BY "+num2+" EQUALS "+(double)Math.round(divide*100)/100);
		System.out.println("Thank you for using this program");
	}
}