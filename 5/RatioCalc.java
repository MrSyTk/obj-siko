import java.util.*;
public class RatioCalc extends OOGCalc<RatioCalc._Ratio> {
    class _Ratio implements Numeric<_Ratio> {
        Ratio r;
        _Ratio(Ratio v) { this.r = v; }
        public _Ratio add(_Ratio v) { return new _Ratio(r.add(v.r)); }
        public _Ratio subtract(_Ratio v) { return new _Ratio(r.subtract(v.r)); }
        public _Ratio multiply(_Ratio v) { return new _Ratio(r.multiply(v.r)); }
        public _Ratio divide(_Ratio v) { return new _Ratio(r.divide(v.r)); }
        public String toString() { return r.toString(); }
    }
    public _Ratio fromInt(int v) {
        return new _Ratio(new Ratio(v,1));
    }
    class NoOp extends Op {
        public String opName(){ return "noop"; }
        public void exec(Deque<_Ratio> stack){};
    }
    final NoOp NO_OP = new NoOp();
    String[][] alias = {{"足す", "+"}, {"引く", "-"}, {"かける", "*"}, {"割る", "/"},
                        {"から", "noop"}, {"と", "noop"}, {"を", "noop"}, {"で", "noop"}};
    RatioCalc(){
        ops.put(NO_OP.opName(),NO_OP);
	for(String[] jp : alias)
	    ops.put(jp[0],ops.get(jp[1]));
    }
    public static void main(String[] args) {
        new RatioCalc().run();
    }
}
