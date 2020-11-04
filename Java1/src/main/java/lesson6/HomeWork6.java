package lesson6;

public class HomeWork6 {

    public static void main(String[] args) {

        Animal cat1 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();

        dog2.setMaxRun(600);

        cat1.jump(150);
        dog1.run(500);
        dog1.run(550);
        dog2.run(550);

    }
}
