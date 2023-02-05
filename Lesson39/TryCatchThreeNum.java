import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryCatchThreeNum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main (String[]args)throws IOException{
		
		TryCatchThreeNum tn = new TryCatchThreeNum();
		double num1, num2, num3, sum, average, largestNum;
		System.out.println("Welcome! This program will input 3 numbers and determine the sum, average, and highest value");
		
		num1 = tn.readDouble("Enter the first number");
		num2 = tn.readDouble("Enter the second number");
		num3 = tn.readDouble("Enter the third number");
		
		sum = tn.sum(num1,num2,num3);
		average = tn.average(num1,num2,num3);
		largestNum = tn.findLargest(num1,num2,num3);
		
		System.out.println(tn.displayMessage("sum", sum));
		System.out.println(tn.displayMessage("average", average));
		System.out.println(tn.displayMessage("largest", largestNum));

		
	}
	
	public double readDouble(String message) throws IOException{
		
		double num;
		
		while(true){
			System.out.println(message);
			
			try{
				num = Double.parseDouble(br.readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Enter a number!");
				System.out.println(e.getMessage());
			}
			
		}
		return num;
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
