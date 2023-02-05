import java.io.*;
import java.text.DecimalFormat;
public class NumInput1 {
	public static void main(String[] args) throws IOException{
		DecimalFormat twoDigits = new DecimalFormat("00");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int square, number;
		System.out.print("Please type a number: ");
		number = Integer.parseInt(br.readLine());
		square = number*number;
		System.out.println("Your number squared is "+twoDigits.format(square));
	}
}
