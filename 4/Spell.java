import java.io.*;
import java.util.*;

class Spell {
    // 指定した名前のファイルから読むScannerを作って返すクラスメソッド
    static Scanner fileScanner(String fileName) {
        Scanner value = null;
        try {
            value = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("ファイル" +  fileName + "は存在しません。");
            System.exit(1);
        }
        return value;
    }
    public static void main(String[] args) {
        Scanner dict = fileScanner("dict");
        Set<String> dictwords = new HashSet<String>();
        while (dict.hasNext()) 
            dictwords.add(dict.next().toLowerCase());
        Scanner text = fileScanner(args[0]);
        text.useDelimiter("[^a-zA-Z]+");
        Set<String> misswords = new HashSet<String>();
        //テキストの走査
        while(text.hasNext()){
            String word = text.next().toLowerCase();
            if(dictwords.contains(word)==false)
                misswords.add(word);
        }

        for(String s:misswords)
            System.out.println(s);
        
        
    }
}
