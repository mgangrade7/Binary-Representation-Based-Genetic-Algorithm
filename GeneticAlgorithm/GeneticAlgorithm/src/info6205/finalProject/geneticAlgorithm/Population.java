/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.finalProject.geneticAlgorithm;

/**
 *
 * @author Mayank Gangrade and Dhruv Sharma
 */
public class Population {

    Individual[] individuals;

    // Creating a population
    public Population(int populationSize, boolean init) {
        individuals = new Individual[populationSize];
        // Initializing the population
        if (init) {

            // Creating new individuals
            for (int i = 0; i < size(); i++) {
                Individual offpring = new Individual();
                offpring.generateIndividual();
                storeOffspring(i, offpring);
            }
        }
    }

    public Individual getIndividual(int index) {
        return individuals[index];
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Searching the fittest individual
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public int size() {
        return individuals.length;
    }

    // Saving the offspring
    public void storeOffspring(int index, Individual offspring) {
        individuals[index] = offspring;
    }
}
