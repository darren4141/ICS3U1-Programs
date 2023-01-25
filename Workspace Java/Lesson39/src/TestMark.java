import java.io.*;

public class TestMark {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main (String[]args) throws IOException {
		
		TestMark TM = new TestMark();
		
		System.out.println("Welcome! This program will enter your name and a mark");
		String name;
		double mark, total, percent;
		
		name = TM.getString("What is your name?");
		
		total = TM.getDouble("How many marks was your test out of?");
		mark = TM.getDouble("What did you score out of " + total + "?");
		
		percent = TM.calcAvg(total, mark);
		
		System.out.println(TM.finalMessage(name, percent));
		
	}
	
	public String getString(String message) throws IOException {
		String input;
		
		while(true){
			
			try{
				System.out.println(message);
				input = br.readLine();
				break;	
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
		return input;
		
	}
	
	public double getDouble(String message) throws IOException {
		double input;
		
		while(true){
			
			try{
				System.out.println(message);
				input = Double.parseDouble(br.readLine());
				break;	
			}catch(IOException e){
				System.out.println(e.getMessage());
			}catch(NumberFormatException e){
				System.out.println(e.getMessage());
			}
		}
		
		return input;	
		
	}
	
	public double calcAvg(double total, double mark){
		return (double)Math.round(mark/total*1000)/1000;
	}
	
	public String finalMessage(String name, double percent){
		double inPercentForm = Math.round(percent*10000)/100;
		
		return (inPercentForm > 50)? name + " you scored a " + inPercentForm + "% and passed!" : name + " you scored a " + inPercentForm + "% and failed...";
	}
	
}
