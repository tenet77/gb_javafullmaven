package lesson1;

public interface IMember {

    String run(IObstacle treadmill);
    String jump(IObstacle wall);
    void onStart();
    boolean isOnCourse();

}
