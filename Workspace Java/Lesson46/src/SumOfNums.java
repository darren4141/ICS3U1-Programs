import java.io.*;
public class SumOfNums {

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SIZE = 10;
		int [] nums = new int[SIZE];
		int total = 0;
		
		System.out.println("Welcome! This program will input "+SIZE+" numbers and tell you the sum");
		
		for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(br.readLine());
			
		System.out.print("The numbers entered were: ");
		
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i] + ", ");
			total += nums[i];
		}
		
		System.out.println("\nThe sum of these numbers is "+total);
		
	}
	
}
