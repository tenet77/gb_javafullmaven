package lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage{

    private final Semaphore sm;

    public Tunnel(Semaphore sm) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        this.sm = sm;
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                sm.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
                sm.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
