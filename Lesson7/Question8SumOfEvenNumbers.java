import java.io.*;
public class Question8SumOfEvenNumbers {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max, total=0;
		System.out.println("Welcome! This program will calculate the sum of all even numbers");
		System.out.println("What number should I stop at? ");
		max = Integer.parseInt(br.readLine());
		for(int i = 2; i<=max; i+=2){
			total+=i;
			System.out.print(total);
			System.out.print((i== max||i==max-1)?"":", ");
		}
		System.out.println("\nThanks for using this program!");
	}
}
