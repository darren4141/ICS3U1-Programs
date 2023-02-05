import java.io.*;
public class Reptition2 {
	public static void main(String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word;
		final String SENTINEL = "stop";
		System.out.println("Enter a sequence of words, end iwth "+SENTINEL);
		word = br.readLine();
		while(!word.equals("stop")){
			System.out.println("Last letter of "+word+" is "+word.charAt(word.length()-1));
			word = br.readLine();
		}
		
		System.out.println("This is the end of the sequence");
	}
}
