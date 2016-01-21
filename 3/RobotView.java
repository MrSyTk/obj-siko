interface RobotView {
    public void turn(double oldHeading, double newHeading);
    public void move(double oldX, double oldY,
                     double newX, double newY);
}

class SimpleView implements RobotView {
    // public void turn(double oldHeading, double newHeading){
    //     System.out.println(oldHeading);
    // }
    
    public void move(double oldX, double oldY,
                     double newX, double newY){
        System.out.println(oldX + " " + oldY + "\n" +
                           newX + " " + newY);
    }
    public void turn (double oldHeading, double newHeading){};
}

class DotView implements RobotView {
    public void move(double oldX, double oldY,
                     double newX, double newY){
        double vec10X=(newX-oldX)/10.0;
        double vec10Y=(newY-oldY)/10.0;
        
        double nowX=oldX;
        double nowY=oldY;

        for(int i=0;i<=10;i++){
            System.out.println(nowX + " " + nowY);
            nowX+=vec10X;
            nowY+=vec10Y;
        }
    }
    public void turn (double oldHeading, double newHeading){};
}
