import java.io.*;
public class Question2MarkCalculator {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//declare
		int numMarks, mark, total = 0;
		double average;
		
		//prompt
		System.out.println("Welcome! This program will calculate your average!");
		System.out.print("Enter your number of marks: ");
		numMarks = Integer.parseInt(br.readLine());
		System.out.println("Enter your " +numMarks+ " marks below, one per line");
		
		//total
		for(int i = 0; i<numMarks; i++){
			mark = Integer.parseInt(br.readLine());
			total+=mark;
		}
		
		//calculate
		average = (double)total/numMarks;
		
		//output
		System.out.println("Your total is "+total);		
		System.out.println("Your average is "+(double)Math.round(average*100)/100);
		
	}
}
