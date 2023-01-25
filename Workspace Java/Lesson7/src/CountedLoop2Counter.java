import java.io.*;
public class CountedLoop2Counter {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will count to your desired number");
		System.out.print("Enter a number for me to count to: ");
		int times = Integer.parseInt(br.readLine());
		System.out.println("COUNTING FROM 1 TO "+times+"...");
		
		for(int i = 1; i <=times; i++){
			System.out.print(i);
			if(i!=times)System.out.print(", ");
		}
		
		System.out.println("\nThanks for using this program!");
	}
}