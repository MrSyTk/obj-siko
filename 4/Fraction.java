import java.util.*;

class Fraction {
    static String stdout;
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        stdout = String.valueOf(m + "/" + n + " = ");
        System.out.print(m + "/" + n + " = ");
        if(m/n==0){
            stdout=stdout+String.valueOf("0");
            System.out.print("0");
        }else{
            stdout=stdout+String.valueOf((m/n));
            System.out.print((m/n));
        }
        if(m%n!=0){
            stdout=stdout+String.valueOf(".");
            System.out.print(".");
            RecurringDecimal(m, n);
        }
        System.out.println("");
    }
    static void RecurringDecimal(int a, int b) {
        a%=b;//小数についてのみ扱う
        Division t = new Division(a);
        Division r = new Division(a);
        Map<Integer,Integer> quotient = new HashMap<Integer,Integer>();
        int myu_cnt = 0;
        int lambda_cnt = 0;
        do{
            t.div(b);
            r.div(b);
            r.div(b);

        }while(Division.isReach(t,r)==false);
        r.a=a;//ウサギをスタートに戻す

        while(Division.isReach(t,r)==false) {
            t.div(b);
            quotient.put(myu_cnt,r.div(b));
            myu_cnt++;
        }
        //割り切れた場合
        if(Division.is_zero){
            for(int i=0;i<myu_cnt;i++)
                System.out.print(quotient.get(i));
            return;
        }
        do{
            quotient.put(myu_cnt+lambda_cnt,r.div(b));
            lambda_cnt++;
        }while(Division.isReach(t,r)==false);
        for(int i=0;i<lambda_cnt+myu_cnt;i++)
            System.out.print(quotient.get(i));
        System.out.println("");
        for(int i=0;i<stdout.length();i++)
            System.out.print(" ");
        for(int i=0;i<myu_cnt;i++)
            System.out.print(" ");//しっぽ
        for(int i=0;i<lambda_cnt;i++)
            System.out.print("^");
    }
}
