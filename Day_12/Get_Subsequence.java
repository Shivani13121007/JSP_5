import java.io.*;
import java.util.*;

public class Get_Subsequence {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        ArrayList<String> ans = gss(str);

        System.out.println(ans);

    }

    public static ArrayList<String> gss(String str) {
        // Base Case
        if(str.length() == 0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        // Extracting first character
        char ch = str.charAt(0);

        // Extracting remaining string
        String rString = str.substring(1); 

        // having faith on remaining string
        ArrayList<String> res = gss(rString);

        // In post order we are creating our own  ArrayList as we can't do changes inn the same arrayList
        ArrayList<String> postArr = new ArrayList<>();

        // Coying elements from the res
        for(int i = 0;i<res.size();i++)
        {
            String toAdd = res.get(i);
            postArr.add(toAdd);
        }

        // Attaching ch(extracted character) in each element 
        for(int i = 0;i<res.size();i++)
        {
            String toAdd = ch + res.get(i);
            postArr.add(toAdd);
        }

        // returning my new arrayList
        return postArr;

    }

}