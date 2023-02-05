import java.io.*;
public class Question8PerfectNumber {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		System.out.println("Welcome! This program will determine if your number is a perfect number");
		System.out.println("A perfect number is equal to the sum of its proper divisors");
		System.out.print("Enter a number <or enter '0' to exit>: ");
		num = Integer.parseInt(br.readLine());
		
		while(num!=0){
			int divisorSum = 0;
			for(int i = 1; i <= (num/2); i++){
				if(num%i==0){
					divisorSum+=i;
				}
			}
			
			if(divisorSum == num){
				System.out.println("Your number is a perfect number");
			}else{
				System.out.println("Your number is NOT a perfect number");
			}
			
			System.out.print("Enter a number <or enter '0' to exit>: ");
			num = Integer.parseInt(br.readLine());

		}
		
		System.out.println("Thanks for using this program!");
		
	}
}