package lesson1;

public class Course {

    private final IObstacle[] courses;

    public Course(IObstacle[] courses) {
        this.courses = new IObstacle[courses.length];
        System.arraycopy(courses, 0, this.courses, 0, courses.length);
    }

    public void dolt(Team t) {
        for (IObstacle i : courses) {
            t.passCourse(i);
        }
    }
}
