package lesson6;

public class Dog extends Animal {

    private final float MAX_RUN = 500;
    private final float MAX_SWIM = 10;
    private final float MAX_JUMP = 0.5f;

    public Dog() {
        this.maxRun = MAX_RUN;
        this.maxSwim = MAX_SWIM;
        this.maxJump = MAX_JUMP;
    }

    public void setMaxRun(float newMaxRun) {
        this.maxRun = newMaxRun;
    }

}
