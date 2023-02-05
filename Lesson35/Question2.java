import java.io.*;
public class Question2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[]args)throws IOException{
		Question2 Q2 = new Question2();
		int rows;
		System.out.println("Welcome! How many rows of +'s would you like?");
		rows = Q2.readInt();
		
		for(int i = 0; i < rows; i++){
			Q2.drawPlus();
		}
	}
	
	public void drawPlus(){
		System.out.println("++++++++++");
	}
	
	public int readInt() throws IOException{
		return Integer.parseInt(br.readLine());
	}
}
