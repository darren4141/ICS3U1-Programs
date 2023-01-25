import java.io.*;
public class Question4TemperatureConverter {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome! This program will convert Celsius to Farenheit. Enter \"stop\" to stop the program");
		String inp="";
		double cels, farenheit;
		System.out.print("Enter a temperature in Celsius: ");
		inp = br.readLine();
		
		while(!inp.equals("stop")&&!inp.equals("STOP")&&!inp.equals("Stop")){
			cels = Double.parseDouble(inp);
			farenheit = (cels * 1.8) + 32;
			System.out.println(cels+" degrees celsius is equal to "+farenheit+" degrees farenheit");
			System.out.print("Enter a temperature in Celsius: ");
			inp = br.readLine();
		}
		System.out.println("Thanks for using this program!");
		
	}
}
