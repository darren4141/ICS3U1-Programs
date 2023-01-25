import java.io.*;
public class Question2TotalAndAverageCalculator {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double nums[] = new double[4];
		System.out.println("Welcome! This program will calculate the total and average of four numbers");
		System.out.println("Enter your four numbers below:");
		
		for(int i = 0; i < 4; i++){
			nums[i] = Double.parseDouble(br.readLine());
		}
		double total = 0;
		double average;
		
		for(double v : nums){
			total+=v;
		}
		
		average = total/4;
		
		System.out.println("Your total is: " + (double)Math.round(total*100)/100);
		System.out.println("Your average is: "+ (double)Math.round(average*100)/100);
		System.out.println("Thanks for using this program!");
	}

}
