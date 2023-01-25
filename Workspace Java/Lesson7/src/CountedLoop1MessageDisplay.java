import java.io.*;
public class CountedLoop1MessageDisplay {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! this program will display a message");
		System.out.print("How many times would you like it to display: ");
		int times = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < times; i++){
			System.out.println("This is the message");
		}
		
		
		System.out.println("Thank you for using this program");
	}
	
}