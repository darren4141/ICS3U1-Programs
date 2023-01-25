import java.io.*;
public class SecretNumber {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SECRET = 82;
		int lowest = Integer.MAX_VALUE;
		String name, lowestName;
		System.out.println("Welcome! This is a game where you try to guess a number from 0-100");
		System.out.print("Enter your name or <end> to end: ");
		name = br.readLine();
		lowestName = name;
		while(!name.equals("end")){
			boolean guessed = false;
			int guess, attempts=0;
			while(!guessed){
				attempts++;
				System.out.print("Guess a number from 1-100: ");
				guess = Integer.parseInt(br.readLine());
				if(guess<SECRET){
					System.out.println("Try going higher!");
				}else if(guess>SECRET){
					System.out.println("Try going lower!");
				}else{
					guessed=true;
				}	
			}
			
			if(lowest>attempts){
				lowest = attempts;
				lowestName = name;
			}
			System.out.print(name+", you got it in "+attempts);
			System.out.println((attempts==1)? " attempt!":" attempts!");
			System.out.print("Our highscore is "+lowestName+" with "+lowest);
			System.out.println((lowest==1)? " attempt!":" attempts!");

			System.out.println("\nWelcome! This is a game where you try to guess a number from 0-100");
			System.out.println("Enter your name or <end> to end");
			name = br.readLine();
			
		}
		
		System.out.println("Thanks for using this program!");
		System.out.print("Our highscore is "+lowestName+" with "+lowest);
		System.out.println((lowest==1)? " attempt!":" attempts!");

	}
	
}
