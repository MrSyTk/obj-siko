import java.util.*;
class FibLog{
    static Integer[][] Q = { {1,1},
                             {1,0} };
    static final long DIV=100000;//5桁
    static Map<Integer,Integer[][]> fM2 = new HashMap<Integer,Integer[][]>();
    //Z^2*2の行列のかけ算を行うメソッド
    static Integer[][] multiply(Integer[][] A, Integer[][] B){
        Integer[][] AB = new Integer[2][2];
        //10^10の整数値を記録するためにlong型の一時変数を用意する
        long a11=A[0][0]%DIV;
        long a12=A[0][1]%DIV;
        long a21=A[1][0]%DIV;
        long a22=A[1][1]%DIV;
        long b11=B[0][0]%DIV;
        long b12=B[0][1]%DIV;
        long b21=B[1][0]%DIV;
        long b22=B[1][1]%DIV;
        //long->5桁->int(->Integer)
        AB[0][0]=(int)((a11*b11+a12*b21)%DIV);
        AB[0][1]=(int)((a11*b12+a12*b22)%DIV);
        AB[1][0]=(int)((a21*b11+a22*b21)%DIV);
        AB[1][1]=(int)((a21*b12+a22*b22)%DIV);
        return AB;
    }

    //デバック用
    static void print(Integer[][] A){
        for(Integer[] a_:A){
            for(Integer a__:a_)
                System.out.print(a__+"\t");
            System.out.println("");
        }
    }
    //マップを読むためのメソッド
    static void print(int n){
        if(fM2.get(n)==null){
            System.out.println("It hasn't been calculated yet.");
            return;
        }
        print(fM2.get(n));
    }

    //Q^n (n=2^m)のマップを作る
    static Integer[][] calmap(int m){
        if(fM2.get(m)==null){
            Integer[][] M2n = new Integer[2][2];
            if(m<1)M2n=Q;//m=:0->fib(1),:1->fib(2)
            else M2n=multiply(calmap(m-1),calmap(m-1));
            //Q^2^m=Q^2^(m-1)*Q^2^(m-1)
            fM2.put(m,M2n);
            return M2n;
        }else return fM2.get(m);
    }

    //Q^n (n∈Z) をマップを元に計算する
    static int calfib(int n){
        Integer[][] M=Q;//初期値Eじゃね?
        char[] bitstr = Integer.toBinaryString(n).toCharArray();
        int m=bitstr.length-1;//nの2進でのビット数-1

        /*bitstrを走査して1があればQ^2^(m-i)を計算する*/
        for(int i=0;i<=m;i++)
            if(bitstr[i]=='1')
                M=multiply(M,calmap(m-i));//little endian
        return M[0][1];
    }

    static public void main(String args[]){
        long start = System.nanoTime();
        int n = Integer.parseInt(args[0]);
        System.out.println("fib(" + n + ") = " + calfib(n));
        System.out.println((System.nanoTime() - start) / 1000000 + "ms");
    }

}
        
