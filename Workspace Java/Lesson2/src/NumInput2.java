import java.io.*;
public class NumInput2 {
	public static void main(String[] args) throws IOException{
		String numString;
		double number, square;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter a number: ");
		numString = br.readLine();
		number = Double.parseDouble(numString);
		square = number*number;
		System.out.println(number + " squared is: " + (double)Math.round(square*100)/100);
		
	}

}
