import java.io.*;
import java.text.DecimalFormat;
public class NumInput2 {
	public static void main(String [] args) throws IOException{
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double number, square;
		System.out.print("Please type a number: ");
		number = Double.parseDouble(br.readLine());
		
		square = number*number;
		System.out.println("Your number squared is " +twoDecimals.format(square));
		
		
	}
}
