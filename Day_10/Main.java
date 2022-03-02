public class Main{

    public static void func(int n)
    {
        if(n == 0)
        return;

        System.out.println(n);
        func(n-1);
    }

    public static void fuct_1(int n)
    {
        if(n==0)
        {
            System.out.println("hey, Base Case" + n);
            return;
        }

        System.out.println("hello" + n);

        for(int i=0;i<3;i++)
        System.out.print(" "+n+"@"+i);

        if(n %2 == 0)
        System.out.println("even");

        fuct_1(n-1);

        if(n%2 != 0) System.out.println("odd");
    }

    public static void main(String args[]){
        // func(10);

        fuct_1(5);
    }
}