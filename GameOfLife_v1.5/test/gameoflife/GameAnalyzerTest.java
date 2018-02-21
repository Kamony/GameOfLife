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
public class GameAnalyzerTest {
    
    public GameAnalyzerTest() {
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
     * Test of getNumberOfCells method, of class GameAnalyzer.
     */
    @Test
    public void testGetNumberOfCells() {
        System.out.println("getNumberOfCells");
        boolean[][] currentMove = { {false,false,false},
                                    {false,true,false},
                                    {false,false,false}    
        };
        GameAnalyzer instance = new GameAnalyzer(3, 3);
        int expResult = 1;
        int result = instance.getNumberOfCells(currentMove);
        assertEquals(expResult, result);
        
        boolean[][] currentMove2 = { {false,false,false},
                                    {false,false,false},
                                    {false,false,false}    
        };
        GameAnalyzer instance2 = new GameAnalyzer(3, 3);
        int expResult1 = 0;
        int result1 = instance.getNumberOfCells(currentMove2);
        assertEquals(expResult1, result1);
        
    }

    /**
     * Test of getNumberOfBlinkers method, of class GameAnalyzer.
     */
    @Test
    public void testGetNumberOfBlinkers() {
        System.out.println("getNumberOfBlinkers");
        boolean[][] currentMove = { {false,false,false},
                                    {false,true,false},
                                    {false,true,false},
                                    {false,true,false},
                                    {false,false,false}
        };
        GameAnalyzer instance = new GameAnalyzer(4, 3);
        int expResult = 1;
        int result = instance.getNumberOfBlinkers(currentMove);
        assertEquals(expResult, result);
        
        boolean[][] currentMove2 = { {true,false,false},
                                    {false,true,false},
                                    {false,true,false},
                                    {false,true,false},
                                    {false,false,false}
        };
        GameAnalyzer instance2 = new GameAnalyzer(4, 3);
        int expResult2 = 0;
        int result2 = instance.getNumberOfBlinkers(currentMove2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getNumberOfStatics method, of class GameAnalyzer.
     */
    @Test
    public void testGetNumberOfStatics() {
        System.out.println("getNumberOfStatics");
        boolean[][] currentMove = { {false,false,false,false},
                                    {false,true,true,false},
                                    {false,true,true,false},
                                    {false,false,false,false}
        };
        GameAnalyzer instance = new GameAnalyzer(4, 4);
        int expResult = 1;
        int result = instance.getNumberOfStatics(currentMove);
        assertEquals(expResult, result);
        
        boolean[][] currentMove2 = { {true,false,false,false},
                                    {false,true,true,false},
                                    {false,true,true,false},
                                    {false,false,false,false}
        };
        GameAnalyzer instance2 = new GameAnalyzer(4, 4);
        int expResult2 = 0;
        int result2 = instance.getNumberOfStatics(currentMove2);
        assertEquals(expResult2, result2);
    }
    
}
