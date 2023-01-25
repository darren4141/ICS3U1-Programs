import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Question5 {
	
	public static void main(String[]args) throws IOException{
		Question5 FD = new Question5();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SIZE = 15;
		double[]nums = new double[SIZE];
		int choice, aboveAverage, belowAverage, equalAverage;
		double largest, smallest, average;
		String frequent;
		
		System.out.println("Welcome! This program will input " + SIZE + " double values and prompt you for various operations <mean, mode, highest, lowest, etc>");
		
		nums = FD.readArray(SIZE, nums, br);
		
		System.out.println("------------------------------------------------------------");
		System.out.println("What would you like to do?\n1. Largest number\n2. Smallest number\n3. Average\n4. Amount above average\n5. Amount below average\n6. Amount equal to average\n7. Most frequently occuring number\n8. Re-enter numbers\n9. View numbers\n10. Exit");
		System.out.println("------------------------------------------------------------");
		choice = FD.readInt(br);
		
		while(choice != 10){
			switch(choice){
				
				case 1:
					largest = FD.getLargest(nums);
					System.out.println("The largest number in the array is: " + largest);
					break;

				case 2:
					smallest = FD.getSmallest(nums);
					System.out.println("The smallest number in the array is: " + smallest);
					break;

				case 3:
					average = Math.round(FD.getAverage(nums)*1000)/1000;
					System.out.println("The average of the numbers is: " + average);
					break;

				case 4:
					aboveAverage = FD.getAboveAverage(nums);
					average = Math.round(FD.getAverage(nums)*1000)/1000;
					System.out.println(aboveAverage + " numbers are above the average of " + average);
					break;

				case 5:
					belowAverage = FD.getBelowAverage(nums);
					average = Math.round(FD.getAverage(nums)*1000)/1000;
					System.out.println(belowAverage + " numbers are below the average of " + average);
					break;

				case 6:
					equalAverage = FD.getEqualAverage(nums);
					average = Math.round(FD.getAverage(nums)*1000)/1000;
					System.out.println(equalAverage + " numbers equal the average of " + average);
					break;
					
				case 7:
					frequent = FD.getMostFrequent(nums);
					System.out.println(frequent);
					break;
					
				case 8:
					nums = FD.readArray(SIZE, nums, br);
					break;
				
				case 9:
					FD.printArray(nums);
					break;
					
				default:
					System.out.println("Please enter a valid option!");
			}//end of switch case
			
			System.out.println("------------------------------------------------------------");
			System.out.println("What would you like to do?\n1. Largest number\n2. Smallest number\n3. Average\n4. Amount above average\n5. Amount below average\n6. Amount equal to average\n7. Most frequently occuring number\n8. Re-enter numbers\n9. View numbers\n10. Exit");
			System.out.println("------------------------------------------------------------");
			choice = FD.readInt(br);
			
		}//end of while loop

		
		System.out.println("Goodbye!");
		
	}//end of main method
	
	public double[] readArray(int length, double[]nums, BufferedReader br) throws IOException{//method to input array, calls readDouble method
		Question5 FD = new Question5();
		
		System.out.println("Enter " + length + " double values: ");
		
		for(int i = 0; i < nums.length; i++) nums[i] = FD.readDouble(br);
		
		return nums;
	}
	
	public double readDouble(BufferedReader br) throws IOException{//method to input double values with try catch
		double input;
		
		while(true){
			try{
				input = Double.parseDouble(br.readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Please enter a valid number!");
				System.out.println(e.getMessage());
			}
		}
		
		
		return input;	
		
	}
	
	public int readInt(BufferedReader br) throws IOException{//method to input menu option
		int input;
		
		while(true){
			try{
				input = Integer.parseInt(br.readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Please enter a valid number!");
				System.out.println(e.getMessage());
				System.out.println("------------------------------------------------------------");
				System.out.println("What would you like to do?\n1. Largest number\n2. Smallest number\n3. Average\n4. Amount above average\n5. Amount below average\n6. Amount equal to average\n7. Most frequently occuring number\n8. Re-enter numbers\n9. View numbers\n10. Exit");
				System.out.println("------------------------------------------------------------");
			}
		}
		
		
		return input;
	}
	
	public double getLargest(double[]elems){//method to find largest number in array
		double largest = 0;
		
		for(int i = 0; i < elems.length; i++){
			if(elems[i] > largest) largest = elems[i]; 
		}
		
		return largest;
	}
	
	public double getSmallest(double[]elems){//method to find smallest number in array
		double smallest = elems[0];
		
		for(int i = 1; i < elems.length; i++){
			if(elems[i] < smallest) smallest = elems[i]; 
		}
		
		return smallest;
	}	
	
	public double getAverage(double[]elems){//method to find average of an array
		double total = 0;
		for(double v : elems)total+=v;
		return total/elems.length;
	}
	
	public int getAboveAverage(double[]elems){//method to find how many numbers are above average, calls getAverage method
		double average = getAverage(elems);
		int count = 0;
		
		for(double v : elems){
			if(v > average) count++;
		}
		
		return count;
	}
	
	public int getBelowAverage(double[]elems){//method to find how many numbers are below average, calls getAverage method
		double average = getAverage(elems);
		int count = 0;
		
		for(double v : elems){
			if(v < average) count++;
		}
		
		return count;
	}
	
	public int getEqualAverage(double[]elems){//method to find how many numbers are equal to average, calls getAverage method
		double average = getAverage(elems);
		int count = 0;
		
		for(double v : elems){
			if(v == average) count++;
		}
		
		return count;
	}
	
	public String getMostFrequent(double[]elems){//method to get most frequent mode, using nested for loops
		int highestCount = 0;
		double highestElement = 0;
		
		for(int i = 0; i < elems.length; i++){
			int count = 0;
			for(int j = 0; j < elems.length; j++){
				if(elems[j] == elems[i]) {
					count++;
				}
			}//end of inner loop
			
			if(count > highestCount){
				highestCount = count;
				highestElement = elems[i];
			}
			
		}//end of outer loop
				
		return "The most frequently occuring number was: " + highestElement + " which appeared " +highestCount + " times.";
		
	}
	
	public void printArray(double[]elems){//method to print array
		
		System.out.print("[");
		for(int i = 0; i < elems.length-1; i++) System.out.print(elems[i] + ", ");
		System.out.print(elems[elems.length-1] + "]");
		
		System.out.println();
	}
	
}//end of class
