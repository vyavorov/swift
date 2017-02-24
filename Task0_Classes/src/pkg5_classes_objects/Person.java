package pkg5_classes_objects;

public class Person {

    String name;
    int age;

    Person() {
        name = "No name";
        age = -1;
    }

    Person(String newName) {
        name = newName;
        age = -1;
    }

    Person(String newName, int newAge) {
        name = newName;
        if (newAge < 0 || newAge > 150) {
            System.out.println("Something is wrong. Your age is invalid.");
        } else {
            age = newAge;
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        if (name.equals("No name") && age == -1) {
            return "I am John doe";
        } else if (age == -1) {
            return "I am " + name;
        } else {
            return String.format("I am %s. I am %d years old", name, age);
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Ventsi", 21);
        System.out.println(person.getDescription());
    }

}
