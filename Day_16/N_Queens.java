import java.io.*;
import java.util.*;

public class N_Queens {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[][] chess = new int[n][n];
        printNQueens(chess,"",0);
    }

    public static boolean isSafe(int[][] chess, int row, int col)
    {
        // vertically up
        for(int i = row; i>=0;i--)
        {
            if(chess[i][col] == 1)
            return false;
        }
        
        // Diagonally up
        for(int i = row, j = col; i>=0 && j<chess[0].length;i--,j++)
        {
            if(chess[i][j] == 1)
            return false;
        }
        
        // Anti-Dia up
        for(int i = row, j = col; i>=0 && j>=0;i--,j--)
        {
            if(chess[i][j] == 1)
            return false;
        }
        
        return true;
    }
    
    public static void printNQueens(int[][] chess, String qsf, int row) {
        
        if(row==chess.length)
        {
            System.out.println(qsf+".");
            return;
        }
        
        for(int col = 0;col<chess.length;col++)
        {
            if(isSafe(chess,row,col) == true)
            {
                chess[row][col] = 1;
                printNQueens(chess, qsf+row+"-"+col+", ",row+1);
                chess[row][col] = 0;
            }
        }
    }
}