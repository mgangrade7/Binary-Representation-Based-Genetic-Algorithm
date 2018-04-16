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
public class FitnessCalculation {

    static int length;
    static byte[] solution = new byte[length];

    public static void setSolution(byte[] solutionNew) {
        solution = solutionNew;
    }

    public static void setLength(int len) {
        length = len;
    }

    //Setting candidate solution with string of 0s and 1s
    static void setSolution(String solutionNew) {
        solution = new byte[solutionNew.length()];

        for (int i = 0; i < solutionNew.length(); i++) {
            String variable = solutionNew.substring(i, i + 1);
            if (variable.contains("0") || variable.contains("1")) {
                solution[i] = Byte.parseByte(variable);
            } else {
                solution[i] = 0;
            }
        }
    }

    //By comparing candidate solution we are calculating individual's fitness
    static int getFitness(Individual individual) {
        int fitness = 0;
        // Camparing individual gene with our candidate solution

        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            if (individual.getGene(i) == solution[i]) {
                ++fitness;
            }
        }

        return fitness;
    }

    // Getting optimum fitness
    static int getOptimumFitness() {
        int optimumFitness = solution.length;
        return optimumFitness;
    }
}
