import java.io.*;
public class addFive {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main (String[]args) throws IOException{
		addFive aF = new addFive();
		int number, result;
		System.out.println("Welcome! This program will add 5 to a number you input!");
		System.out.print("Enter a number: ");
		number = aF.readInt();
		result = aF.incrementFive(number);
		System.out.println("Your number plus 5 is: "+result);
	}
	
	public int readInt() throws IOException{
		return Integer.parseInt(br.readLine());
	}
	
	public int incrementFive(int num){
		return num + 5;
	}
	
}
