import java.io.*;
public class FifteenDoubleCalculations {
	
	public static void main(String[]args) throws IOException{
		FifteenDoubleCalculations FD = new FifteenDoubleCalculations();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SIZE = 15;
		double[]nums = new double[SIZE];
		int choice, aboveAverage, belowAverage, equalAverage;
		double largest, smallest, average;
		String frequent;
		
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
					
				default:
					System.out.println("Please enter a valid option!");
			}
			
			System.out.println("------------------------------------------------------------");
			System.out.println("What would you like to do?\n1. Largest number\n2. Smallest number\n3. Average\n4. Amount above average\n5. Amount below average\n6. Amount equal to average\n7. Most frequently occuring number\n8. Re-enter numbers\n9. Exit");
			System.out.println("------------------------------------------------------------");
			choice = FD.readInt(br);
			
			if(choice == 9){
				System.out.println("Goodbye!");
			}
			
		}

		
	}
	
	public double[] readArray(int length, double[]nums, BufferedReader br) throws IOException{
		FifteenDoubleCalculations FD = new FifteenDoubleCalculations();
		
		System.out.println("Enter " + length + " double values: ");
		
		for(int i = 0; i < nums.length; i++) nums[i] = FD.readDouble(br);
		
		return nums;
	}
	
	public double readDouble(BufferedReader br) throws IOException{
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
		
		
		return input;	}
	
	public int readInt(BufferedReader br) throws IOException{
		int input;
		
		while(true){
			try{
				input = Integer.parseInt(br.readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Please enter a valid number!");
				System.out.println(e.getMessage());
				System.out.println("------------------------------------------------------------");
				System.out.println("What would you like to do?\n1. Largest number\n2. Smallest number\n3. Average\n4. Amount above average\n5. Amount below average\n6. Amount equal to average\n7. Most frequently occuring number\n8. Re-enter numbers\n9. Exit");
				System.out.println("------------------------------------------------------------");
			}
		}
		
		
		return input;
	}
	
	public double getLargest(double[]elems){
		double largest = 0;
		
		for(int i = 0; i < elems.length; i++){
			if(elems[i] > largest) largest = elems[i]; 
		}
		
		return largest;
	}
	
	public double getSmallest(double[]elems){
		double smallest = elems[0];
		
		for(int i = 1; i < elems.length; i++){
			if(elems[i] < smallest) smallest = elems[i]; 
		}
		
		return smallest;
	}	
	
	public double getAverage(double[]elems){
		double total = 0;
		for(double v : elems)total+=v;
		return total/elems.length;
	}
	
	public int getAboveAverage(double[]elems){
		double average = getAverage(elems);
		int count = 0;
		
		for(double v : elems){
			if(v > average) count++;
		}
		
		return count;
	}
	
	public int getBelowAverage(double[]elems){
		double average = getAverage(elems);
		int count = 0;
		
		for(double v : elems){
			if(v < average) count++;
		}
		
		return count;
	}
	
	public int getEqualAverage(double[]elems){
		double average = getAverage(elems);
		int count = 0;
		
		for(double v : elems){
			if(v == average) count++;
		}
		
		return count;
	}
	
	public String getMostFrequent(double[]elems){
		int highestCount = 0;
		double highestElement = 0;
		
		for(int i = 0; i < elems.length; i++){
			int count = 0;
			for(int j = 0; j < elems.length; j++){
				if(elems[j] == elems[i]) {
					count++;
				}
			}
			
			if(count > highestCount){
				highestCount = count;
				highestElement = elems[i];
			}
			
		}
				
		return "The most frequently occuring number was: " + highestElement + " which appeared " +highestCount + " times.";
		
	}
	
	public void printArray(double[]elems){
		for(double v : elems){
			System.out.print(v + ", ");
		}
		System.out.println();
	}
}
