import java.io.*;
public class InClass3 {
	
	final static int NUMBEROFENTRIES = 2;
	static double lowest = 101;
	static int times = 0;
	
	public static void main (String[]args) throws IOException{//main method
		InClass3 iC = new InClass3();
		int numOne, numTwo;
		double average;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Welcome! This program will find the average of " + NUMBEROFENTRIES + " numbers!");
		
		numOne = iC.getInt("Enter the first number, between 1 and 100 inclusive", br);
		numTwo = iC.getInt("Enter the second number, between 1 and 100 inclusive", br);
				
		average = iC.getAverage(numOne, numTwo);
		
		System.out.println("\n------------------------------------------------------------");
		System.out.println("The average of " + numOne + " and " + numTwo + " is: " + average);
		
		iC.evenOrOdd(average);
		
		iC.findLowest(average);
		times = iC.count(times);
		
		System.out.println("------------------------------------------------------------");
		iC.endPrompt(br);
		
	}
	
	public int getInt(String message, BufferedReader br) throws IOException{//data entry - functional
		int input;
		
		while(true){
			System.out.println("\n"+message);
			
			try{
				input = Integer.parseInt(br.readLine());
				
				if(input >= 1 && input <= 100){
					System.out.println("Input added");
					break;
				}else{
					System.out.println("Enter a valid number between 1 and 100 inclusive!");
					System.out.println("For out of bounds input \""+input + "\"");
				}
				
			}catch(NumberFormatException e){
				System.out.println("Enter a valid number!");
				System.out.println(e.getMessage());
			}

		}
		
		return input;
		
	}
	
	public double getAverage(int first, int second){//calculate average - functional
		
		double average = (double)(first+second)/NUMBEROFENTRIES;
		return average;
		
	}
	
	public void evenOrOdd(double average){
		
		int rounded = (int) Math.round(average);		
		boolean wasRounded = (rounded == average);
		
		if(rounded % 2== 0){
			System.out.print((wasRounded)? "The " : "The rounded ");
			System.out.println("number "+rounded+" is even");
			
		}else if(rounded %2 == 1){
			System.out.print((wasRounded)? "The " : "The rounded ");
			System.out.println("number "+rounded+" is odd");
			
		}
		
	}
	
	public void endPrompt(BufferedReader br) throws IOException{//repeat menu - procedural
		int choice;
		
		while(true){
			System.out.println("\nWhat would you like to do?\n1. Repeat program\n2. Exit");

			try{
				choice = Integer.parseInt(br.readLine());
				
				if(choice == 1 || choice == 2){
					break;
					
				}else{
					System.out.println("Enter a valid option <1 or 2>");
					System.out.println("For out of bounds input \""+choice + "\"");
				
				}
				
			}catch(NumberFormatException e){
				System.out.println("Enter a valid option <1 or 2>");
				System.out.println(e.getMessage());
				
			}

		}
		
		if(choice == 1){
			System.out.println("\n============================================================");
			main(null);
			
		}else if (choice == 2){
			System.out.println("\n\tFINAL STATISTICS:");
			System.out.println("==============================================");
			System.out.println("The lowest average calculated was: " + lowest);
			System.out.println("In total, " + times + " numbers were entered");
			
			System.out.println("Thanks for using this program! Come again!");
			
		}
		
	}
	
	public void findLowest(double compareTo){//find lowest average - procedural
		if(compareTo < lowest){
			lowest = compareTo;
			
		}
	}
	
	public int count(int counter){//count the number of entries - functional
		return counter += NUMBEROFENTRIES;
	}
	
}//end of class



