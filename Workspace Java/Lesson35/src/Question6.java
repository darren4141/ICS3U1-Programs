import java.io.*;

public class Question6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main (String[]args)throws IOException{
		Question6 Q6 = new Question6();
		double num1, num2, num3, sum, average, largestNum;
		System.out.println("Welcome! This program will input 3 numbers and determine the sum, average, and highest value");
		System.out.println("Enter the first number");
		num1 = Q6.readDouble();
		
		System.out.println("Enter the second number");
		num2 = Q6.readDouble();

		System.out.println("Enter the third number");
		num3 = Q6.readDouble();
		
		sum = Q6.sum(num1,num2,num3);
		average = Q6.average(num1,num2,num3);
		largestNum = Q6.findLargest(num1,num2,num3);
		
		System.out.println(Q6.displayMessage("sum", sum));
		System.out.println(Q6.displayMessage("average", average));
		System.out.println(Q6.displayMessage("largest", largestNum));

		
	}
	
	public double readDouble() throws IOException{
		return Double.parseDouble(br.readLine());
	}
	
	public double sum(double one, double two, double three){
		return (double)Math.round((one+two+three)*100)/100;
	}
	
	public double average(double one, double two, double three){
		return (double)Math.round((sum(one, two, three)/3)*100)/100;
	}
	
	public double findLargest(double one, double two, double three){
		double largest;
		if(one > two) largest = one;
		else largest = two;
		
		if(three > largest) largest = three;
		
		return largest;
		
	}
	
	public String displayMessage(String operation, double result){
		return "The " +operation+ " of the three numbers is: "+result;

	}
	
}
