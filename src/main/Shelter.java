package main;

import java.util.*;
import java.util.stream.Collectors;

public class Shelter {

    List<ShelterAnimal> shelteredAnimals = new ArrayList<>();

    /**
     * Checks if given animal's species can be in shelter.
     * Creates ShelterAnimal object from given Animal objects, "names it" and "defines its age".
     * Name and age are impossible to change after.
     * Adds time of creation to ShelterAnimal object (as time when animal appeared in shelter)
     * to use for determining which ShelterAnimal should be given to human.
     *
     * @param animal animal that should be in shelter (can be Cat, Dog or Turtle)
     * @param name   name given to animal in the shelter
     * @param age    age of animal skillfully determined in shelter
     */
    public void putAnimalInShelter(Animal animal, String name, int age) {
        checkSpecies(animal.getClass().getSimpleName());

        shelteredAnimals.add(new ShelterAnimal(animal, name, age));
    }

    /**
     * Returns list of specified animals sorted by name. Throws exception if there are no such animals.
     *
     * @param animalSpecies can be "Cat", "Dog" or "Turtle"
     * @return
     */
    public List<ShelterAnimal> showSpecificAnimalsInAlphabeticOrder(String animalSpecies) {
        checkSpecies(animalSpecies);

        return shelteredAnimals.stream()
                .filter(a -> a.getSpecies().equals(animalSpecies))
                .sorted((a1, a2) -> a1.getName().compareTo(a2.getName()))
                .collect(Collectors.toList());
    }

    /**
     * Returns unspecified animal that was in the shelter for the longest time.
     * Throws exception if there are no animals.
     *
     * @return
     */
    public ShelterAnimal giveOutAnimal() {

        Optional<ShelterAnimal> longestInShelterAnimal = shelteredAnimals.stream()
                .min((a1, a2) -> Long.compare(a1.isInShelterSince(), a2.isInShelterSince()));

        if (longestInShelterAnimal.isPresent()) {
            ShelterAnimal animal = longestInShelterAnimal.get();
            shelteredAnimals.remove(animal);
            return animal;
        } else {
            throw new IllegalArgumentException("There is not such animals in this shelter.");
        }
    }

    /**
     * Returns specified animal that was in the shelter for the longest time.
     * Throws exception if there are no such animals.
     *
     * @param animalSpecies
     * @return
     */
    public ShelterAnimal giveOutAnimal(String animalSpecies) {

        checkSpecies(animalSpecies);

        Optional<ShelterAnimal> longestInShelterAnimal = shelteredAnimals.stream()
                .filter(a -> a.getSpecies().equals(animalSpecies))
                .min((a1, a2) -> Long.compare(a1.isInShelterSince(), a2.isInShelterSince()));

        if (longestInShelterAnimal.isPresent()) {
            ShelterAnimal animal = longestInShelterAnimal.get();
            shelteredAnimals.remove(animal);
            return animal;
        } else {
            throw new IllegalArgumentException("There is not such animals in this shelter.");
        }
    }

    private void checkSpecies(String animalSpecies) {

        if (animalSpecies.equals("Cat") && animalSpecies.equals("Dog") && animalSpecies.equals("Turtle")) {
            throw new IllegalArgumentException("Sorry, this is not shelter for " + animalSpecies);
        }
    }

}
