import java.io.*;
public class Repitition1 {
	public static void main(String[] args) throws IOException{
		//declare variables
		final int NUMMARKS=10;
		int mark;
		int sum = 0;
		double average;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! Please enter 10 marks below, one on each line");
		//add up total
		for(byte count = 1; count<=NUMMARKS; count++){
			mark = Integer.parseInt(br.readLine());
					sum += mark;
		}
		//calculate average
		average = (double)sum/NUMMARKS;
		//output
		System.out.println("\nThe average is "+(double)Math.round(average*100)/100);
		
	}
}
