import java.io.*;

public class NumInput1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String numString;
		int square, number;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter a number: ");
		numString = br.readLine();
		number = Integer.parseInt(numString);
		square = number*number;
		System.out.println(number + " squared is: " + square);
		
	}

}
