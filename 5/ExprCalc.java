import java.util.*;
public class ExprCalc extends OOGCalc<ExprCalc.Tree> {
    static RatioCalc ratio = new RatioCalc();
    static Deque<RatioCalc._Ratio> rstack = new LinkedList<RatioCalc._Ratio>();
    abstract class Tree implements Numeric<Tree> {
        abstract public String toString();
        abstract public void stackTree();
        public Tree add(Tree t) { return new Node("+", this, t); }
        public Tree subtract(Tree t) { return new Node("-", this, t); }
        public Tree multiply(Tree t) { return new Node("*", this, t); }
        public Tree divide(Tree t) { return new Node("/", this, t); }
    }
    static String readTree(Tree t){
        t.stackTree();
        return rstack.pop().toString();
    }
    class Eval extends OOGCalc<Tree>.Op {
        public String opName(){return "?";}
        public void exec(Deque<Tree> stack){
            System.out.println(readTree(stack.pop()));
        }
    }
    final Eval EVAL_OP = new Eval();
    ExprCalc(){
        super.ops.put("?",EVAL_OP);
    }
    class Leaf extends Tree {
        int value;
        Leaf(int value) { this.value = value; }
        public String toString() { return Integer.toString(value); }
        public void stackTree(){
            rstack.push(ratio.fromInt(value));
        }
    }
    class Node extends Tree {
        String op;
        Tree left;
        Tree right;
        Node(String op, Tree left, Tree right){
            this.op=op;
            this.left=left;
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
            left.stackTree();
            right.stackTree();
            ratio.ops.get(op).exec(rstack);
        }
   
    }
    public Tree fromInt(int v){
        return new Leaf(v);
    }
    public static void main(String[] args){
	new ExprCalc().run();
    }
        

}
