package main;

public class ShelterAnimal {

    private Animal animal;

    private final String name;
    private final int age;
    private final long inShelterSince;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public long isInShelterSince() {
        return inShelterSince;
    }
    public String getSpecies() {return animal.toString();}

    ShelterAnimal(Animal animal, String name, int age) {
        this.animal = animal;
        this.name = name;
        this.age = age;
        inShelterSince = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return getSpecies() + " " + getName() + " " + getAge();
    }
}
