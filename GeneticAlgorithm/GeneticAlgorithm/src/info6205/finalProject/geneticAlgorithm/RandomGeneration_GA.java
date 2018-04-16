/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.finalProject.geneticAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author Mayank Gangrade and Dhruv Sharma
 */
public class RandomGeneration_GA {

    //Converting strign solution to binary
    public static String stringToBinary(String text) {
        String bString = "";
        String temp = "";
        for (int i = 0; i < text.length(); i++) {
            temp = Integer.toBinaryString(text.charAt(i));
            for (int j = temp.length(); j < 8; j++) {
                temp = "0" + temp;
            }
            bString += temp;
        }

        System.out.println(bString);
        return bString;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int[] result = new int[5];
        //Setting a solution to be found in random generation
        result = ParallelProcess.parallel("Genetic algorithms");
        //Sorting the get the best thread with least generation
        Arrays.sort(result);
        
        System.out.println("Solution found by different threads in ascending order: ");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Genertion: " + result[i]);
        }

        System.out.println("***************************************************************");
        System.out.println("Minimum generation count to produce desired result : " + result[0]);
        System.out.println("***************************************************************");

    }
}
