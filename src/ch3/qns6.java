package ch3;

import java.util.LinkedList;
import java.util.Queue;

class Animal {
    public enum TYPE {
        DOG,
        CAT
    }

    public TYPE type;
    public boolean deleted;
    public Animal(TYPE animalType) {
        this.type = animalType;
        this.deleted = false;
    }

    public String toString() {
        return "This is a " + type.toString();
    }
}

/**
 * Animal Shelter
 * An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
 * out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
 * that type). They cannot select which specific animal they would like. Create the data structures to
 * maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
 * and dequeueCat. You may use the built-in Linked List data structure.
 *
 * Time: O(1)
 * Space: O(N)
 */
class AnimalShelter {
    Queue<Animal> any, dog, cat;

    public AnimalShelter() {
        any = new LinkedList<Animal>();
        dog = new LinkedList<Animal>();
        cat = new LinkedList<Animal>();
    }

    public void enqueue(Animal animal) {
        any.offer(animal);
        if (animal.type == Animal.TYPE.DOG) {
            dog.offer(animal);
        } else {
            cat.offer(animal);
        }
    }

    public Animal dequeuAny() {
        if (any.isEmpty()) {
            return null;
        }
        while(any.peek().deleted == true) {
            any.poll();
        }
        Animal animal = any.poll();
        if (animal.type == Animal.TYPE.DOG) {
            dog.poll();
        } else {
            cat.poll();
        }
        return animal;
    }

    public Animal dequeueDog() {
        if (dog.isEmpty()) {
            return null;
        }
        Animal animal = dog.poll();
        animal.deleted = true;
        return animal;
    }

    public Animal dequeueCat() {
        if (cat.isEmpty()) {
            return null;
        }
        Animal animal = cat.poll();
        animal.deleted = true;
        return animal;
    }
}

public class qns6 {
    public static void run() {
        AnimalShelter shelter = new AnimalShelter();

        System.out.println("Given shelter of 1 cat");
        shelter.enqueue(createCat());
        System.out.print("Dequeueing dog: ");
        System.out.println(shelter.dequeueDog());
        System.out.print("Dequeueing cat: ");
        System.out.println(shelter.dequeueCat());
        System.out.print("Dequeueing any: ");
        shelter.enqueue(createCat());
        System.out.println(shelter.dequeuAny());

        System.out.println("===");

        System.out.println("Given shelter of CCDC");
        shelter.enqueue(createCat());
        shelter.enqueue(createCat());
        shelter.enqueue(createDog());
        shelter.enqueue(createCat());

        System.out.print("Dequeueing dog: ");
        System.out.println(shelter.dequeueDog());
        System.out.print("Dequeueing cat: ");
        System.out.println(shelter.dequeueCat());
        System.out.print("Dequeueing cat: ");
        System.out.println(shelter.dequeueCat());
        System.out.print("Dequeueing dog: ");
        System.out.println(shelter.dequeueDog());
        System.out.print("Dequeueing any: ");
        System.out.println(shelter.dequeuAny());
        System.out.print("Dequeueing any: ");
        System.out.println(shelter.dequeuAny());
    }

    private static Animal createDog() {
        return new Animal(Animal.TYPE.DOG);
    }

    private static Animal createCat() {
        return new Animal(Animal.TYPE.CAT);
    }
}
