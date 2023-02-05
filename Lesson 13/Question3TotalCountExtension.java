import java.io.*;
public class Question3TotalCountExtension {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int batterAverage, pitcherAverage, torontoCount=0, dunedinCount=0, releasedCount=0;
		String choice;
		System.out.println("Welcome! This program will take a pitcher or batter's average and decide where they go");
		System.out.println("Are you entering values for a pitcher or batter? (enter A, B, or C)\nA. Pitcher\nB. Batter\nC. Exit");
		choice = br.readLine();
		
		while(!choice.equals("C")){
			if(choice.equals("A")){
				System.out.print("Enter a pitcher's fastball speed: ");
				pitcherAverage = Integer.parseInt(br.readLine());	
				if(pitcherAverage>=87){
					System.out.println("Pitcher sent to Toronto");
					torontoCount++;
				}else if(pitcherAverage >=82){
					System.out.println("Pitcher sent to Dunedin");
					dunedinCount++;
					
				}else{
					System.out.println("Pitcher released");
					releasedCount++;
				}
				
			}else if(choice.equals("B")){
				System.out.print("Enter a batting average: ");
				batterAverage = Integer.parseInt(br.readLine());
				if(batterAverage>=300){
					System.out.println("Batter sent to Toronto");
					torontoCount++;
				}else if(batterAverage >=275){
					System.out.println("Batter sent to Dunedin");
					dunedinCount++;
				}else{
					System.out.println("Batter released");
					releasedCount++;
				}
			}else{
				System.out.println("Please enter a valid option");
			}
			
			System.out.println("\nAre you entering values for a pitcher or batter? (enter A, B, or C)\nA. Pitcher\nB. Batter\nC. Exit");
			choice = br.readLine();
		}
		
		System.out.println("STATS:");
		System.out.println("Toronto: "+torontoCount);
		System.out.println("Dunedin: "+dunedinCount);
		System.out.println("Released: "+releasedCount);

		System.out.println("Thanks for using this program!");
	}
}