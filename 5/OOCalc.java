import java.util.*;
public class OOCalc {
    // OOCalc�̃C���i�[�N���X
    abstract class Op {
        abstract public String opName();
        abstract public void exec(Deque<Integer> stack);
    }
    class PrintOp extends Op {
        public String opName() { return "="; }
        public void exec(Deque<Integer> stack) {
            for (int p : stack) {
                System.out.println(p);
            }
        }
    }
    abstract class BinOp extends Op {
        abstract public int op(int rand1, int rand2);
        public void exec(Deque<Integer> stack) {
            int v2 = stack.pop();
            int v1 = stack.pop();
            stack.push(op(v1, v2));
        }
    }
    class AddOp extends BinOp {
        public String opName() { return "+"; }
        public int op(int rand1, int rand2) { return rand1 + rand2; }
    }
    class SubOp extends BinOp {
        public String opName() { return "-"; }
        public int op(int rand1, int rand2) { return rand1 - rand2; }
    }
    class MulOp extends BinOp {
        public String opName() { return "*"; }
        public int op(int rand1, int rand2) { return rand1 * rand2; }
    }
    class DivOp extends BinOp {
        public String opName() { return "/"; }
        public int op(int rand1, int rand2) { return rand1 / rand2; }
    }
    class NoOp extends Op {
        public String opName() { return "noop"; }
        public void exec(Deque<Integer> stack) {
            // �������Ȃ�
        }
    }
    // ���߈ꗗ�\
    Op[] optable = {new AddOp(), new SubOp(), new MulOp(), new DivOp(), 
                    new NoOp(), new PrintOp()};
    Deque<Integer> stack;
    Scanner scanner;
    Map<String, Op> ops;  // �P�ꎫ��
    OOCalc() {
        stack = new LinkedList<Integer>();
        scanner = new Scanner(System.in);
        ops = new HashMap<String, Op>();
        // �����ɖ��ߌ��o�^����D
        for (Op op : optable) {
            ops.put(op.opName(), op);
        }
    }
    public void run() {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                stack.push(scanner.nextInt());
            } else {
                String token = scanner.next();
                if (ops.containsKey(token)) {
                    try {
                        ops.get(token).exec(stack); // �����������Ė��߂����߂���D
                    } catch (Exception e) {
                        System.out.println("�G���[: " + e);  // ���s���G���[
                    }
                } else {
                    System.out.println("�G���[: ������g�[�N��: " + token);
                }
            }
        }
    }
    
}