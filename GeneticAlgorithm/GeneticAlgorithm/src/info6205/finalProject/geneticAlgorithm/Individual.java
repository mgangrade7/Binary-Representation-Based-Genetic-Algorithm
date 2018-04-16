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
public class Individual {

    static int lengthGene;
    private byte[] genes = new byte[lengthGene];

    private int fitness = 0;

    // Setting default length of the gene
    public static void setDefaultLength(int len) {
        lengthGene = len;
    }

    // Creating a random individual
    public void generateIndividual() {
        for (int i = 0; i < size(); i++) {
            byte gene = (byte) Math.round(Math.random());
            genes[i] = gene;
        }
    }

    // Used when we want to create individual of different gene length
    public static void setDefaultGeneLength(int length) {
        lengthGene = length;
    }

    public byte getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, byte value) {
        genes[index] = value;
        fitness = 0;
    }

    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalculation.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
