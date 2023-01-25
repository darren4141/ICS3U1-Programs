import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class WarmUpNestedMultiplyDifferentFormatting {
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will show you a multiplication table of values");
		int outerMin, outerMax, innerMin, innerMax;
		System.out.print("Enter the starting value for the first number: ");
		outerMin = Integer.parseInt(br.readLine());
		System.out.print("Enter the ending value for the first number: ");
		outerMax = Integer.parseInt(br.readLine());
		System.out.print("Enter the starting value for the second number: ");
		innerMin = Integer.parseInt(br.readLine());
		System.out.print("Enter the ending value for the second number: ");
		innerMax = Integer.parseInt(br.readLine());
		

		System.out.print(".-------.");
		for(int i = outerMin-1; i <= outerMax-2; i++)System.out.print("-------.");
		System.out.println("-------.");
		System.out.print("|\t");
		for(int i = outerMin; i <= outerMax; i++)System.out.print("|"+i+"\t");
		
		
		System.out.print("|");
		
		for(int j = innerMin; j<= innerMax; j++){
			System.out.println();
			System.out.print("|-------+");
			for(int i = outerMin-1; i <= outerMax-2; i++)System.out.print("-------+");
			System.out.print("-------|");
			System.out.print("\n|"+j+"\t|");
			for(int i = outerMin; i<=outerMax; i++){
				System.out.print((i*j)+"\t|");
			}
		}
		System.out.println();
		for(int i = outerMin-1; i <= outerMax; i++)System.out.print("'-------");
		System.out.print("'");

	}
}
