import java.io.*;

public class Question4 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main (String[]args)throws IOException{
		Question4 Q4 = new Question4();
		int length, width;
		System.out.println("Welcome! This program will draw a hollow rectangle based on your specified dimensions");
		System.out.println("Enter the length of your rectange:");
		length = Q4.readInt();
		System.out.println("Enter the width of your rectange:");
		width = Q4.readInt();

		Q4.drawRectangle(length, width);
		
	}
	
	public void drawRectangle(int length, int width){
		for(int y = 0; y < length; y++){
			for(int x = 0; x < width; x++){
				if(y == 0 || y == length-1 || x == 0 || x == width-1){
					System.out.print("&");

				}else{
					System.out.print(" ");;
				}
			}
			System.out.println();
		}
		
	}
	
	public int readInt() throws IOException{
		return Integer.parseInt(br.readLine());
	}
	
}
