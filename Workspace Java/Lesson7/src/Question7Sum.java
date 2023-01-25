public class Question7Sum {
	public static void main(String[]args){
		int total = 0;
		for(int i = 91; i<989;i+=13)total+=i;	
		System.out.println("The sum of all numbers divisible by 13 between 91 and 989 is: "+total);
	}
}
