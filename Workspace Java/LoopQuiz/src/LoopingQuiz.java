import java.io.*;
public class LoopingQuiz {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int startingNum, endingNum, runningTotal=0, difference, entireTotal=0;
		double numbersAverage, runningTotalAverage;
		
		System.out.println("Welcome! This program will take a starting and ending number and display a running total and average!");
		System.out.print("Enter a starting number (2-7): ");
		startingNum = Integer.parseInt(br.readLine());
		System.out.print("Enter an ending number (9-16): ");
		endingNum = Integer.parseInt(br.readLine());

		System.out.println("\n.-----------------------.");
		System.out.println("|Number\t|Running total\t|");
		System.out.println("|-------+---------------|");
		
		for(int i = startingNum; i <= endingNum; i++){
			runningTotal+=i;
			entireTotal += runningTotal;
			System.out.println("|"+i+"\t|"+runningTotal+"\t\t|");
		}
		
		System.out.println("'-----------------------'");

		difference = endingNum-startingNum+1;
		numbersAverage = (double)runningTotal/difference;
		runningTotalAverage = (double)entireTotal/difference;
		
		System.out.println("\n"+difference+" numbers were entered");
		System.out.println("The average of the numbers is: "+runningTotal+" / "+difference+" = " +(double)Math.round(numbersAverage*100)/100);
		System.out.println("The average of the running totals is: "+entireTotal+" / "+difference+" = " +(double)Math.round(runningTotalAverage*100)/100);
		System.out.println("\nNUMBERS AVERAGE: "+(double)Math.round(numbersAverage*100)/100);
		System.out.println("TOTALS AVERAGE: "+(double)Math.round(runningTotalAverage*100)/100);
		System.out.println("Thanks for using this program!");
		
	}
}

