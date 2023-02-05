import java.io.*;
public class CountedLoop3Timestables {
	public static void main (String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will help you review your timestables");
		System.out.print("Enter a number: ");
		int num = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <=10; i++){
			if(i<10)System.out.print(" ");
			System.out.println(num+" x "+i+" = "+(num*i));
		}
		
		System.out.println("Thanks for using this program!");
		
	}
}