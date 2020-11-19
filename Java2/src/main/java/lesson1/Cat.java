package lesson1;

public class Cat implements IMember {

    private final int MAX_RUN = 10;
    private final int MAX_JUMP = 5;
    private boolean onCourse;

    public Cat() {
        this.onCourse = true;
    }

    public String run(IObstacle treadmill) {
        int limit = treadmill.getLimit();
        if (limit > MAX_RUN) {
            this.onCourse = false;
            return String.format("Cat can't run for %d and stop", limit);
        }
        return String.format("Cat run %d", limit);
    }

    public String jump(IObstacle wall) {
        int limit = wall.getLimit();
        if (limit > MAX_JUMP) {
            this.onCourse = false;
            return String.format("Cat can't jump for %d and stop", limit);
        }
        return String.format("Cat jump %d", limit);
    }

    public void onStart() {
        this.onCourse = true;
    }

    public boolean isOnCourse() {
        return this.onCourse;
    }

}
