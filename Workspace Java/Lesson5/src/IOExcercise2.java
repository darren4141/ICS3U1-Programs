import java.io.*;
public class IOExcercise2 {
	public static void main(String args[]) throws IOException{
		double num1, num2, num3, num4, sum, average;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter a number: ");
		num1 = Double.parseDouble(br.readLine());
		System.out.print("Please enter a number again: ");
		num2 = Double.parseDouble(br.readLine());
		System.out.print("Please enter another number: ");
		num3 = Double.parseDouble(br.readLine());
		System.out.print("Please enter a final number: ");
		num4 = Double.parseDouble(br.readLine());
		sum = num1 + num2 + num3 + num4;
		average = sum/4;
		System.out.println("The sum of your numberes is "+sum+"\nThe average is "+average);
	}
}
