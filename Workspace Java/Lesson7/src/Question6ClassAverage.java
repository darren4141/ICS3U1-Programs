import java.io.*;
public class Question6ClassAverage {
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name="";
		System.out.println("Welcome! This program will calculate individual averages of 5 and then calculate the class average.");
		System.out.println("Enter a student's name, or \"end\" to exit: ");
		name = br.readLine();
		double entireTotal = 0;
		int count = 0;
		while(!name.equals("end")&&!name.equals("END")&&!name.equals("End")){
			count++;
			System.out.println("Enter 5 marks, one per line");
			double total = 0;
			for(int i = 0; i < 5; i++){
				double mark = Double.parseDouble(br.readLine());
				total += mark;
			}
			System.out.println(name+"'s average is: "+(double)Math.round((total/5)*100)/100);
			entireTotal+=(total/5);
			System.out.println("Enter a student's name, or \"end\" to exit: ");
			name = br.readLine();
		}
		System.out.println("The class average is: "+(double)Math.round((entireTotal/count)*100)/100);
		System.out.println("Thanks for using this program!");
	}
}