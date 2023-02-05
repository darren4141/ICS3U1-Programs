import java.io.*;
public class PhraseMaker {

	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String [] Array = {"sat", "hit", "walks", "jumps", "bites", "You", "I", "He", "She", "They"};
		boolean repeat = true;	
		String choice;
		
		while(repeat){
			int selection;
			String phrase;
			
			System.out.println("Welcome! This program will generate a phrase");
			System.out.println("Select a verb:\n0. sat\n1. hit\n2. walks\n3. jumps\n4. bites");
			selection = Integer.parseInt(br.readLine());
			phrase = Array[selection];
			
			System.out.println("Select a pronoun:\n5. You\n6. I\n7. He\n8. She\n9. They");
			selection = Integer.parseInt(br.readLine());
			phrase = Array[selection] + " " + phrase;
			
			System.out.println(phrase);	
			
			while(true){
				System.out.println("Would you like to repeat the program? (y/n)");
				choice = br.readLine();
				if(choice.equals("y")){
					repeat = true;
					break;
				}else if(choice.equals("n")){
					repeat = false;
					break;
				}else{
					System.out.println("Please enter a valid option!");
				}
			}
			
		}
		
		System.out.println("Goodbye!");
		
	}
	
}
