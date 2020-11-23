package lesson1;

public class Treadmill implements IObstacle{
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLimit() {
        return length;
    }
}
