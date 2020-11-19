package lesson1;

public class Human implements IMember {

    private final int MAX_RUN = 30;
    private final int MAX_JUMP = 20;
    private boolean onCourse;

    public Human() {
        this.onCourse = true;
    }

    public String run(IObstacle treadmill) {
        int limit = treadmill.getLimit();
        if (limit > MAX_RUN) {
            this.onCourse = false;
            return String.format("Human can't run for %d and stop", limit);
        }
        return String.format("Human run %d", limit);
    }

    public String jump(IObstacle wall) {
        int limit = wall.getLimit();
        if (limit > MAX_JUMP) {
            this.onCourse = false;
            return String.format("Human can't jump for %d and stop", limit);
        }
        return String.format("Human jump %d", limit);
    }

    public void onStart() {
        this.onCourse = true;
    }

    public boolean isOnCourse() {
        return this.onCourse;
    }
}
