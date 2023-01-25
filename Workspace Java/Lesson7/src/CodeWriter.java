public class CodeWriter {
	public static void main(String[] args){
		System.out.println("import java.io.*;");		
		System.out.println("public class ManualEvenOdd{");
		System.out.println("public static void main(String[] args) throws IOException{");
		System.out.println("BufferedReader br = new BufferedReader(new InputStreamReader(System.in));");
		System.out.println("System.out.println(\"Welcome to this program!\");");
		System.out.println("System.out.println(\"Enter a number!\");");
		System.out.println("int num = Integer.parseInt(br.readLine());");
		
		String state;
		for(int i = 0; i < 1000; i++){
			if(i%2==0){
				state = "EVEN";
			}else{
				state = "ODD";
			}
			
			if(i!=0){
				System.out.println("else if(num == "+i+"){System.out.println(\"YOUR NUMBER IS "+state+"\");}");
			}else{
				System.out.println("if(num == "+i+"){System.out.println(\"YOUR NUMBER IS "+state+"\");}");
			}
		}
		
		
		System.out.println("}");
		System.out.println("}");

	}
}
