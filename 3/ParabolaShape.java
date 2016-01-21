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
