package lesson6;

public abstract class Animal {

    public float maxRun;
    public float maxSwim;
    public float maxJump;

    public void run(float len) {
        System.out.println("run: " + (len <= maxRun));
    }

    public void swim(float len) {
        System.out.println("swim: " + (len <= maxSwim));
    }

    public void jump(float h) {
        System.out.println("jump: " + (h <= maxJump));
    }
}
