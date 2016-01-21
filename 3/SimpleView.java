
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
