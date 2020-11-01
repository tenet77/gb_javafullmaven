package lesson5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String _name, String _position, String _email,
                  String _phone, int _salary, int _age) {
        this.name = _name;
        this.position = _position;
        this.email = _email;
        this.phone = _phone;
        this.salary = _salary;
        this.age = _age;
    }

    public void printInfo() {
        System.out.printf("Name: %1$s\n" +
                        "Position: %2$s\n" +
                        "Email: %3$s\n" +
                        "Phone: %4$s\n" +
                        "Salary: %5$d\n" +
                        "Age: %6$d\n",
                this.name,
                this.position,
                this.email,
                this.phone,
                this.salary,
                this.age);
        System.out.println();
    }

    public int getAge() {
        return this.age;
    }
}