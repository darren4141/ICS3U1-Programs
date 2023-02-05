import java.io.*;
public class PopBars {
	public int pop1, pop2;
	public static void main (String[]args) throws IOException{
		PopBars pB = new PopBars();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter population of city #1 (in millions): ");
		String pop1String = br.readLine();
		pB.pop1 = Integer.parseInt(pop1String);
		pB.drawBar(pB.pop1);
		
		System.out.print("Enter population of city #2 (in millions): ");
		String pop2String = br.readLine();
		pB.pop2 = Integer.parseInt(pop2String);
		pB.drawBar(pB.pop2);
		
		
	}
	
	private void drawBar(int lineLength) {
		final String MARK = "*";
		int numMarks = 1;
		for(numMarks = 1; numMarks <= lineLength; numMarks++) {
			System.out.print(MARK);
		}
		System.out.println("");
	}
	
}
