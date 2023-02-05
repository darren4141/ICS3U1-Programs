
public class Question1 {

	public static void main(String[]args){
		Question1 Q1 = new Question1();
		Q1.drawStar();
		for(int i = 0; i < 5; i++) Q1.drawHashtag();
		Q1.drawStar();
		
	}
	
	public void drawStar(){
		System.out.println("**********");
	}
	
	public void drawHashtag(){
		System.out.println("#####");
	}
	
}
