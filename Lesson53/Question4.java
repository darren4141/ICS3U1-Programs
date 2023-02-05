
public class Question4 {
	public static void main(String[]args){
		
		//a)
		int[][] arr = new int[3][5];
		
		//b)
		for(int i = 0; i <arr.length; i++){
			for(int j = 0; j <arr[i].length; j++){
				arr[i][j] = 0;
			}
		}
		
		//c)
		int grandTotal = 0;
		for(int i = 0; i <arr.length; i++){
			for(int j = 0; j <arr[i].length; j++){
				grandTotal += arr[i][j];
			}
		}
		
		//d) 
		int row2Sum = 0;
		for(int i = 0; i < arr[1].length; i++){
			row2Sum += arr[1][i];
		}

		//e)
		int col3Sum = 0;
		for(int i = 0; i < arr.length; i++){
			row2Sum += arr[i][2];
		}
		
		//f)
		int negSum = 0;
		for(int i = 0; i <arr.length; i++){
			for(int j = 0; j <arr[i].length; j++){
				if(arr[i][j] < 0) negSum += arr[i][j];
			}
		}
		
		//g)
		for(int i = 0; i <arr.length; i++){
			for(int j = 0; j <arr[i].length; j++){
				arr[i][j] *= arr[i][j];
			}
		}
		
		//h)
		int largest = 0;
		for(int i = 0; i <arr.length; i++){
			for(int j = 0; j <arr[i].length; j++){
				if(arr[i][j] > largest) largest = arr[i][j];
			}
		}
	}
}
