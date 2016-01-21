import java.util.*;
public class Fib2 {
    static Map<Integer,Integer> fmap = new HashMap<Integer,Integer>();
    static int fib(int n) {
        if(fmap.get(n)==null){
            int fn;
            if(n<2)
                fn=1;
            else
                fn=(fib(n - 1) + fib(n - 2)) % 100000;
            fmap.put(n,fn);
            return fn;
        }
        else return fmap.get(n);
    }
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        System.out.println("fib(" + n + ") = " + fib(n));
        System.out.println((System.nanoTime() - start) / 1000000 + "ms");
    }
}
