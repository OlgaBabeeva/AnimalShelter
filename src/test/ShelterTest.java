package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ShelterTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testPutAnimalInShelter() throws Exception {
        Cat cat = new Cat();
        Shelter shelter = new Shelter();
        shelter.putAnimalInShelter(cat, "Mr. Fluffy", 3);

    }

    @Test
    public void testShowSpecificAnimalsInAlphabeticOrder() throws Exception {
        Cat cat = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog = new Dog();

        Shelter shelter = new Shelter();

        shelter.putAnimalInShelter(cat, "Mr. Fluffy", 3);
        shelter.putAnimalInShelter(cat2, "Snowflake", 5);
        shelter.putAnimalInShelter(cat3, "Achilles", 8);
        shelter.putAnimalInShelter(dog, "Rex", 12);

        List<ShelterAnimal> result = shelter.showSpecificAnimalsInAlphabeticOrder("Cat");

        assertEquals(result.get(0).toString(), "Cat Achilles 8");
        assertEquals(result.get(1).toString(), "Cat Mr. Fluffy 3");
        assertEquals(result.get(2).toString(), "Cat Snowflake 5");
        assertEquals(result.size(), 3);

    }

    @Test
    public void testGiveOutAnimal() throws Exception {

        Cat cat = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog = new Dog();

        Shelter shelter = new Shelter();

        shelter.putAnimalInShelter(cat, "Mr. Fluffy", 3);
        shelter.putAnimalInShelter(cat2, "Snowflake", 5);
        shelter.putAnimalInShelter(cat3, "Achilles", 8);
        shelter.putAnimalInShelter(dog, "Rex", 12);

        assertEquals(shelter.giveOutAnimal().toString(), "Cat Mr. Fluffy 3");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiveOutAnimal3() throws Exception {

        Shelter shelter = new Shelter();
        shelter.giveOutAnimal();

    }



    @Test
    public void testGiveOutAnimal1() throws Exception {
        Cat cat = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog = new Dog();
        Dog dog2 = new Dog();

        Shelter shelter = new Shelter();

        shelter.putAnimalInShelter(cat, "Mr. Fluffy", 3);
        shelter.putAnimalInShelter(cat2, "Snowflake", 5);
        shelter.putAnimalInShelter(cat3, "Achilles", 8);
        shelter.putAnimalInShelter(dog, "Rex", 12);
        shelter.putAnimalInShelter(dog, "Big Fido", 2);

        assertEquals(shelter.giveOutAnimal("Dog").toString(), "Dog Rex 12");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGiveOutAnimal2() throws Exception {

        Cat cat = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Dog dog = new Dog();

        Shelter shelter = new Shelter();

        shelter.putAnimalInShelter(cat, "Mr. Fluffy", 3);
        shelter.putAnimalInShelter(cat2, "Snowflake", 5);
        shelter.putAnimalInShelter(cat3, "Achilles", 8);
        shelter.putAnimalInShelter(dog, "Rex", 12);


        shelter.giveOutAnimal("Turtle");

    }

}