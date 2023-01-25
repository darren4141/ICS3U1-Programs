import java.io.*;

public class Question5 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main (String[]args)throws IOException{
		Question5 Q5 = new Question5();
		int side;
		String symbol;
		System.out.println("Welcome! This program will draw a right isosceles triangle based on your specified dimensions");
		System.out.println("Enter the length of the side:");
		side = Q5.readInt();
		System.out.println("Enter what symbol you would like the triangle to be made of (&, #, @)");
		symbol = Q5.readString();
		
		Q5.drawTriangle(side, symbol);
		
	}
	
	public void drawTriangle(int side, String symbol){
		for(int y = 1; y <= side; y++){
			for(int x = 0; x < y; x++){
				System.out.print(symbol);
			}
			System.out.println(" ");
		}
		
	}
	
	public int readInt() throws IOException{
		return Integer.parseInt(br.readLine());
	}
	
	public String readString() throws IOException{
		return br.readLine();
	}
	
}
