import java.io.*;
import java.text.DecimalFormat;
public class CanadasWonderlandSwitch {
	public static void main(String[] args) throws IOException {
		//declare
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat formatMoney = new DecimalFormat(".00");
		int count = 0, infantCount = 0, teenCount = 0, adultCount = 0, seniorCount = 0, ageOption;
		double infantSpent, teenSpent, adultSpent, seniorSpent, average;
		final double INFANTPRICE=0, TEENPRICE = 20, ADULTPRICE = 35.5, SENIORPRICE = 24.75;
		final String SENTINEL = "end";
		String name;
		
		//welcome
		System.out.println("Welcome to Canada's Wonderland!");
		System.out.println("What is your name? or enter <end> to exit the program");
		name = br.readLine();
		
		//input values
		while(!name.equals(SENTINEL)){
			System.out.println("Select an option (1, 2, 3, 4): ");
			System.out.println("\nPRICING:\n1) infant: 5 and under: \tFREE\n2) teen: 6 to 15: \t\t$"+formatMoney.format(TEENPRICE)+"\n3) adult: 16 to 64: \t\t$"+formatMoney.format(ADULTPRICE)+"\n4) senior: 65 and older: \t$"+formatMoney.format(SENIORPRICE));
			ageOption = Integer.parseInt(br.readLine());
			
			//selection
			switch(ageOption){
				case 1:
					System.out.println(name+ ", your admission is free!");
					infantCount++;
					break;
				case 2:
					System.out.println(name+ ", your admission is $"+formatMoney.format(TEENPRICE));
					teenCount++;
					break;
				case 3:
					System.out.println(name+ ", your admission is $"+formatMoney.format(ADULTPRICE));
					adultCount++;
					break;
				case 4:
					System.out.println(name+ ", your admission is $"+formatMoney.format(SENIORPRICE));
					seniorCount++;
					break;
				default:
					System.out.println("Please enter a valid option");
			}
			System.out.println("\n\n\n\n\n");
			System.out.println("\nWelcome to Canada's Wonderland!");
			System.out.println("What is your name? or enter <end> to exit the program");
			name = br.readLine();
		}
		
		//calculate
		infantSpent = infantCount * INFANTPRICE;
		teenSpent = teenCount * TEENPRICE;
		adultSpent = adultCount * ADULTPRICE;
		seniorSpent = seniorCount * SENIORPRICE;
		count = teenCount+infantCount + adultCount + seniorCount;
		average = (teenSpent + infantSpent + adultSpent + seniorSpent)/count;
		
		//output
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(".---------------------------------------------------------------.");
		System.out.println("|GROUP\t\t|  NUMBER OF VISITORS\t| TOTAL SPENT BY GROUP\t|");
		System.out.println("|---------------+-----------------------+-----------------------|");
		System.out.print("|infants\t|\t"+infantCount+"\t\t|\t$");
		System.out.println((infantSpent==0)? "0.00"+"\t\t|" : formatMoney.format(infantSpent)+"\t\t|"); //if print
		
		System.out.print("|teenagers\t|\t"+teenCount+"\t\t|\t$");
		System.out.println((teenSpent==0)? "0.00"+"\t\t|" : formatMoney.format(teenSpent)+"\t\t|");
		
		System.out.print("|adults\t\t|\t"+adultCount+"\t\t|\t$");
		System.out.println((adultSpent==0)? "0.00"+"\t\t|" : formatMoney.format(adultSpent)+"\t\t|");
		
		System.out.print("|seniors\t|\t"+seniorCount+"\t\t|\t$");
		System.out.println((seniorSpent==0)? "0.00"+"\t\t|" : formatMoney.format(seniorSpent)+"\t\t|");
		System.out.println("'---------------------------------------------------------------'");
		
		System.out.println((count==0)?"No one showed up today! The average admission fee was $0.00" : "The average admission fee was: $"+formatMoney.format(average));

		System.out.println("Thanks for using this program!");
		
	}
}
