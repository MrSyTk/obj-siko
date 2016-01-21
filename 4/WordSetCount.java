import java.util.*;

class WordSetCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<String> set = new HashSet<String>();
        while (input.hasNext()) 
            set.add(input.next());
        System.out.println (set.size() + " words.");
    }
}
