package pkg5_classes_objects;

public class Car {

    String brand;
    String model;
    int hp;
    int year;

    Car(String newBrand, String newModel, int newHP, int newYear) {
        brand = newBrand;
        model = newModel;
        hp = newHP;
        year = newYear;
    }

    public int insuranceCategory() {
        int currentYear = 2017;
        int yearsOld = currentYear - this.year;
        if (yearsOld <= 8) {
            return 1;
        } else if (yearsOld > 8 && yearsOld <= 15) {
            return 2;

        } else if (yearsOld > 15 && yearsOld <= 25) {
            return 3;
        } else {
            return 4;
        }

    }

    public double tax() {
        double price = 0;
        int category = insuranceCategory();
        switch (category) {
            case 1:
                price = 150;
                break;
            case 2:
                price = 200;
                break;
            case 3:
                price = 300;
                break;
            case 4:
                price = 400;
                break;
        }
        if (this.hp < 80) {
            price *= 1.2;
        } else if (this.hp > 140) {
            price *= 1.45;
        }

        return price;

    }

    public static void main(String[] args) {
        Car c = new Car("Mercedes", "S", 160, 2009);
        System.out.println(c.tax());

    }

}
