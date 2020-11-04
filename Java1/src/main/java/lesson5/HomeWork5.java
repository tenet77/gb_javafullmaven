package lesson5;

public class HomeWork5 {

    public static void main(String[] args) {
        Person[] person = new Person[5];

        person[0] = new Person("Ivan", "dev", "1@1.com",
                "+7 (777) 777-77-77", 10000, 34);
        person[1] = new Person("Piotr", "dev", "2@1.com",
                "+7 (777) 777-99-77", 10000, 23);
        person[2] = new Person("Sorin", "sysop", "3@1.com",
                "+7 (777) 777-77-88", 9000, 22);
        person[3] = new Person("Mozes", "director", "4@1.com",
                "+7 (777) 555-77-77", 20000, 45);
        person[4] = new Person("Jhon", "cleaner", "5@1.com",
                "+7 (777) 777-67-77", 8000, 55);

        for (Person i:person) {
            if (i.getAge() > 40) i.printInfo();
        }
    }

}