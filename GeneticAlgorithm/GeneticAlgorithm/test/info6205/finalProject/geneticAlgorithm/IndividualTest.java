/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.finalProject.geneticAlgorithm;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mayank Gangrade and Dhruv Sharma
 */
public class IndividualTest {

    /**
     * Test of setDefaultLength method, of class Individual.
     */
    @Test
    public void testSetDefaultLength() {
        System.out.println("setDefaultLength");
        int len = 0;
        Individual.setDefaultLength(len);
    }

    /**
     * Test of generateIndividual method, of class Individual.
     */
    @Test
    public void testGenerateIndividual() {
        System.out.println("generateIndividual");
        Individual instance = new Individual();
        instance.generateIndividual();
    }

    /**
     * Test of getFitness method, of class Individual.
     */
    @Test
    public void testGetFitness() {
        System.out.println("getFitness");
        Individual instance = new Individual();
        int expResult = 0;
        int result = instance.getFitness();
        assertEquals(expResult, result);

    }

}
