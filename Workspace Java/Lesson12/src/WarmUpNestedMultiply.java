import java.io.*;
public class WarmUpNestedMultiply {
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will show you a multiplication table of values");
		int outerMin, outerMax, innerMin, innerMax;
		System.out.print("Enter the starting value for the first number");
		outerMin = Integer.parseInt(br.readLine());
		System.out.print("Enter the ending value for the first number");
		outerMax = Integer.parseInt(br.readLine());
		System.out.print("Enter the starting value for the second number");
		innerMin = Integer.parseInt(br.readLine());
		System.out.print("Enter the ending value for the second number");
		innerMax = Integer.parseInt(br.readLine());
		
		System.out.println(".-----------------------.");
		System.out.println("|#1\t|#2\t|PRODUCT|");
		System.out.println("|-------+-------+-------|");
		for(int i = outerMin; i<= outerMax; i++){
			for(int j = innerMin; j<=innerMax; j++){
				System.out.println("|"+i+"\t|"+j+"\t|"+(i*j)+"\t|");
			}
		}
		System.out.println("'-----------------------'");

		System.out.println("Thanks for using this program!");
	}
}
