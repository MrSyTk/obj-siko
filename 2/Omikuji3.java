class Omikuji {
    int rand() {
        return (int) (Math.random() * 4);  // 0..3の乱数を返す．
    }
    String first() {
        return "運勢は";
    }
    String second() {
        switch(rand()) {
        case 0:
            return "凶";
        case 1:
            return "小吉";
        case 2:
            return "吉";
        default:
            return "大吉";
        }
    }
    String last() {
        return "です．";
    }
    void print() {
        System.out.println(first() + second() + last());
    }
}

class Omikuji2 extends Omikuji {
    String first() {
        return "あなたの明日の運勢は";
    }
}

class Omikuji3 extends Omikuji2 {
    String second(){
        switch(rand()){
        case 0:
            return "アンラッキー";
        case 1:
            return "ちょっとラッキー";
        case 2:
            return "ラッキー";
        default:
            return "大ラッキー";
        }
    }
}
