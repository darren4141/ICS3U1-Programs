import java.io.*;

public class GuessNum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean correct = false;
	
	public static void main(String[]args) throws IOException{
		
		GuessNum GN = new GuessNum();
		
		final int SECRET = GN.getRand();
		int count = 1;
	
		System.out.println("Welcome! Guess my number between 1-100");
		
		while(!GN.evalInput(SECRET)){
			count++;
		}
		
		System.out.print("You took " + count);
		System.out.println((count != 1)? " tries!":" try!");
		
	}
	
	public int getRand(){
		return (int)(Math.random()*100)+1;
	}
	
	public boolean evalInput(int secret) throws IOException{
		int guess;
				
		while(true){
			try{
				guess = Integer.parseInt(br.readLine());
				if(guess >= 1 && guess <= 100) break;
				else System.out.println("Value must >= 1 and <= 100, try again");
				
			}catch(NumberFormatException e){
				System.out.println("Non-numeric input, try again");
				System.out.println(e.getMessage());
			}
		}
		
		if(guess > secret){
			System.out.println("Guess is too high!");
			return false;
		}else if(guess < secret){
			System.out.println("Guess is too low!");
			return false;
		}else{
			System.out.println("You guessed correctly!");
			return true;
		}
		
	}
	
}
