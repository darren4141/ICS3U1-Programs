import java.io.*;
public class NumInput22 {
	public static void main(String[] args) throws IOException{
		double number, square;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter a number: ");
		number = Double.parseDouble(br.readLine());
		square = number*number;
		System.out.println(number + " squared is: " + (double)Math.round(square*100)/100);
		
	}

}
