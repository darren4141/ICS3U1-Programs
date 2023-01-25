import java.io.*;
public class Question7RestaurantCombos {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int count=0, choice;
		
		System.out.println("Welcome! which combo would you like? <or '0' to end>");
		System.out.println("1. Combo 1\n2. Combo 2\n3. Combo 3\n4. Combo 4");
		choice = Integer.parseInt(br.readLine());
		
		while(choice!=0){
			switch(choice){
				case 1: case 2: case 3: case 4:
					count++;
					break;
				default:
					System.out.println("Enter a valid option");
			}
			
			System.out.println("\nWhich combo would you like? <or '0' to end>");
			System.out.println("1. Combo 1\n2. Combo 2\n3. Combo 3\n4. Combo 4");
			choice = Integer.parseInt(br.readLine());
		}
		
		System.out.println(count+" combos were ordered.");
		System.out.println("Thanks for using this program!");
		
	}
}