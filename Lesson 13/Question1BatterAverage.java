import java.io.*;
public class Question1BatterAverage {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int average;
		System.out.println("Welcome! This program will take a batter's average and decide where they go");
		System.out.print("Enter a batting average <or enter '-1' to end>: ");
		average = Integer.parseInt(br.readLine());
		
		while(average!=-1){
			if(average>=300){
				System.out.println("Sent to Toronto");
			}else if(average >=275){
				System.out.println("Sent to Dunedin");
			}else{
				System.out.println("Released");
			}
			System.out.print("Enter a batting average <or enter '-1' to end>: ");
			average = Integer.parseInt(br.readLine());
			
		}
		
		System.out.println("Thanks for using this program!");
	}
}
