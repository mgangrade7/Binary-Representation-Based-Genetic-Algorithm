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
public class Algorithm {

    /* GA parameters */
    private static final double rate_Mutation = .005;
    private static final int groupSize = 5;
    private static final boolean fittest = true;

    // Evolving a population
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // Keeping our best offspring()
        if (fittest) {
            newPopulation.storeOffspring(0, pop.getFittest());
        }

        // Population crossover
        int fittestOffset;
        if (fittest) {
            fittestOffset = 1;
        } else {
            fittestOffset = 0;
        }

        //Creating new offspring with crossover by looping over the population
        for (int i = fittestOffset; i < pop.size(); i++) {
            Individual i1 = groupSelection(pop);
            Individual i2 = groupSelection(pop);
            Individual newIndiv = crossover(i1, i2);
            newPopulation.storeOffspring(i, newIndiv);
        }

        // Mutating the population
        for (int i = fittestOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
    }

    // Crossover individuals
    private static Individual crossover(Individual i1, Individual i2) {
        Individual newSol = new Individual();

        for (int i = 0; i < i1.size(); i++) {

            if (Math.random() <= 0.5) {  // Maintaining uniform rate
                newSol.setGene(i, i1.getGene(i));
            } else {
                newSol.setGene(i, i2.getGene(i));
            }
        }
        BinaryToString(newSol.toString());
        return newSol;
    }

    // Mutating an individual
    private static void mutate(Individual indiv) {

        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= rate_Mutation) {
                // Create random gene
                byte gene = (byte) Math.round(Math.random());
                indiv.setGene(i, gene);
            }
        }
    }

    // Selecting individual for crossover
    private static Individual groupSelection(Population pop) {
        // Creating a group population

        Population group = new Population(groupSize, false);

        //for each place in a group getting a random individual
        for (int i = 0; i < groupSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            group.storeOffspring(i, pop.getIndividual(randomId));
        }
        // Getting the fittest

        Individual fittest = group.getFittest();
        return fittest;
    }

    public static String BinaryToString(String binaryCode) {
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 8; i < binaryCode.length(); i += 8, j += 8) {
            result.append(binaryCode.substring(i, j)).append(" ");
        }

        String resultToString = result.toString();

        String[] code = resultToString.split(" ");
        String word = "";
        for (String c : code) {
            word += (char) Integer.parseInt(c, 2);
        }

        System.out.println(word);
        return word;

    }

}
