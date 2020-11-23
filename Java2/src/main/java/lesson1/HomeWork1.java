package lesson1;


public class HomeWork1 {

    public static void main(String[] args) {

        IMember[] part = new IMember[5];
        part[0] = new Cat();
        part[1] = new Cat();
        part[2] = new Human();
        part[3] = new Robot();
        part[4] = new Cat();

        Team t = new Team("Bravo", part);

        IObstacle[] obstacles = new IObstacle[3];
        obstacles[0] = new Treadmill(10);
        obstacles[1] = new Wall(20);
        obstacles[2] = new Treadmill(5);

        Course c = new Course(obstacles);

        t.initCourseLog();
        t.onStart();
        c.dolt(t);
        t.showResults();

    }
}
