/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.finalProject.geneticAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import static info6205.finalProject.geneticAlgorithm.RandomGeneration_GA.stringToBinary;

/**
 *
 * @author Mayank Gangrade and Dhruv Sharma
 */
public class ParallelProcess {

    //Creating 5 threads through CompletableFuture class for gettign optimum solution
    @SuppressWarnings("empty-statement")
    public static int[] parallel(String input) throws InterruptedException, ExecutionException {
        System.out.println("Thread 1 : Start");
        CompletableFuture<Integer> parallelProcess1 = parallelProcess(input);
        System.out.println("Thread 2 : Start");
        CompletableFuture<Integer> parallelProcess2 = parallelProcess(input);
        System.out.println("Thread 3 : Start");
        CompletableFuture<Integer> parallelProcess3 = parallelProcess(input);
        System.out.println("Thread 4 : Start");
        CompletableFuture<Integer> parallelProcess4 = parallelProcess(input);
        System.out.println("Thread 5 : Start");
        CompletableFuture<Integer> parallelProcess5 = parallelProcess(input);

        return new int[]{parallelProcess1.get(), parallelProcess2.get(), parallelProcess3.get(),
            parallelProcess4.get(), parallelProcess5.get()};

    }

    private static CompletableFuture<Integer> parallelProcess(String inp) {
        return CompletableFuture.supplyAsync(
                () -> {
                    String input = inp;

                    // Setting the length of the solution
                    FitnessCalculation.setLength(input.length());

                    // Setting the Gene length 
                    Individual.setDefaultGeneLength(input.length() * 8);

                    // Setting the candidate solution
                    FitnessCalculation.setSolution(stringToBinary(input));

                    // Creating an initial population
                    Population myPop = new Population(50, true);

                    // Evolving our population until we reach an optimum solution
                    int generationCount = 0;
                    while (myPop.getFittest().getFitness() < FitnessCalculation.getOptimumFitness()) {
                        generationCount++;
                        System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
                        myPop = Algorithm.evolvePopulation(myPop);
                    }
                    System.out.println("===============================================================");
                    System.out.println("Solution found!");
                    System.out.println("Generation: " + generationCount);
                    System.out.println("Genes:");
                    System.out.println(myPop.getFittest());
                    System.out.println("===============================================================");
                    return generationCount;
                }
        );
    }

}
