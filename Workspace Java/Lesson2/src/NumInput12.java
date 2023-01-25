import java.io.*;
public class NumInput12 {
	public static void main(String[] args) throws IOException {
		int square, number;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter a number: ");
		number = Integer.parseInt(br.readLine());
		square = number*number;
		System.out.println(number + " squared is: " + square);	
	}
}