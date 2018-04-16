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
 * @author Mayank
 */
public class RandomGeneration_GATest {
 
    /**
     * Test of stringToBinary method, of class RandomGeneration_GA.
     */
    @Test
    public void testStringToBinary() {
        System.out.println("stringToBinary");
        String text = "algorithm";
        String expResult = "011000010110110001100111011011110111001001101001011101000110100001101101";
        String result = RandomGeneration_GA.stringToBinary(text);
        assertEquals(expResult, result);
    }


    
}
