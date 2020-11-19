package lesson1;

public class Wall implements IObstacle{
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getLimit() {
        return height;
    }
}
