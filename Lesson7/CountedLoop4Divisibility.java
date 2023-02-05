import java.io.*;
public class CountedLoop4Divisibility {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will show which numbers are divisible by a number you enter");
		System.out.print("Enter a number: ");
		int num = Integer.parseInt(br.readLine());
		System.out.println("Numbers between 1-100 divisible by "+num+" are:");
		for(int i = 0; i<=100; i++){
			if(i >= num&&i%num==0)System.out.print(", ");
			if(i%num == 0)System.out.print(i);
		}
		
		System.out.println("\nThanks for using this program!");
	}
}