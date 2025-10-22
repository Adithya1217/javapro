// File: ZooManagementSystem.java

import java.util.Scanner;

// Animal interface with two methods
interface Animal {
    void makeSound();
    void eat();
}

// Lion class implementing Animal interface
class Lion implements Animal {
    public void makeSound() {
        System.out.println("Lion: Roar!");
    }
    public void eat() {
        System.out.println("Lion is eating meat.");
    }
}

// Elephant class implementing Animal interface
class Elephant implements Animal {
    public void makeSound() {
        System.out.println("Elephant: Trumpet!");
    }
    public void eat() {
        System.out.println("Elephant is eating grass.");
    }
}

// Monkey class implementing Animal interface
class Monkey implements Animal {
    public void makeSound() {
        System.out.println("Monkey: Ooh ooh aah aah!");
    }
    public void eat() {
        System.out.println("Monkey is eating bananas.");
    }
}

public class ZooManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal animal = null;

        System.out.println("Welcome to the Zoo Management System!");
        System.out.println("Which animal would you like to interact with?");
        System.out.println("1. Lion");
        System.out.println("2. Elephant");
        System.out.println("3. Monkey");
        System.out.print("Enter your choice (1-3): ");

        int choice = scanner.nextInt();

        // Choose the animal based on user input
        switch (choice) {
            case 1:
                animal = new Lion();
                break;
            case 2:
                animal = new Elephant();
                break;
            case 3:
                animal = new Monkey();
                break;
            default:
                System.out.println("Invalid choice. Exiting program.");
                System.exit(0);
        }

        // Interact with the chosen animal
        animal.makeSound();
        animal.eat();

        scanner.close();
    }
}
