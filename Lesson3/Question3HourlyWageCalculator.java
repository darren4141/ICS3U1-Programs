import java.io.*;
public class Question3HourlyWageCalculator {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will calculate how much money you will earn");
		String name;
		double hourlyWage, hours;
		System.out.print("What is your name: ");
		name = br.readLine();
		System.out.print("How many hours have you worked: ");
		hours = Double.parseDouble(br.readLine());
		System.out.print("What is your hourly wage: ");
		hourlyWage = Double.parseDouble(br.readLine());
		
		System.out.println(name+", you worked "+hours+" hours at $"+hourlyWage+" per hour, meaning your total pay is $"+(double)Math.round(hourlyWage*hours*100)/100);
		System.out.println("Thank you for using this program!");
		
	}
}

