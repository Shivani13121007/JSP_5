import java.io.*;
import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                st.push(ch);
            else {
                if (st.size() > 0) {
                    if (ch == ')' && st.peek() == '(')
                        st.pop();
                    else if (ch == '}' && st.peek() == '{')
                        st.pop();
                    else if (ch == ']' && st.peek() == '[')
                        st.pop();
                    else
                        return false;
                } else {
                    return false;
                }
            }
        }

        return st.size() > 0 ? false : true;
    }
}
