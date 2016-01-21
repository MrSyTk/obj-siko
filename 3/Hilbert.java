// ファイル Hilbert.java
public class Hilbert {
    static RobotModel robot;
    static double step;
    static void hil(int level, double deg) {
        if (level > 0) {
            robot.turnRight(deg);
            hil(level - 1, -deg);
            robot.moveForward(step);
            robot.turnLeft(deg);
            hil(level - 1, deg);
            robot.moveForward(step);
            hil(level - 1, deg);
            robot.turnLeft(deg);
            robot.moveForward(step);
            hil(level - 1, -deg);
            robot.turnRight(deg);
        }
    }
    public static void main(String[] args) {
        robot = new RobotModel();
        step = 10;

        RobotView view = new SimpleView();
        if (args.length > 0) {
            if (args[0].equals("--dot")) {
                view = new DotView();
            } else if (args[0].equals("--screen")) {
                view = new ScreenView();
            }
        }
        robot.setView(view);

        hil(5, 90.0);
    }
}
