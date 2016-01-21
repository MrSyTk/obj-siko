// ファイルShape.java
public abstract class Shape {
    // 抽象メソッド inside(x, y)
    // (x, y)が図形の内側ならtrueを，そうでなければfalseを返すものとする．
    // ちょうど境界線上は内側とみなす約束とする．
    abstract boolean inside(double x, double y); 

    // draw(x1, x2, xstep,  y1, y2, ystep)
    // x座標: x1からx2までxstep刻み
    // y座標: y1からy2までystep刻み
    // (x, y)が図形の内側なら*を，そうでなければ空白を書く．
    void draw(double x1, double x2, double xstep,
              double y1, double y2, double ystep) {
        for (double y = y2; y >= y1; y -= ystep) {
            for (double x = x1; x <= x2; x += xstep) {
                if (inside(x, y)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
class RectShape extends Shape {
    double left, bottom, width, height;
    RectShape(double left, double bottom, double width, double height) {
        this.left = left;
        this.bottom = bottom;
        this.width = width;
        this.height = height;
    }
    boolean inside(double x, double y) {
        return left <= x && x <= left + width &&
            bottom <= y && y <= bottom + height;
    }
}

class CircleShape  extends Shape {
    double x0, y0, r;  // 中心座標(x0, y0), 半径r
    CircleShape(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }
    boolean inside(double x, double y) {
        return (((x-x0)*(x-x0)+(y-y0)*(y-y0))<=r*r);
    }
}

// ファイルParabolaShape.java
class ParabolaShape extends Shape {
    double a, b, c;  // a * x^2 + b * x + c =  y
    ParabolaShape(double a, double b, double c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    boolean inside(double x, double y) {
        return ((a*x*x+b*x+c)>=y);
    }
}

// ファイルParabolaTest.java
class ParabolaTest {
    public static void main(String[] args) {
        ParabolaShape p = new ParabolaShape(-1, 6, -5);
        p.draw(0.0, 6.0, 0.15,
               0.0, 5.0, 0.3);
    }
}

