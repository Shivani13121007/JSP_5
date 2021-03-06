import java.io.*;
import java.util.*;

public class Print_Stair_Paths {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        printStairPaths(n,"");
    }

    public static void printStairPaths(int n, String path) {

        if(n<0)
        return;

        if(n == 0)
        {
            System.out.println(path);
            return;
        }

        // printStairPaths(n-1,path+1);
        // printStairPaths(n-2,path+2);
        // printStairPaths(n-3,path+3);

        for(int i = 1;i<=3;i++)
        {
            printStairPaths(n-i,path+i);
        }

    }

}