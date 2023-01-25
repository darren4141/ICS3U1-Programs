public class Question5TableOfValues {
	public static void main(String[]args){
		System.out.println("Table of values for z = 2x - y^2");
		int z;
		
		System.out.println("\n            x      y      z");
		System.out.println("        _________________________");
		for(int x = -1; x <= 2; x++){
			for(int y = -2; y <=1; y++){
				z = (2*x) - (y*y);
				System.out.println("\t|"+x+"\t|"+y+"\t|"+z+"\t|");
			}
		}
		System.out.println("        _________________________");
		System.out.println("Thanks for using this program!");
	}
	
}
