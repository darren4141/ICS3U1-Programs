import java.io.*;
public class Question1OutputReverseOrder {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will output your four numbers in reverse order");
		System.out.println("Enter 4 numbers below:");
		int nums[] = new int[4];
		for(int i = 0; i < 4; i++){
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 3; i >= 0; i--){
			System.out.print(nums[i]);
			if(i != 0){
				System.out.print(", ");
			}
		}
		
		System.out.println("\nThanks for using this program!");
		
	}
}