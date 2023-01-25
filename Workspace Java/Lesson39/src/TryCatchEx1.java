import java.io.*;

public class TryCatchEx1 {
	public static void main (String[]args) throws IOException{
		
		double number;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please type a number");
		
		while(true){
			try{
				number = Double.parseDouble(br.readLine());
				break;
			}catch(NumberFormatException e){
				System.out.println("Non-numeric input, try again");
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("Your number squared is: " + number*number);
		
	}
}
