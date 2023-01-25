import java.io.*;
import java.util.Scanner;
public class UsingScannerClass {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int integer;
		long longInteger;
		float realNumber;
		double doubleReal;
		String string1;
		String string2;
		
		integer = in.nextInt();
		longInteger = in.nextLong();
		realNumber = in.nextFloat();
		doubleReal = in.nextDouble();
		string1 = in.next();
		System.out.println();
		string2 = in.next();
		
		in.close(); //closes the Scanner class
	}
}
