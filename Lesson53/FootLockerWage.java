import java.io.*;
import java.text.DecimalFormat;
public class FootLockerWage {

	static final String[]DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	static final int OVERTIME = 40;
	static DecimalFormat moneyFormat = new DecimalFormat(".00");
	
	public static void main (String[]args){
		FootLockerWage FL = new FootLockerWage();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[]names = new String[3];
		double[]wage = new double[3];
		double [][]hours = new double[3][14];
		
		System.out.println("Welcome! This program will calculate the paycheck of Foot Locker Employees");
		
		for(int i = 0; i < 3; i++){
			System.out.println("---------EMPLOYEE " + (i+1) +"---------");
			
			System.out.println("Enter your name:");
			names[i] = FL.readString(br);
			
			System.out.println("Enter your hourly wage:");
			wage[i] = FL.readDouble(br);
			
			
			System.out.println("WEEK 1");
			for(int j = 0; j < 7; j++){
				System.out.println("How many hours did you work on " + DAYS[j] +"?");
				hours[i][j] = FL.readDouble(br);
			}
			
			System.out.println("WEEK 2");
			for(int j = 7; j < 14; j++){
				System.out.println("How many hours did you work on " + DAYS[j-7] +"?");
				hours[i][j] = FL.readDouble(br);
			}
		}
		
		for(int i = 0; i < 3; i++){
			FL.printChart(names[i], wage[i], hours[i]);
		}
		
		System.out.println("Thanks for using this program!");
		
	}
	
	public String readString(BufferedReader br){
		String input;
		
		while(true){
			try{
				input = br.readLine();
				break;
			}catch(Exception e){
				System.out.println("Please enter a valid input!");
				System.out.println(e.getMessage());
			}
		}
		
		return input;
	}
	
	public double readDouble(BufferedReader br){
		double input;
		
		while(true){
			try{
				input = Double.parseDouble(br.readLine());
				break;
			}catch(Exception e){
				System.out.println("Please enter a valid input!");
				System.out.println(e.getMessage());
			}
		}
		
		return input;
	}
	
	public double calcPay(double[]hours, double wage, int min, int max){
		double totalHrs = 0;
		double normalWageHrs;
		double overtimeHrs = 0;
		double normalWagePay;
		double overtimePay;
		
		for(int i = min; i < max; i++){
			totalHrs+= hours[i];
		}
		
		if(totalHrs > OVERTIME){
			overtimeHrs = totalHrs-OVERTIME;
			normalWageHrs = OVERTIME;
		}else{
			normalWageHrs = totalHrs;
		}
		
		normalWagePay = normalWageHrs * wage;
		overtimePay = (overtimeHrs * wage)*1.5;
		System.out.println("You worked " + totalHrs + " hours, " + overtimeHrs + " of which being overtime hours.");
		System.out.println("You made $" + moneyFormat.format(normalWagePay) + " of normal wage and $" + moneyFormat.format(overtimePay) + " of overtime pay");
		System.out.println("In total you made: $"  + moneyFormat.format(normalWagePay + overtimePay));
		
		return normalWagePay + overtimePay;
		
	}
	
	public void printChart(String name, double wage, double[]hours){
		double weekOne, weekTwo;
		
		System.out.println(".-------------------------------------------------------------------------------WEEK 1--------------------------------------------------------------------------------------------------------.");
        System.out.printf("|%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "\t"+name, "\t"+DAYS[0], "\t"+DAYS[1], "\t"+DAYS[2], "\t"+DAYS[3], "\t"+DAYS[4], "\t"+DAYS[5], "\t"+DAYS[6]);
		System.out.println("|---------------------------+------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+----------------------|");
        System.out.printf("|%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "\tHourly Wage: $"+wage, "\t"+hours[0], "\t"+hours[1], "\t"+hours[2], "\t"+hours[3], "\t"+hours[4], "\t"+hours[5], "\t"+hours[6]);
		System.out.println("'---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'");
		weekOne = calcPay(hours, wage, 0, 6);
		
		System.out.println(".-------------------------------------------------------------------------------WEEK 2--------------------------------------------------------------------------------------------------------.");
        System.out.printf("|%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "\t"+name, "\t"+DAYS[0], "\t"+DAYS[1], "\t"+DAYS[2], "\t"+DAYS[3], "\t"+DAYS[4], "\t"+DAYS[5], "\t"+DAYS[6]);
		System.out.println("|---------------------------+------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------+----------------------|");
        System.out.printf("|%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "\tHourly Wage: $"+wage, "\t"+hours[7], "\t"+hours[8], "\t"+hours[9], "\t"+hours[10], "\t"+hours[11], "\t"+hours[12], "\t"+hours[13]);
		System.out.println("'---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'");
		weekTwo = calcPay(hours, wage, 7, 13);
		
		System.out.println("\nOver two weeks, " + name + " made $" + moneyFormat.format(weekOne + weekTwo)+"\n\n");
		
	}
}
