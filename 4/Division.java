class Division {
    public int a;
    /**
     *小数の割り算を行うメソッド
     *aを更新する副作用をもつ
     *出力は商
     *@param 除数
     **/
    Division(int a) {
        this.a = a;
    }
	public static boolean is_zero = false;

    public int div(int n){
        int c;
		a*=10;
		if(a<n) {
			return 0;
		}
		c=a/n;
		a%=n;
		if(a == 0) {
			is_zero = true;
		}
        return c;
    }
    public static boolean isReach(Division r,Division t){
		if(r.a == t.a) {
			return true;
		}
		return false;
    }
/*
	public static void main(String[] args) {
		Division A = new Division(9);
		Division B = new Division(15);
		A.div(3);
		B.div(5);
		if (A.is_zero == true) {
			System.out.println("あ");
		}
		if(isReach(A, B)) {
			System.out.println("*");
		}
		
	}*/
}
