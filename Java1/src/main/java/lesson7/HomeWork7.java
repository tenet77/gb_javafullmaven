package lesson7;

public class HomeWork7 {

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        Plate plate = new Plate(30);

        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat_" + i, (int) (Math.random() * 15 + 1));
            cats[i].eat(plate);
            cats[i].printInfo();
        }
    }

}
