package lesson1;

public class Robot implements IMember {

    private final int MAX_RUN = 50;
    private final int MAX_JUMP = 3;
    private boolean onCourse;

    public Robot() {
        this.onCourse = true;
    }

    public String run(IObstacle treadmill) {
        int limit = treadmill.getLimit();
        if (limit > MAX_RUN) {
            this.onCourse = false;
            return String.format("Robot can't run for %d and stop", limit);
        }
        return String.format("Robot run %d", limit);
    }

    public String jump(IObstacle wall) {
        int limit = wall.getLimit();
        if (limit > MAX_JUMP) {
            this.onCourse = false;
            return String.format("Robot can't jump for %d and stop", limit);
        }
        return String.format("Robot jump %d", limit);
    }

    public void onStart() {
        this.onCourse = true;
    }

    public boolean isOnCourse() {
        return this.onCourse;
    }

}
