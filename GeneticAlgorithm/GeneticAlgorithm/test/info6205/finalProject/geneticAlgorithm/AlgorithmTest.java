/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.finalProject.geneticAlgorithm;

import info6205.finalProject.geneticAlgorithm.Algorithm;
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
public class AlgorithmTest {

    /**
     * Test of BinaryToString method, of class Algorithm.
     */
    @Test
    public void testBinaryToString1() {
        System.out.println("BinaryToString");
        String binaryCode = "011000010110110001100111011011110111001001101001011101000110100001101101";
        String expResult = "algorithm";
        String result = Algorithm.BinaryToString(binaryCode);
        assertEquals(expResult, result);
    }

    @Test(expected = NumberFormatException.class)
    public void testBinaryToString2() {
        System.out.println("BinaryToString");
        String binaryCode = "12345678";
        String expResult = "algorithm";
        String result = Algorithm.BinaryToString(binaryCode);
        assertEquals(expResult, result);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void testBinaryToString3() {
        System.out.println("BinaryToString");
        String binaryCode = "algorithm";
        String expResult = "algorithm";
        String result = Algorithm.BinaryToString(binaryCode);
        assertEquals(expResult, result);
    }
}
