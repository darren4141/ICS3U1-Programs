import java.io.*;
public class Question6NumberSort {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1, num2, num3, smallest, middle, largest;
		System.out.println("Welcome! This program will take three numbers and sort them from smallest to largest");
		
		System.out.print("Enter a number: ");
		num1 = Integer.parseInt(br.readLine());		
		System.out.print("Enter another number: ");
		num2 = Integer.parseInt(br.readLine());
		System.out.print("Enter your final number: ");
		num3 = Integer.parseInt(br.readLine());
		
		if(num1<num2){
			smallest = num1;
			middle = num2;
		}else{
			smallest = num2;
			middle = num1;
		}
		
		if(middle>num3){
			largest = middle;
			middle = num3;
			if(smallest > middle){
				int temp = middle;
				middle = smallest;
				smallest = temp;
			}
		}else{
			largest = num3;
		}
		
		System.out.println("The numbers in order from smallest to largest is:");
		System.out.println(smallest+", "+middle+", "+largest);
		System.out.println("Thanks for using this program!");
		
	}
}
