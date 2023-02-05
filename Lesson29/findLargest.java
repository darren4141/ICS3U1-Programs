import java.io.*;
public class findLargest {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[]args) throws IOException{
		findLargest fL = new findLargest();
		String stringNum;
		int number, largest = 0;
		System.out.println("Welcome! This program will find the largest number in a set of numbers!");
		
		System.out.println("Enter a number: <or enter 'STOP'> to exit");
		stringNum = fL.readString();
		
		while(!stringNum.equals("STOP")){
			number = Integer.parseInt(stringNum);
			largest = fL.findBigger(number, largest);
			System.out.println("Enter a number: <or enter 'STOP'> to exit");
			stringNum = fL.readString();
		}
		
		System.out.println("The largest number entered is: " + largest);
		
	}
	
	public String readString() throws IOException{
		return br.readLine();
	}
	
	public int findBigger(int current, int compareTo){
		int larger;
		if(current > compareTo){
			larger = current;
		}else{
			larger = compareTo;
		}
		
		return larger;
		
	}
}
