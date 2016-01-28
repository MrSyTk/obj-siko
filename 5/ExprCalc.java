public class ExprCalc extends OOGCalc<ExprCalc.Tree> {
    abstract class Tree implements Numeric<Tree> {
        abstract public String toString();
        public Tree add(Tree t) { return new Node("+", this, t); }
        public Tree subtract(Tree t) { return new Node("-", this, t); }
        public Tree multiply(Tree t) { return new Node("*", this, t); }
        public Tree divide(Tree t) { return new Node("/", this, t); }
    }
    class Leaf extends Tree {
        int value;
        Leaf(int value) { this.value = value; }
        public String toString() { return Integer.toString(value); }
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
            
    }
    public Tree fromInt(int v){
        return new Leaf(v);
    }
    public static void main(String[] args){
	new ExprCalc().run();
    }

}
