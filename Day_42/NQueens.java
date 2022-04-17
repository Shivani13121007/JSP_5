import java.io.*;
import java.util.*;

public class NQueens {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        boolean[] col = new boolean[n];
        boolean[] dia = new boolean[2*n -1];
        boolean[] ADia = new boolean[2*n-1];
        
        printNQueens(chess, "", 0, col,dia,ADia);
    }

    public static void printNQueens(int[][] chess, String qsf, int row, boolean[] column , boolean [] dia, boolean[]ADia){
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }
        
        int n = chess.length;
        for(int col = 0; col < chess.length; col++){
            if(   column[col] == false && dia[row-col +n-1] == false && ADia[row+col] == false ){
                
                
                chess[row][col] = 1;
                
                column[col] = true;
                dia[row-col +n-1] = true;
                ADia[row+col] = true;
                
                
                
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1,column, dia, ADia);
                
                chess[row][col] = 0;
                
                column[col] = false;
                dia[row-col +n-1] = false;
                ADia[row+col] = false;
            }
        }
    }

    public static boolean isQueenSafe(int[][] chess, int row, int col){
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row - 1, j = col; i >= 0; i--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }

        for(int i = row, j = col - 1; j >= 0; j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        return true;
    }
}

