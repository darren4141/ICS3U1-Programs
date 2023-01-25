import java.io.*;

public class TryCatchWithLimits {

	public static void main(String[]args) throws IOException{
		
		String numString;
		double number;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter a number");
		
		while(true){
			try{
				numString = br.readLine();
				number = Double.parseDouble(numString);
				
				if(number >= 0 && number <= 90) break;
				else System.out.println("Value must >= 0 and <= 90, try again");
				
			}catch(NumberFormatException e){
				System.out.println("Non-numeric input, try again");
				System.out.println(e.getMessage());
			}
		}
		
		System.out.print("Your number squared is: ");
		System.out.println((double)Math.round(number*number*10000)/10000);
		
	}
	
}
