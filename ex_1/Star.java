public class Star {
    public static void main(String[] args) {
        SimpleRobot robot = new SimpleRobot();
        for (int i = 0; i < 5; i++) {
            robot.moveForward(100);  // 「前へ100歩進め」
            robot.turnRight(144);     // 「右へ144度回れ」
        }
    }
}
