import java.io.*;
public class Question4 {

	public static void main(String[]args) throws IOException{
		Question4 Q4 = new Question4();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SIZE = 10;
		int [] nums;
		int sum = 0;
		
		System.out.println("Welcome! This program will input "+SIZE+" numbers and tell you the sum");
		
		nums = Q4.inpArray(br, SIZE);		
		System.out.print("The numbers entered were: ");

		sum = Q4.sumArray(nums);
		
		System.out.println("\nThe sum of these numbers is "+sum);
		
	}
	
	public int[] inpArray(BufferedReader br, int size) throws IOException{
		int [] array = new int[size];
		
		for(int i = 0; i < size; i++){
			
			while(true){
				try{
					array[i] = Integer.parseInt(br.readLine());
					break;
				}catch(NumberFormatException e){
					System.out.println("Please enter a number!");
					System.out.println(e.getMessage());
				}
			}
		}
		
		return array;
	}
	
	public int sumArray(int[]array){
		System.out.print("The numbers entered were: ");
		int total = 0;
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
			total += array[i];
		}
		
		return total;
	}
	
}
