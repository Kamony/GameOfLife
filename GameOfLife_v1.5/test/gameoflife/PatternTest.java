/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jirka
 */
public class PatternTest {
    
    public PatternTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of enterSquare method, of class Pattern.
     */
    @Test
    public void testEnterSquare() {
        System.out.println("enterSquare");
        int x = 1;
        int y = 1;
        boolean[][] currentMove = { {false,false,false,false},
                                    {false,false,false,false},
                                    {false,false,false,false},
                                    {false,false,false,false}
        };
        Pattern instance = new Pattern();
        instance.enterSquare(x, y, currentMove, true);
        assertEquals(true, currentMove[x][y]);
        assertEquals(true, currentMove[x][y+1]);
        assertEquals(false, currentMove[x][y+2]);
        assertEquals(true, currentMove[x-1][y]);
        assertEquals(true, currentMove[x-1][y+1]);
        assertEquals(false, currentMove[x-1][y+2]);
    }

    
}
