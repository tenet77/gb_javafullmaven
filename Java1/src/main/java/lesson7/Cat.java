package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate p) {
        if (p.getFood() > appetite) {
            p.decreaseFood(appetite);
            fullness = true;
        }
    }

    public void printInfo() {
        System.out.println("Name:" + name);
        System.out.println("Appetite: " + appetite);
        System.out.println("Fullness: " + fullness);
    }

    public boolean isFullness() {
        return fullness;
    }
}
