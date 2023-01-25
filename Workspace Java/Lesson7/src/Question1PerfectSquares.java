import java.io.*;
public class Question1PerfectSquares {
	public static void main(String[]args) throws IOException{
		//declare
		final int TIMES = 20;
		
		//welcome
		System.out.println("Welcome! This program will show you the perfect squares from 1 to 400!");
		System.out.println("\nNumber        Square");
		
		//iterate
		for(int i = 1; i <=TIMES; i++){
			System.out.print("  "+i+"            ");
			System.out.print((i<10)?" ":"");//for formatting
			System.out.println(i*i);
		}
		
		System.out.println("\nThanks for using this program!");
	}
}
