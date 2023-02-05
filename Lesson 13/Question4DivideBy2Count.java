import java.io.*;
public class Question4DivideBy2Count {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		System.out.println("Welcome! This program will tell you how many times you can divide a number by 2");
		System.out.print("Enter a number, <or '0' to end>: ");
		num = Integer.parseInt(br.readLine());
		while(num!=0){
			int originalNum = num;
			int times = 0;
			boolean divisible = true;
			if(num%2!=0){
				divisible=false;
			}
			while(divisible){
				System.out.print(num+", ");
				num/=2;
				times++;
				if(num%2!=0||num==0){
					divisible=false;
				}
			}
			
			System.out.print("\n"+originalNum+" can be divided by two ");
			System.out.print((times==1)?times+" time":times+" times");
			
			System.out.print("\n\nEnter a number, <or '0' to end>: ");
			num = Integer.parseInt(br.readLine());
		}
		
		System.out.println("Thanks for using this program!");
	}
}
