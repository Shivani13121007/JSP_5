public class Main{

    public static void fun(int n)
    {
        if(n==0)
        return;

        System.out.println("Pre" + n);
        fun(n-1);
        System.out.println("In" + n);
        fun(n-1);
        System.out.println("post" + n);
    }
        public static void main(String args[]) {
            int n = 3;

            fun(n);
        }
}

