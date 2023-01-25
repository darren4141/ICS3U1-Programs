import java.io.*;
public class Selection1 {
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int SENTINEL = -1;
		int age, numberStudents=0, numberAdults=0, numberSeniors=0;
		System.out.println("Enter ages, end with "+SENTINEL);
		age = Integer.parseInt(br.readLine());
		while(age>SENTINEL){
			if(age>=65&&age<=200){
				numberSeniors++;
				System.out.println("Way to go");
			}else if(age<=12){
				numberStudents++;
			}else{
				numberAdults++;
			}
			
			System.out.println("Enter ages, end with "+SENTINEL);
			age = Integer.parseInt(br.readLine());
		}
		
		System.out.println("senior="+numberSeniors);
		System.out.println("adult="+numberAdults);
		System.out.println("student="+numberStudents);
		
	}
}
