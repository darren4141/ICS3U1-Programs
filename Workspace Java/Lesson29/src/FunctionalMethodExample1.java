public class FunctionalMethodExample1 {
	public static void main (String [] args) {
		int result;
		FunctionalMethodExample1 fME1 = new FunctionalMethodExample1();
		for(int value = 1; value <= 10; value++) {
			result = fME1.square(value);
			System.out.println(result);
		}
		
	}
	
	public int square(int number) {
		return number*number;
	}
}
