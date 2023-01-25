import java.io.*;
public class MagicSquare {

	final static int side = 5;
	static int[][]square = new int[side][side];

	public static void main(String[]args) throws IOException{
		
		boolean horizontal, vertical, diagonal, magic;
		MagicSquare MS = new MagicSquare();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("A magic square is a two dimensional array in which each row sum, column sum, and diagonal sum are equal.");
		System.out.println("This program will determine if an inputted 5x5 grid is a magic square or not");
		
		System.out.println("A1 A2 A3 A4 A5");
		System.out.println("B1 B2 B3 B4 B5");
		System.out.println("C1 C2 C3 C4 C5");
		System.out.println("D1 D2 D3 D4 D5");
		System.out.println("E1 E2 E3 E4 E5");
		
		System.out.println("Enter your magic square below:");
		
		MS.inputRow(0, "A", br);
		MS.inputRow(1, "B", br);
		MS.inputRow(2, "C", br);
		MS.inputRow(3, "D", br);
		MS.inputRow(4, "E", br);
		
		MS.printGrid(square);
		horizontal = MS.checkHorizontal(square);
		vertical = MS.checkVertical(square);
		diagonal = MS.checkDiagonal(square);
		
		System.out.print("The sums of the rows is");
		System.out.print((horizontal)?"":" NOT");
		System.out.println(" equal.");
		
		System.out.print("The sums of the columns is");
		System.out.print((vertical)?"":" NOT");
		System.out.println(" equal.");
		
		System.out.print("The sums of the diagonals is");
		System.out.print((diagonal)?"":" NOT");
		System.out.println(" equal.");
		
		magic = vertical && horizontal && diagonal;
		
		System.out.println((magic)? "You have a magic square!" : "You do not have a magic square!");
		
	}
	
	public void inputRow(int row, String letter, BufferedReader br) throws IOException{
		
		for(int i = 1; i <= side; i++){
			System.out.print(letter+i+": ");
			
			square[row][i-1] = Integer.parseInt(br.readLine());			
		}

	}
	
	public void printGrid(int[][]grid){
		System.out.println("Your magic square:");
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.printf("%-3s", grid[i][j]);
			}
			System.out.println();
		}
	}
	
	public boolean checkHorizontal(int[][]grid){
		int compareTo = 0;
		for(int v: grid[0])compareTo += v;
		
		
		for(int i = 1; i < grid.length; i++){
			int total = 0;
			for(int j = 0; j < grid[i].length; j++){
				total += grid[i][j];
			}
			if(compareTo != total){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkVertical(int[][]grid){
		int compareTo = 0;
		for(int i = 0; i < grid.length; i++){
			compareTo += grid[i][0];
		}
		
		
		for(int i = 1; i < grid[i-1].length; i++){
			int total = 0;
			for(int j = 0; j < grid.length; j++){
				total += grid[j][i];
			}
			if(compareTo != total){
				return false;
			}
		}
		
		return true;
	}
	
	public boolean checkDiagonal(int[][]grid){
		int positiveTotal = 0;
		int negativeTotal = 0;
		
		for(int i = 0; i < grid.length; i++){
			positiveTotal += grid[i][i];
			negativeTotal += grid[grid.length-1-i][i];
		}
		
		if(positiveTotal == negativeTotal){
			return true;
		}else{
			return false;
		}
	}
	
}
