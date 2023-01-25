import java.io.*;
public class FormativeQuiz1 {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//declare
		int startingValue, endingValue, runningTotal = 0;
		
		//welcome
		System.out.println("Welcome! This program will take a starting and ending value and show you a chart for the running (accumulative) total.");
		
		//input
		System.out.print("Enter a starting value between 1 and 7: ");
		startingValue = Integer.parseInt(br.readLine());
		System.out.print("Enter a ending value between 10 and 15: ");
		endingValue = Integer.parseInt(br.readLine());
		
		//chart formatting
		System.out.println(".-------.-------.");
		System.out.println("|NUMBER\t|TOTAL\t|");
		System.out.println("|-------+-------|");
		
		//iterate & calculate
		for(int i = startingValue; i<=endingValue; i++){
			runningTotal+=i;
			System.out.println("|"+i+"\t|"+runningTotal+"\t|");
		}
		
		//chart formatting
		System.out.println("'-------'-------'");

		//goodbye
		System.out.println("\nThanks for using this program!");
		
	}//end of main method
}//end of class