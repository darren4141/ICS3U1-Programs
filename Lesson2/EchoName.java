import java.io.*;
public class EchoName {
	public static void main(String[]args) throws IOException{
		String name;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please type your name: ");
		name = br.readLine();
		System.out.println("Your name is \""+name+"\"");
	}
}
