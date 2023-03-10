import java.io.*;
import java.text.DecimalFormat;
public class whileInputAverage {
	
	static final String EXIT = "@EXIT";

	public static void main(String[]args)throws IOException{
		whileInputAverage WIA = new whileInputAverage();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num, sum = 0, count = 1;
		String average;
		
		System.out.println("Welcome! This program will input as many numbers as you'd like and calculate the average!");
		
		num = WIA.getInt("Enter a number between 10 and 50 inclusive <or enter \"" +EXIT+"\" to exit>", count, br);
		
		while(num != -1){
			System.out.println("Number added");
			count++;
			sum+= num;
			num = WIA.getInt("Enter a number between 10 and 50 inclusive <or enter " +EXIT+" to exit>", count, br);
			if(num==-1){
				count--;
			}
		}
		
		average = WIA.getAverage(sum, count);
		
		WIA.output(sum, count, average);
		
		WIA.endProgram(br);
				
	}
	
	public int getInt(String message, int count, BufferedReader br) throws IOException{
		String strInput;
		int input;
		
		while(true){
			System.out.print("\n\t"+count);
			if(count%10==1) System.out.print("st");
			else if(count%10 == 2) System.out.print("nd");
			else if(count%10 == 3)System.out.print("rd");
			else System.out.print("th");
			
			System.out.println(" GUESS");
			System.out.println("==============================");
			System.out.println(message);
			strInput = br.readLine();
			
			if(strInput.equals(EXIT)){
				return -1;
			}
			
			try{
				input = Integer.parseInt(strInput);
				
				if(input >= 10 && input <= 50){
					return input;
				}else{
					System.out.println("Please enter a valid number between 10 and 50 inclusive");
					System.out.println("For out of range input \"" + input + "\"");
				}
				
			}catch(NumberFormatException e){
				System.out.println("Please enter a number between 10 and 50 inclusive");
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	public String getAverage(int sum, int count){
		DecimalFormat twoPlaces = new DecimalFormat(".00");
		
		double average = (double)sum / count;
		
		return twoPlaces.format(average);
	}
	
	public void output(int sum, int count, String average){
		System.out.println("\n\tRESULTS");
		System.out.println("==============================");
		
		if(sum==0){
			System.out.println("You didn't enter any numbers! Use the program properly next time.");
		}else{
			System.out.println("The sum of all numbers entered was: "+sum + ", in total " +count+ " numbers were entered");
			System.out.println("The average is: "+average);
		}
	}
	
	public void endProgram(BufferedReader br) throws IOException{
		int choice;
		
		while(true){
			
			System.out.println("\nWhat would you like to do?\n1. repeat program\n2. exit");
			
			try{
				choice = Integer.parseInt(br.readLine());
				
				if(choice == 1 || choice == 2){
					break;
				}else{
					System.out.println("Please enter a valid option <1 or 2>");
					System.out.println("For invalid input \"" + choice + "\"");
				}
				
			}catch(NumberFormatException e){
				System.out.println("Please enter a number between 10 and 50 inclusive");
				System.out.println(e.getMessage());
			}			
		}
		
		if(choice == 1){
			main(null);
		}if(choice == 2){
			System.out.println("Thanks for using my program");
		}

		
	}
	
}
