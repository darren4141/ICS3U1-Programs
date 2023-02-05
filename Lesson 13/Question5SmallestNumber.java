import java.io.*;
public class Question5SmallestNumber {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numString;
		int num, smallest;
		System.out.println("Welcome! This program will take numbers and find the smallest one!");
		
		System.out.print("Enter a number <or 'end' to end>: ");
		numString = br.readLine();
		smallest = Integer.parseInt(numString);
		while(!numString.equals("end")){
			num = Integer.parseInt(numString);
			if(num<smallest) smallest = num;
			System.out.print("Enter a number <or 'end' to end>: ");
			numString = br.readLine();
		}
		
		System.out.println("The smallest number is: "+smallest);
		
	}
}
