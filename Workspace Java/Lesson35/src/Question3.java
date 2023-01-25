import java.io.*;
public class Question3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main (String[]args)throws IOException{
		Question3 Q3 = new Question3();
		int length, width;
		System.out.println("Welcome! This program will draw a rectangle based on your specified dimensions");
		System.out.println("Enter the length of your rectange:");
		length = Q3.readInt();
		System.out.println("Enter the width of your rectange:");
		width = Q3.readInt();

		Q3.drawRectangle(length, width);
		
	}
	
	public void drawRectangle(int length, int width){
		for(int y = 0; y < length; y++){
			for(int x = 0; x < width; x++){
				System.out.print("&");
			}
			System.out.println();
		}
		
	}
	
	public int readInt() throws IOException{
		return Integer.parseInt(br.readLine());
	}
	
}
