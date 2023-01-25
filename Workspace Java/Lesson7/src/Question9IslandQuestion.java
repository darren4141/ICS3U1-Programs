/*The Island of Money Question: King Bigfoot, leader of a wealthy island nation in the 
 * Arctic circle, was distributing his wealth to the one million natives who lived on the island. 
 * He had the entire island population line up in single file starting at the gates to his castle.
 * He gave $1 to the first native. The next two natives got $2 each. The next three natives got $3, 
 * and so on. King Bigfoot’s accountant has hired you to write a program in Java to determine what 
 * the millionth native received.*/
public class Question9IslandQuestion {
	public static void main(String[]args){
		int ppl = 0, money = 0;		
		while(ppl<1000000){
			money++;
			ppl+=money;
		}
		System.out.println("The millionth native will recieve: "+money);
	}
}