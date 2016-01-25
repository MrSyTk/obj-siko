import java.util.*;

public class JCalc extends OOCalc {
    String[][] alias = {{"足す", "+"}, {"引く", "-"}, {"かける", "*"}, {"割る", "/"},
                        {"から", "noop"}, {"と", "noop"}, {"を", "noop"}, {"で", "noop"}};

    JCalc(){
	for(String[] jp : alias)
	    ops.put(jp[0],ops.get(jp[1]));
    }
    public static void main(String[] args){
	new JCalc().run();
    }
}
