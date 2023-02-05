import java.io.*;
import java.text.DecimalFormat;
public class ChallengeQuestion {
	
	static ChallengeQuestion CQ = new ChallengeQuestion();
	static DecimalFormat threePlaces = new DecimalFormat(".000");
	
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size, choice, total, divisibleCount, divide;
		double average;
		int[]nums;
		System.out.println("Welcome! This program will input however many numbers you'd like and display the total and average");
		System.out.println("How many values would you like to enter? <1 - 100>");
		size = CQ.readInt(br, 1, 100);
		nums = CQ.readArray(br, size);
		
		
		
		CQ.printMenu();
		choice = CQ.readInt(br, 1, 6);
		
		while(choice != 6){
			switch(choice){
			
			case 1:
				total = CQ.getTotal(nums);
				break;
				
			case 2:
				average = CQ.getAverage(nums);
				break;
				
			case 3:
				nums = CQ.randomizeNums(nums);
				break;
				
			case 4:
				System.out.println("What number would you like to divide by? <between 1 and 25>");
				divide = CQ.readInt(br, 1, 25);
				divisibleCount = CQ.checkDivisibility(divide, nums);

				System.out.println(divisibleCount + " out of " + nums.length + " numbers can be divided by " + divide + " evenly.");				
				break;
				
			case 5:
				CQ.printArray(nums);
				break;
			
			}
			
			CQ.printMenu();
			choice = CQ.readInt(br, 1, 6);
			
		}
		
		System.out.println("Goodbye!");
		
	}
	
	public int[] readArray(BufferedReader br, int size)throws IOException{
		System.out.println("Please enter " + size + " values below! <between 10 and 25>");
		
		int[] array = new int[size];
		
		for(int i = 0; i < size; i++){
			array[i] = CQ.readInt(br, 10, 25);
			System.out.println("Value accepted");
		}
		
		return array;
	}
	
	
	public int readInt(BufferedReader br, int min, int max) throws IOException{
		int number;
		
		while(true){
			try{
				number = Integer.parseInt(br.readLine());
				if(number < min || number > max){
					System.out.println("Please enter a valid number between " + min + " and " + max);
				}else{
					break;
				}
			}catch(NumberFormatException e){
				System.out.println("Please enter a valid number!");
				System.out.println(e.getMessage());
			}
		}
		
		return number;
	}
	
	public int getTotal(int[]numbers){
		int total = 0, count = 0;
		System.out.print("[");
		
		for(int v : numbers) {
			count++;
			total += v;
			System.out.print(v);
			if(count != numbers.length){
				System.out.print(" + ");
			}
		}
		
		System.out.println("] = " + total);
		
		return total;
	}
	
	public double getAverage(int[]numbers){
		
		int total = getTotal(numbers);
		double average = (double)total/numbers.length;
		
		System.out.println(total + " / " + numbers.length + " = " + threePlaces.format(average));
		
		return average;
	}
	
	public int[] randomizeNums(int[]numbers){
		
		System.out.println("Before:");
		CQ.printArray(numbers);
		System.out.println("RANDOMIZING: .......");
		
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = (int)(Math.random()*16) + 10;//GENERATES A RANDOM NUMBER BETWEEN 10 AND 25
		}
		
		CQ.printArray(numbers);
		
		return numbers;
		
	}
	
	public int checkDivisibility(int divide, int[]numbers){
		int count = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i]%divide == 0){
				System.out.println(numbers[i] + " CAN be divided by " + divide + " evenly");
				count++;
			}else{
				System.out.println(numbers[i] + " CANNOT be divided by " + divide + " evenly");
			}
		}
		
		return count;
	}
	
	public void printArray(int[]array){
		int count = 0;
		System.out.print("[");
		
		for(int v : array) {
			count++;
			System.out.print(v);
			if(count != array.length){
				System.out.print(", ");
			}
		}
		
		System.out.println("]");
	}
	
	public void printMenu(){
		System.out.println("-------------------------------------------------------");
		System.out.println("What would you like to do?\n1. Total\n2. Average\n3. Randomize numbers\n4. Check divisibility\n5. View numbers\n6. Exit");
		System.out.println("-------------------------------------------------------");
	}
	
}
