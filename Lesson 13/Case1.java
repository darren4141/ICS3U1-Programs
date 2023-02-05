import java.io.*;
public class Case1 {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A=0, B=0, C=0, D=0, F=0, mark;
		System.out.println("Enter marks, end with -1");
		mark = Integer.parseInt(br.readLine());
		
		while(mark != -1){
			switch(mark){
			case 8: case 9: case 10:
				A++;
				break;
			case 7:
				B++;
				break;
			case 6:
				C++;
				break;
			case 5:
				D++;
				break;
			case 0: case 1: case 2: case 3: case 4:
				F++;
				break;
			default:
				System.out.println("Please enter a valid mark.");
				break;
			}
			System.out.println("Enter a mark, or end with -1");
			mark = Integer.parseInt(br.readLine());
		}
		
		System.out.println("A = "+A);
		System.out.println("B = "+B);
		System.out.println("C = "+C);
		System.out.println("D = "+D);
		System.out.println("F = "+F);
		System.out.println("Thanks for using this program!");

		
	}
}
