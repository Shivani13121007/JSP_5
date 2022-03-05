import java.io.*;
import java.util.*;

public class Get_Kpc {

    public static String[] code = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();

       ArrayList<String> ans =  getKPC(str);

        System.out.println(ans);

    }

    public static ArrayList<String> getKPC(String str) {

        if(str.length() == 0)
        {
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");

            return bres;
        }
        
        char ch = str.charAt(0);
        String rString = str.substring(1);

        ArrayList<String> res =  getKPC(rString);

        ArrayList<String> Myres = new ArrayList<>();

        String decode = code[ch - '0'];

        for(int i = 0;i<decode.length(); i++)
        {
            char s = decode.charAt(i);

            for(int j = 0;j<res.size();j++)
            {
                String toAdd = s+res.get(j);
                Myres.add(toAdd);
            }
        }
        return Myres;

    }

}