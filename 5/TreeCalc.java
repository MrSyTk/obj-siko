import java.util.*;
public class TreeCalc extends OOGCalc<TreeCalc.Tree> {
    static RatioCalc ratio = new RatioCalc();//インスタンスが無いとメソッドが使えない
    //↓有理数を記録するスタック。"?"の途中計算を記録する
    static Deque<RatioCalc._Ratio> rstack = new LinkedList<RatioCalc._Ratio>();
    abstract class Tree implements Numeric<Tree> {
        abstract public String toString();
        abstract public void stackTree();//tを計算して_Ratio型のスタックに積む
        public Tree add(Tree t) { return new Node("+", this, t); }
        public Tree subtract(Tree t) { return new Node("-", this, t); }
        public Tree multiply(Tree t) { return new Node("*", this, t); }
        public Tree divide(Tree t) { return new Node("/", this, t); }
    }
    
    static String readTree(Tree t){
        t.stackTree();//計算結果はrstackへ
        return rstack.pop().toString();//(RatioCalc._Ratio.toString()を参照)
        //rstackは空になるはず
    }
    //"?"命令のクラス．一番手前の式を評価する(printOPを参考にした)
    class Eval extends OOGCalc<Tree>.Op {
        public String opName(){return "?";}
        public void exec(Deque<Tree> stack){
            //一番上に積んでる木をとってreadTree
            System.out.println(readTree(stack.getFirst()));
        }
    }
    final Eval EVAL_OP = new Eval();
    TreeCalc(){
        super.ops.put("?",EVAL_OP);//"?"命令追加
    }
    class Leaf extends Tree {
        int value;
        Leaf(int value) { this.value = value; }
        public String toString() { return Integer.toString(value); }
        public void stackTree(){
            rstack.push(ratio.fromInt(value));//_Ratio型にする
        }
    }
    class Node extends Tree {
        String op;
        Tree left;
        Tree right;
        Node(String op, Tree left, Tree right){
            this.op=op;
            this.left=left;//これまでの式をまるまる左に
            this.right=right;
        }
        public String toString(){
            String result="("+
                left.toString()+
                this.op+
                right.toString()+")";
            return result;
        }
        public void stackTree(){
            left.stackTree();//帰りがけ
            right.stackTree();
            //左と右２つの_Ratio要素をpopして計算
            ratio.ops.get(op).exec(rstack);
            //新しく積む(OOGCalc.BinOp.exec()を参照)
        }
   
    }
    public Tree fromInt(int v){
        return new Leaf(v);
    }
    public static void main(String[] args){
	new TreeCalc().run();
    }
        

}
