import java.io.*;
public class TryCatchEx3 {

	public static void main (String[]args){
		
		TryCatchEx3 tc = new TryCatchEx3();
		
		tc.inputMethod();
		
	}
	
	private void inputMethod(){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Input an integer");
			String str = br.readLine();
			int myInt = Integer.parseInt(str);
			System.out.println("The integer entered was " + myInt);
			
		}catch(IOException e){
			System.out.println("****" + e.getMessage() + "****");
		}catch(NumberFormatException e){
			System.out.println("====" + e + "====");
		}
	}
	
}
