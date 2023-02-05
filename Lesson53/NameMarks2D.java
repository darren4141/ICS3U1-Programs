import java.io.*;

/*
 * 1. 
 * 	a) 14
 * 	b) 6
 * 	c) 125
 * 	d) 4 
 * 
 * 3. 
 * 	a) 4,3,2,1,8,7,6,5
 * 	b) 8,7,6,5,4,3,2,1
 * 	c) 1,5,2,6,3,7,4,8
 * 	d) 4,8,3,7,2,6,1,5
 */

public class NameMarks2D {
	
	public static void main (String[]args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] names = new String[10];
		int[][]marks = new int [10][5];
		
		
		System.out.println("Welcome! This program will display a mark chart!");
		
		for(int i = 0; i < marks.length; i++){
			System.out.print("Enter a name: ");
			names[i] = br.readLine();
			
			System.out.println("Enter 5 marks below:");
			for(int j = 0; j < marks[i].length; j++){
				marks[i][j] = Integer.parseInt(br.readLine());
			}
			
		}
		
		System.out.println(".----------------------------------------------------------------------------------------------------------------------------------------------------------------------.");
        System.out.printf("|%-20s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%n", "\tName", "\tMark 1", "\tMark 2", "\tMark 3", "\tMark 4", "\tMark 5", "\tAverage");

        for(int i = 0; i < marks.length; i++){
    		System.out.println("|---------------------------+------------------+-----------------------+-----------------------+-----------------------+-----------------------+-----------------------|");
        	double avg = 0;
        	System.out.printf("|%-20s ", "\t" + names[i]);
        	
        	for(int j = 0; j <marks[i].length; j++){
        		System.out.printf("|%-15s ", "\t" + marks[i][j]);
        		avg += marks[i][j];
        	}
        	
        	avg /= marks[i].length;
        	
        	System.out.printf("|%-15s |%n", "\t" + avg);
        	
        }
		System.out.println("'----------------------------------------------------------------------------------------------------------------------------------------------------------------------'");

	}
	
	

}
