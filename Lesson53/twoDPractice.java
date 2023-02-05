import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// EXAM PRACTICE QUESTION
// Write a program that will fill a 4 by 5 two-dimensional array with integers.  
// The program will find the sum of each row and each column along with the average of all the elements.   
// The filled array along with the sum of each row and each column and the average must be displayed in a neat table.  
// To obtain full marks functional and procedural methods must be used and arrays passed to and from methods. 

public class twoDPractice{
    static int LENGTH = 4;
    static int WIDTH = 5;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        twoDPractice TD = new twoDPractice();

        System.out.println("Fill up a 4x5 integer array below: ");

        int arr[][] = TD.fillArr(br, LENGTH, WIDTH);
        int rowSums[] = TD.sumRows(arr);
        int colSums[] = TD.sumCols(arr);
        double average = TD.twoDAverage(arr);

        System.out.println("ROW TOTALS:");
        for(int i = 0; i < arr.length; i++){
            System.out.println("Sum of row " + i + ": " + rowSums[i]);
        }

        System.out.println("COLUMN TOTALS:");
        for(int i = 0; i < arr[0].length; i++){
            System.out.println("Sum of column " + i + ": " + colSums[i]);
        }

        System.out.println("AVERAGE OF ENTIRE ARRAY: " + average);

    }

    public int[][] fillArr(BufferedReader br, int length, int width) throws IOException{
        int[][] array = new int[length][width];

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = Integer.parseInt(br.readLine());
            }
        }

        return array;
    }

    public int[] sumRows(int[][]array){

        int[]rowSums = new int[array.length];
        
        for(int i = 0; i < array.length; i++){
            int total = 0;
            for(int j = 0; j < array[i].length; j++){
                total += array[i][j];
            }
            rowSums[i] = total;
        }

        return rowSums;
    }

    public int[] sumCols(int[][]array){

        int[]colSums = new int[array[0].length];

        for(int i = 0; i < array[0].length; i++){
            int total = 0;
            for(int j = 0; j < array.length; j++){
                total += array[j][i];
            }
            colSums[i] = total;
        }

        return colSums;
    }

    public double twoDAverage(int[][]array){
        int total = 0;
        int size = array.length * array[0].length;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                total += array[i][j];
            }
        }

        return total/size;

    }

}