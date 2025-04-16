package Comparable.task2;

public class Animal implements Comparable<Animal> {

    private String species;
    private double weight;

    public Animal(String species, double weight) {
        this.species = species;
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Animal animalToCompare) {
        double delta = this.weight - animalToCompare.weight;
        if (delta > 0) return 1;
        else if (delta < 0) return -1;
        else return 0;
    }

}
