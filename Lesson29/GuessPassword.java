import java.io.*;
public class GuessPassword {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final String PASSWORD = "1234";
	
	public static void main (String[]args) throws IOException{
		GuessPassword gP = new GuessPassword();
		String guess;
		boolean isCorrect;
		
		System.out.print("Welcome to this program! Enter the password to proceed: ");
		guess = gP.readString();
		isCorrect = gP.checkCorrect(guess);
		
		for(int i = 0; i < 2; i++){
			if(!isCorrect){
				System.out.println("Try again");
				System.out.print("Enter a password to proceed: ");
				guess = gP.readString();
				isCorrect = gP.checkCorrect(guess);			
			}
		}
		
		if(!isCorrect){
			System.out.println("Password incorrect 3 times - goodbye");
		}else{
			System.out.println("Correct password entered - welcome");
		}
		
		System.out.println("Thanks for using this program!");
		
	}
	
	public String readString() throws IOException{
		return br.readLine();
	}
	
	public boolean checkCorrect(String guess){
		if(guess.equals(PASSWORD)){
			return true;
		}else{
			return false;
		}
	}
	
}
